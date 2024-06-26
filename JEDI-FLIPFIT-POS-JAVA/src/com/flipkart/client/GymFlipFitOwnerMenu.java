package com.flipkart.client;

import com.flipkart.business.FlipFitGymOwnerInterface;
import com.flipkart.business.FlipFitGymOwnerService;
import java.util.*;

public class GymFlipFitOwnerMenu {

	public static void displayGymOwnerOptions() {

		FlipFitGymOwnerInterface gymOwnerService = new FlipFitGymOwnerService();
		 boolean flag = true;

		do {
			System.out.println("GymOwnerMenu:\n 1.Register a Gym\n 2.Edit Gym details\n 3.Remove a Gym\n " +
							"4.Add new slot\n 5.Remove slot\n 6.View Available slots\n 7.View All Bookings\n " +
							"8.View Bookings for a Gym\n 9.View all Registered Gyms\n 10.Edit Profile\n 11.Exit");

			Scanner in = new Scanner(System.in);
			int i = in.nextInt();

			switch(i){
				case 1:
					gymOwnerService.registerGym(101, "Fitness Center A", "Downtown");
					break;
				case 2:
					gymOwnerService.editGym(101);
					break;
				case 3:
					gymOwnerService.removeGym(101);
					break;
				case 4:
					gymOwnerService.addSlot(101, 1);
					break;
				case 5:
					gymOwnerService.removeSlot(101, 1);
					break;
				case 6:
					gymOwnerService.viewAvailableSlots(101);
					break;
				case 7:
					gymOwnerService.viewAllBookings();
					break;
				case 8:
					gymOwnerService.viewBookings(101);
					break;
				case 9:
					gymOwnerService.viewAllRegisteredGymCenters();
					break;
				case 10:
					gymOwnerService.editProfile(1, "John Doe", "john.doe@example.com", "9876543210", "password", "123 Street, City",
							"ABCDE1234F","GST1234567","Approved");
					break;
				case 11:
					flag = false;
					break;
				default:
					System.out.println("Invalid option");
			}

		} while(flag);

	}
}