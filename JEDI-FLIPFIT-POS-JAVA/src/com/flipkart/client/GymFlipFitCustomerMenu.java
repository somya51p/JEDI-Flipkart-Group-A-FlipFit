package com.flipkart.client;
import com.flipkart.business.BookingGymInterface;
import com.flipkart.business.BookingGymService;
import com.flipkart.business.FlipFitCustomerInterface;
import com.flipkart.business.FlipFitCustomerService;

import java.util.*;

public class GymFlipFitCustomerMenu {
   
	public static void displayCustomerOptions(){
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
<<<<<<< Updated upstream
					bookingService.bookSlots();
					bookingService.makePayment(); //it should come under book slot
=======
					String temp2 = in.nextLine();
					System.out.println("Enter your payment mode");
					String modeOfPayment = in.nextLine();
					System.out.println("Enter your payment details");
					String paymentDetails = in.nextLine();
					System.out.println("Enter your payment date");
					String expiryDate = in.nextLine();
					int transactionId = bookingService.makePayment(userId, paymentDetails, expiryDate, modeOfPayment);
					System.out.println("Enter gym id");
					int gymId = in.nextInt();
					System.out.println("Enter booking date");
					String temp3 = in.nextLine();
					String bookingDate = in.nextLine();
					System.out.println("Enter booking time slot");
					String bookingTimeSlot = in.nextLine();
					String bookingType = "Confirmed";
					int bookingAmount = 100;
					bookingService.createBooking(userId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
>>>>>>> Stashed changes
					break;
				case 6:
					bookingService.viewBookings();
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
