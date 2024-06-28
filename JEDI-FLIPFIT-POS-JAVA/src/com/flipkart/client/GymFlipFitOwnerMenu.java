package com.flipkart.client;

import com.flipkart.business.FlipFitGymOwnerInterface;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;
import java.util.*;

public class GymFlipFitOwnerMenu {

	public static void login(String email, String password)
	{
		FlipFitUserInterface user = new FlipFitUserService();
		int userId = user.authenticateUser(email, password, 2);

		if(userId >0)
		{
			System.out.println("Logged in as Gym Owner");
			displayGymOwnerOptions(userId);
		}
		else{
			System.out.println("Invalid credentials");
		}
	}

	public static void displayGymOwnerOptions(int userId) {

		FlipFitGymOwnerInterface gymOwnerService = new FlipFitGymOwnerService();
		 boolean flag = true;

		do {
			System.out.println("GymOwnerMenu:\n 1.Register a Gym\n 2.Edit Gym details\n 3.Remove a Gym\n " +
							"4.Add new slot\n 5.Remove slot\n 6.View Available slots\n 7.View All Bookings\n " +
							"8.View Bookings for a Gym\n 9.View all Registered Gyms\n 10.Edit Profile\n 11.Exit");

			Scanner in = new Scanner(System.in);
			int i = in.nextInt();
			String name, location, temp, slotTime, panNum, gstNum, phoneNumber, address;
			int gymId,slotId,slotCapacity;

			switch(i){
				case 1:
					 temp = in.nextLine();
					System.out.println("Enter gym name");
					 name = in.nextLine();
					System.out.println("Enter location");
					 location = in.nextLine();
					gymOwnerService.registerGym(userId, name, location);
					break;
				case 2:
					System.out.println("Enter gym id of gym to be modified");
					 gymId = in.nextInt();
					 temp = in.nextLine();
					System.out.println("Enter gym name");
					 name = in.nextLine();
					System.out.println("Enter location");
					 location = in.nextLine();
					gymOwnerService.editGym(gymId, name, location);
					break;
				case 3:
					System.out.println("Enter gym id of gym to be removed");
					gymId = in.nextInt();
					gymOwnerService.removeGym(gymId);
					break;
				case 4:
					System.out.println("Enter gym id ");
					gymId = in.nextInt();
					System.out.println("Enter slot id ");
					slotId = in.nextInt();
					temp = in.nextLine();
					System.out.println("Enter slot timings");
					slotTime = in.nextLine();
					System.out.println("Enter slot capacity");
					slotCapacity = in.nextInt();
					gymOwnerService.addSlot(gymId, slotId, slotTime, slotCapacity);
					break;
				case 5:
					System.out.println("Enter gym id ");
					gymId = in.nextInt();
					System.out.println("Enter slot id ");
					slotId = in.nextInt();
					gymOwnerService.removeSlot(gymId, slotId);
					break;
				case 6:
					System.out.println("Enter gym id ");
					gymId = in.nextInt();
					System.out.println("Enter the date of the slot");
					String date = in.nextLine();
					gymOwnerService.viewAvailableSlots(gymId,date);
					break;
				case 7:
					gymOwnerService.viewAllBookings(userId);
					break;
				case 8:
					System.out.println("Enter gym id ");
					gymId = in.nextInt();
					gymOwnerService.viewBookings(gymId);
					break;
				case 9:
					gymOwnerService.viewAllRegisteredGymCenters(userId);
					break;
				case 10:
					 temp = in.nextLine();
					System.out.println("Enter your name");
					 name = in.nextLine();
					System.out.println("Enter your phone number");
					 phoneNumber = in.nextLine();
					System.out.println("Enter your address");
					 address = in.nextLine();
					System.out.println("Enter your Pan Number");
					 panNum = in.next();
					System.out.println("Enter your GST Number");
					 gstNum = in.next();
					gymOwnerService.editProfile(userId, name, phoneNumber, address, panNum, gstNum);
					break;
				case 11:
					System.out.println("Thank you for using FlipFit Application");
					flag = false;
					break;
				default:
					System.out.println("Invalid option");
			}

		} while(flag);

	}
}