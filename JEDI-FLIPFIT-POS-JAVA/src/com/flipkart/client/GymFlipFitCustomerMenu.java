package com.flipkart.client;
import com.flipkart.business.BookingGymInterface;
import com.flipkart.business.BookingGymService;
import com.flipkart.business.FlipFitCustomerInterface;
import com.flipkart.business.FlipFitCustomerService;

import java.util.*;

public class GymFlipFitCustomerMenu {
   
	public static void displayCustomerOptions(String[] Args){
		FlipFitCustomerInterface userService = new FlipFitCustomerService();
		BookingGymInterface bookingService = new BookingGymService();

		boolean flag = true;

		do{
			System.out.println("Welcome to FlipFit Customer Page");
			System.out.println("Customer Menu: \n1. Edit your Profile\n2. View all Gyms\n3. View available Slots\n 4. Filter Slots\n5. Book your slot\n6. View your bookings\n7. Cancel your bookings\n8. Exit");

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
					bookingService.bookSlots();
					bookingService.makePayment(); //it should come under book slot
					break;
				case 6:
					bookingService.viewBookings();
					break;
				case 7:
					bookingService.cancelBookings();
					break;
				case 8:
					System.out.println("Thank you for using FlipFit Customer Page");
					flag = false;
					break;
				default:
					System.out.println("Invalid option");
			}
		} while(flag);
		
	  }
}
