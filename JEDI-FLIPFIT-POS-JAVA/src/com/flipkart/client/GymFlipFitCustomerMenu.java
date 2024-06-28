package com.flipkart.client;
import com.flipkart.business.BookingGymInterface;
import com.flipkart.business.BookingGymService;
import com.flipkart.business.FlipFitCustomerInterface;
import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.*;

public class GymFlipFitCustomerMenu {

	public static void login(String email, String password) throws UserNotFoundException {
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
   
	public static void displayCustomerOptions(int userId) throws UserNotFoundException {
		FlipFitCustomerInterface customerService = new FlipFitCustomerService();
		BookingGymInterface bookingService = new BookingGymService();

		boolean flag = true;
		do{
			System.out.println("Welcome to FlipFit Customer Page");
			System.out.println("Customer Menu: \n1. Edit your Profile\n2. View all Gyms\n3. View available Slots\n4. Filter Slots\n5. Book your slot\n6. View your bookings\n7. Cancel your bookings\n8. Exit");

			Scanner in = new Scanner(System.in);
			int i = in.nextInt();
			int gymId;
			String date;

			switch (i) {
				case 1:
					String temp = in.nextLine();
					System.out.println("Enter your name");
					String name = in.nextLine();
					System.out.println("Enter your phone number");
					String phoneNumber = in.nextLine();
					System.out.println("Enter your address");
					String address = in.nextLine();
					customerService.editProfile(userId, name, phoneNumber, address);
					break;
				case 2:
					customerService.viewGyms();
					break;
				case 3:
					String temp_ = in.nextLine();
					System.out.println("Enter the id of the gym for which you want to view the available slots");
					 gymId = in.nextInt();
					in.nextLine();
					System.out.println("Enter the date of the slot");
					 date = in.nextLine();
					customerService.viewSlots(gymId,date);
					break;
				case 4:
					customerService.filterSlots();
					break;
				case 5:
					String temp2 = in.nextLine();
					System.out.println("Enter your payment mode");
					String modeOfPayment = in.nextLine();
					System.out.println("Enter your payment details");
					String paymentDetails = in.nextLine();
					System.out.println("Enter your payment date");
					String expiryDate = in.nextLine();
					int transactionId=1;
					try{
						transactionId = bookingService.makePayment(userId, paymentDetails, expiryDate, modeOfPayment);
					}
					catch (Exception e){
						System.out.println(e.getMessage());
					}
					System.out.println("Enter gym id");
					int gymBookingId = in.nextInt();
					System.out.println("Enter booking date");
					String temp3 = in.nextLine();
					String bookingDate = in.nextLine();
					System.out.println("Enter booking time slot");
					String bookingTimeSlot = in.nextLine();
					String bookingType = "Confirmed";
					int bookingAmount = 100;
					try{
						bookingService.createBooking(userId, gymBookingId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
					}
					catch (Exception e)
					{
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					try{
						bookingService.viewBookings(userId);
					}
					catch (Exception e)
					{
						System.out.println(e.getMessage());
					}
					break;
				case 7:
					System.out.println("Enter the bookingId");
					 int bookingId = in.nextInt();
					 try{
						 bookingService.cancelBookings(bookingId);
					 }catch(Exception e){
						 System.out.println(e.getMessage());
					 }

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
