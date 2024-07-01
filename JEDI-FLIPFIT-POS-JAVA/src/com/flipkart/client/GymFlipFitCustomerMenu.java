package com.flipkart.client;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.business.BookingGymInterface;
import com.flipkart.business.BookingGymService;
import com.flipkart.business.FlipFitCustomerInterface;
import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.exceptions.InvalidChoiceException;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.exceptions.WrongCredentialsException;

import java.util.*;

/**
 * Menu class for handling customer operations in the GymFlipFit application.
 */
public class GymFlipFitCustomerMenu {

	/**
	 * Method to handle customer login.
	 *
	 * @param email    Customer's email.
	 * @param password Customer's password.
	 * @throws UserNotFoundException   If user is not found.
	 * @throws WrongCredentialsException If credentials are incorrect.
	 */
	public static void login(String email, String password) throws UserNotFoundException, WrongCredentialsException {
		FlipFitCustomerInterface customerService = new FlipFitCustomerService();
		FlipFitUserInterface userService = new FlipFitUserService();

		// Authenticate user
		int userId = userService.authenticateUser(email, password, 1);
		if (userId > 0) {
			System.out.println("Logged in as Customer");
			try {
				displayCustomerOptions(userId); // Display customer options after successful login
			} catch (InvalidChoiceException e) {
				System.out.println("Error:" + e.getMessage());
			}
		} else {
			throw new WrongCredentialsException();
		}
	}

	/**
	 * Method to display customer options after login.
	 *
	 * @param userId ID of the logged-in customer.
	 * @throws UserNotFoundException   If user is not found.
	 * @throws InvalidChoiceException  If an invalid menu choice is made.
	 */
	public static void displayCustomerOptions(int userId) throws UserNotFoundException, InvalidChoiceException {
		FlipFitCustomerInterface customerService = new FlipFitCustomerService();
		BookingGymInterface bookingService = new BookingGymService();

		boolean flag = true;
		Scanner in = new Scanner(System.in);

		do {
			System.out.println("Welcome to FlipFit Customer Page");
			System.out.println("Customer Menu: \n1. Edit your Profile\n2. View all Gyms\n3. View available Slots\n4. Filter Slots\n5. Book your slot\n6. View your bookings\n7. Cancel your bookings\n8. Exit");

			int choice = in.nextInt();
			in.nextLine(); // Consume newline after integer input

			switch (choice) {
				case 1:
					// Edit profile
					System.out.println("Enter your name");
					String name = in.nextLine();
					System.out.println("Enter your phone number");
					String phoneNumber = in.nextLine();
					System.out.println("Enter your address");
					String address = in.nextLine();

					customerService.editProfile(userId, name, phoneNumber, address);
					System.out.println("Profile updated successfully");
					break;
				case 2:
					// View all gyms
					List<FlipFitGym> gyms = customerService.viewGyms();
					for (FlipFitGym gym : gyms) {
						System.out.println("\nGym Id: " + gym.getGymId());
						System.out.println("Gym: " + gym.getGymName());
						System.out.println("Location: " + gym.getGymLocation());
					}
					System.out.println("All gyms viewed");
					break;
				case 3:
					// View available slots
					System.out.println("Enter the id of the gym for which you want to view the available slots");
					int gymId = in.nextInt();
					in.nextLine(); // Consume newline after integer input
					System.out.println("Enter the date of the slot");
					String date = in.nextLine();

					HashMap<String, Integer> availableSlots = customerService.viewSlots(gymId, date);
					// Print the available slots
					for (Map.Entry<String, Integer> entry : availableSlots.entrySet()) {
						System.out.println("Slot Time: " + entry.getKey() + ", Available Slots: " + entry.getValue());
					}
					System.out.println("All slots are viewed");
					break;
				case 4:
					// Filter slots (functionality not provided in current implementation)
					System.out.println("Filtering slots...");
					customerService.filterSlots();
					break;
				case 5:
					// Book a slot
					System.out.println("Enter your payment mode");
					String modeOfPayment = in.nextLine();
					System.out.println("Enter your payment details");
					String paymentDetails = in.nextLine();
					System.out.println("Enter your payment date");
					String expiryDate = in.nextLine();

					int transactionId = bookingService.makePayment(userId, paymentDetails, expiryDate, modeOfPayment);

					System.out.println("Enter gym id");
					int gymBookingId = in.nextInt();
					in.nextLine(); // Consume newline after integer input
					System.out.println("Enter booking date");
					String bookingDate = in.nextLine();
					System.out.println("Enter booking time slot");
					String bookingTimeSlot = in.nextLine();
					String bookingType = "Confirmed";
					int bookingAmount = 100;

					try {
						bookingService.createBooking(userId, gymBookingId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
						System.out.println("Booking successful");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					// View customer's bookings
					try {
						List<Booking> bookings = bookingService.viewBookings(userId);

						if (bookings.isEmpty()) {
							System.out.println("No bookings found for userId: " + userId);
						} else {
							System.out.println("Bookings for userId: " + userId);
							for (Booking booking : bookings) {
								System.out.println("Booking ID: " + booking.getBookingId());
								System.out.println("Customer ID: " + booking.getCustomerId());
								System.out.println("Gym ID: " + booking.getGymId());
								System.out.println("Transaction ID: " + booking.getTransactionId());
								System.out.println("Booking Date: " + booking.getBookingDate());
								System.out.println("Booking TimeSlot: " + booking.getBookingTimeSlot());
								System.out.println("Booking Type: " + booking.getBookingType());
								System.out.println("Booking Amount: " + booking.getBookingAmount());
								System.out.println("=================================");
							}
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 7:
					// Cancel booking
					System.out.println("Enter the bookingId");
					int bookingId = in.nextInt();
					in.nextLine(); // Consume newline after integer input
					try {
						bookingService.cancelBookings(bookingId);
						System.out.println("Booking canceled successfully");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 8:
					// Exit
					System.out.println("Thank you for using FlipFit App");
					flag = false;
					break;
				default:
					throw new InvalidChoiceException("Invalid option - " + choice);
			}
		} while (flag);

		in.close();
	}
}
