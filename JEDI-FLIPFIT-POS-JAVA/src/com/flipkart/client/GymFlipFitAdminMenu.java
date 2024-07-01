package com.flipkart.client;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipfitAdminInterface;
import com.flipkart.business.FlipfitAdminService;
import com.flipkart.exceptions.InvalidChoiceException;
import com.flipkart.exceptions.WrongCredentialsException;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;

import java.util.List;
import java.util.Scanner;

/**
 * Menu class for FlipFit admin functionalities.
 */
public class GymFlipFitAdminMenu {

	/**
	 * Method to handle user login based on email and password.
	 *
	 * @param email    The email of the admin user.
	 * @param password The password of the admin user.
	 * @throws WrongCredentialsException if credentials are incorrect.
	 */
	public static void login(String email, String password) throws WrongCredentialsException {
		FlipFitUserInterface user = new FlipFitUserService();

		// Authenticating user
		if (user.authenticateUser(email, password, 3) > 0) {
			System.out.println("Logged in as Admin");
			try {
				displayAdminOptions();
			} catch (InvalidChoiceException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} else {
			throw new WrongCredentialsException();
		}
	}

	/**
	 * Displays admin options and interacts with admin services based on user input.
	 *
	 * @throws InvalidChoiceException if an invalid menu option is selected.
	 */
	public static void displayAdminOptions() throws InvalidChoiceException {
		FlipfitAdminInterface adminService = new FlipfitAdminService();
		boolean flag = true;
		int gymOwnerId;
		List<FlipFitGymOwner> gymOwners;
		Scanner sc = new Scanner(System.in);

		do {
			// Displaying menu options
			System.out.println("Welcome to admin page :");
			System.out.println("1. View all Gym Owners");
			System.out.println("2. View all details of gym owner");
			System.out.println("3. View requests of gym owners");
			System.out.println("4. Approval of gym owner requests");
			System.out.println("5. Remove any gym owner");
			System.out.println("6. Cancel any pending request");
			System.out.println("7. Exit");

			int option = sc.nextInt();
			switch (option) {
				case 1:
					// View all gym owners
					gymOwners = adminService.viewAllGymOwners();
					for (FlipFitGymOwner s : gymOwners) {
						System.out.println("Owner ID: " + s.getOwnerId() + " ---> " + "Owner Name: " + s.getOwnerName());
					}
					break;
				case 2:
					// View details of a specific gym owner
					sc.nextLine(); // Consume newline left from nextInt()
					System.out.println("Enter Gym Owner ID : ");
					gymOwnerId = sc.nextInt();

					gymOwners = adminService.viewGymOwnerDetails(gymOwnerId);
					for (FlipFitGymOwner s : gymOwners) {
						System.out.println("ID: " + s.getOwnerId());
						System.out.println("Name: " + s.getOwnerName());
						System.out.println("Phone: " + s.getOwnerId()); // Check if this should be getOwnerPhone()
						System.out.println("Address: " + s.getOwnerAddress());
						System.out.println("GST Number: " + s.getOwnerGstNum());
						System.out.println("PAN Number: " + s.getOwnerPanNum());
						System.out.println("Approval Status: " + s.getApprovalStatus());
						System.out.println("=================================");
					}
					System.out.println("Viewed All the approved gym owner details");
					break;
				case 3:
					// View all pending requests of gym owners
					List<FlipFitGymOwner> output = adminService.viewGymOwnerRequests();
					for (FlipFitGymOwner s : output) {
						System.out.println("ID: " + s.getOwnerId());
						System.out.println("Name: " + s.getOwnerName());
						System.out.println("Phone: " + s.getOwnerId()); // Check if this should be getOwnerPhone()
						System.out.println("Address: " + s.getOwnerAddress());
						System.out.println("GST Number: " + s.getOwnerGstNum());
						System.out.println("PAN Number: " + s.getOwnerPanNum());
						System.out.println("Approval Status: " + s.getApprovalStatus());
						System.out.println("=================================");
					}
					System.out.println("Viewed all the gym owner pending requests");
					break;
				case 4:
					// Approve a gym owner request
					sc.nextLine(); // Consume newline left from nextInt()
					System.out.println("Enter Gym Owner ID : ");
					gymOwnerId = sc.nextInt();
					adminService.approveGymOwnerRequests(gymOwnerId);
					break;
				case 5:
					// Remove a gym owner
					sc.nextLine(); // Consume newline left from nextInt()
					System.out.println("Enter Gym Owner ID : ");
					gymOwnerId = sc.nextInt();
					adminService.removeGymOwner(gymOwnerId);
					break;
				case 6:
					// Cancel a pending request
					sc.nextLine(); // Consume newline left from nextInt()
					System.out.println("Enter Gym Owner ID : ");
					gymOwnerId = sc.nextInt();
					adminService.cancelRequest(gymOwnerId);
					break;
				case 7:
					// Exit the application
					System.out.println("Thank you for using FlipFit App");
					flag = false;
					break;
				default:
					// Invalid option selected
					System.out.println("Invalid option");
			}
		} while (flag);
	}
}
