package com.flipkart.client;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.business.FlipFitGymOwnerInterface;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.exceptions.InvalidChoiceException;
import com.flipkart.exceptions.WrongCredentialsException;

import java.util.*;

/**
 * Menu class for handling gym owner operations in the GymFlipFit application.
 */
public class GymFlipFitOwnerMenu {

	/**
	 * Method to handle gym owner login.
	 *
	 * @param email    Owner's email.
	 * @param password Owner's password.
	 * @throws WrongCredentialsException If credentials are incorrect.
	 */
	public static void login(String email, String password) throws WrongCredentialsException {
		FlipFitUserInterface user = new FlipFitUserService();
		int userId = user.authenticateUser(email, password, 2);

		if (userId > 0) {
			System.out.println("Logged in as Gym Owner");
			try {
				displayGymOwnerOptions(userId); // Display gym owner options after successful login
			} catch (InvalidChoiceException e) {
				System.out.println(e.getMessage());
			}
		} else {
			throw new WrongCredentialsException();
		}
	}

	/**
	 * Method to display gym owner options after login.
	 *
	 * @param userId ID of the logged-in gym owner.
	 * @throws InvalidChoiceException If an invalid menu choice is made.
	 */
	public static void displayGymOwnerOptions(int userId) throws InvalidChoiceException {
		FlipFitGymOwnerInterface gymOwnerService = new FlipFitGymOwnerService();
		boolean flag = true;

		Scanner in = new Scanner(System.in);

		do {
			System.out.println("GymOwnerMenu:\n 1.Register a Gym\n 2.Edit Gym details\n 3.Remove a Gym\n " +
					"4.Add new slot\n 5.Remove slot\n 6.View Available slots\n 7.View All Bookings\n " +
					"8.View Bookings for a Gym\n 9.View all Registered Gyms\n 10.Edit Profile\n 11.Exit");

			int choice = in.nextInt();
			in.nextLine(); // Consume newline after integer input

			switch (choice) {
				case 1:
					// Register a new gym
					System.out.println("Enter gym name");
					String name = in.nextLine();
					System.out.println("Enter location");
					String location = in.nextLine();
					gymOwnerService.registerGym(userId, name, location);
					System.out.println("Gym registered successfully");
					break;
				case 2:
					// Edit gym details
					System.out.println("Enter gym id of gym to be modified");
					int gymId = in.nextInt();
					in.nextLine(); // Consume newline after integer input
					System.out.println("Enter new gym name");
					name = in.nextLine();
					System.out.println("Enter new location");
					location = in.nextLine();
					gymOwnerService.editGym(gymId, name, location);
					System.out.println("Gym details updated successfully");
					break;
				case 3:
					// Remove a gym
					System.out.println("Enter gym id of gym to be removed");
					gymId = in.nextInt();
					gymOwnerService.removeGym(gymId);
					System.out.println("Gym removed successfully");
					break;
				case 4:
					// Add new slot to a gym
					System.out.println("Enter gym id ");
					gymId = in.nextInt();
					System.out.println("Enter slot id ");
					int slotId = in.nextInt();
					in.nextLine(); // Consume newline after integer input
					System.out.println("Enter slot timings");
					String slotTime = in.nextLine();
					System.out.println("Enter slot capacity");
					int slotCapacity = in.nextInt();
					gymOwnerService.addSlot(gymId, slotId, slotTime, slotCapacity);
					System.out.println("Slot added successfully");
					break;
				case 5:
					// Remove a slot from a gym
					System.out.println("Enter gym id ");
					gymId = in.nextInt();
					System.out.println("Enter slot id ");
					slotId = in.nextInt();
					gymOwnerService.removeSlot(gymId, slotId);
					System.out.println("Slot removed successfully");
					break;
				case 6:
					// View available slots for a gym on a specific date
					System.out.println("Enter gym id ");
					gymId = in.nextInt();
					in.nextLine(); // Consume newline after integer input
					System.out.println("Enter the date of the slot");
					String date = in.nextLine();

					HashMap<String, Integer> availableSlots = gymOwnerService.viewAvailableSlots(gymId, date);
					// Print the available slots
					for (Map.Entry<String, Integer> entry : availableSlots.entrySet()) {
						System.out.println("Slot Time: " + entry.getKey() + ", Available Slots: " + entry.getValue());
					}
					System.out.println("Viewed available slots for gym " + gymId);
					break;
				case 7:
					// View all bookings made for all gyms owned by the gym owner
					List<Booking> bookings = gymOwnerService.viewAllBookings(userId);
					for (Booking booking : bookings) {
						System.out.println("\nBooking Id: " + booking.getBookingId());
						System.out.println("Customer Id: " + booking.getCustomerId());
						System.out.println("Gym Id: " + booking.getGymId());
						System.out.println("Booking Date: " + booking.getBookingDate());
						System.out.println("Slot: " + booking.getBookingTimeSlot());
						System.out.println("Transaction  Id: " + booking.getTransactionId());
					}
					System.out.println("Viewed all bookings");
					break;
				case 8:
					// View bookings for a specific gym
					System.out.println("Enter gym id ");
					gymId = in.nextInt();
					bookings = gymOwnerService.viewBookings(gymId);
					for (Booking booking : bookings) {
						System.out.println("\nBooking Id: " + booking.getBookingId());
						System.out.println("Customer Id: " + booking.getCustomerId());
						System.out.println("Booking Date: " + booking.getBookingDate());
						System.out.println("Slot: " + booking.getBookingTimeSlot());
						System.out.println("Transaction  Id: " + booking.getTransactionId());
					}
					System.out.println("Viewed bookings for gym " + gymId);
					break;
				case 9:
					// View all registered gyms
					List<FlipFitGym> gyms = gymOwnerService.viewAllRegisteredGymCenters(userId);
					for (FlipFitGym gym : gyms) {
						System.out.println("\nGym Id: " + gym.getGymId());
						System.out.println("Gym: " + gym.getGymName());
						System.out.println("Location: " + gym.getGymLocation());
					}
					System.out.println("Viewed all registered gyms");
					break;
				case 10:
					// Edit gym owner's profile
					System.out.println("Enter your name");
					name = in.nextLine();
					System.out.println("Enter your phone number");
					String phoneNumber = in.nextLine();
					System.out.println("Enter your address");
					String address = in.nextLine();
					System.out.println("Enter your Pan Number");
					String panNum = in.next();
					System.out.println("Enter your GST Number");
					String gstNum = in.next();
					gymOwnerService.editProfile(userId, name, phoneNumber, address, panNum, gstNum);
					System.out.println("Profile updated successfully");
					break;
				case 11:
					// Exit
					System.out.println("Thank you for using FlipFit Application");
					flag = false;
					break;
				default:
					throw new InvalidChoiceException("Invalid option - " + choice);
			}

		} while (flag);

		in.close();
	}
}
