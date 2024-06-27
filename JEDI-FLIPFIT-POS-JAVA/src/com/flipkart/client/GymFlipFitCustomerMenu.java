package com.flipkart.client;
import com.flipkart.business.BookingGymInterface;
import com.flipkart.business.BookingGymService;
import com.flipkart.business.FlipFitCustomerInterface;
import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;

import java.util.*;

public class GymFlipFitCustomerMenu {

	public static void login(String email, String password)
	{
		FlipFitUserInterface user = new FlipFitUserService();
		int userId = user.authenticateUser(email, password, 1);
		if(userId > 0)
		{
			System.out.println("Logged in as Customer");
			displayCustomerOptions(userId);
		}
		else{
			System.out.println("Invalid credentials");
		}
	}
   
	public static void displayCustomerOptions(int userId){
		FlipFitCustomerInterface userService = new FlipFitCustomerService();
		BookingGymInterface bookingService = new BookingGymService();

		boolean flag = true;
		do{
			System.out.println("Welcome to FlipFit Customer Page");
			System.out.println("Customer Menu: \n1. Edit your Profile\n2. View all Gyms\n3. View available Slots\n4. Filter Slots\n5. Book your slot\n6. View your bookings\n7. Cancel your bookings\n8. Exit");

			Scanner in = new Scanner(System.in);
			int i = in.nextInt();

			switch (i) {
				case 1:
					userService.editProfile();
					break;
				case 2:
					userService.viewGyms();
					break;
				case 3:
					userService.viewSlots();
					break;
				case 4:
					userService.filterSlots();
					break;
				case 5:
					bookingService.makePayment(userId);
					bookingService.bookSlots(userId);
					break;
				case 6:
					bookingService.viewBookings(userId);
					break;
				case 7:
					bookingService.cancelBookings();
					break;
				case 8:
					System.out.println("Thank you for using FlipFit App");
					flag = false;
					break;
				default:
					System.out.println("Invalid option");
			}
		} while(flag);
		
	  }
}
