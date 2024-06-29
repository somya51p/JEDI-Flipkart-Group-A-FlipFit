package com.flipkart.client;

import com.flipkart.business.FlipfitAdminInterface ;
import com.flipkart.business.FlipfitAdminService;
import com.flipkart.exceptions.InvalidChoiceException;
import com.flipkart.exceptions.WrongCredentialsException;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;

import java.util.Scanner;

public class GymFlipFitAdminMenu {

	public static void login(String email, String password) throws WrongCredentialsException
	{
		FlipFitUserInterface user = new FlipFitUserService();

		if(user.authenticateUser(email, password, 3) > 0)
		{
			System.out.println("Logged in as Admin");
			try {
				displayAdminOptions();
			} catch (InvalidChoiceException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		else{
			throw new WrongCredentialsException();
		}
		
	}

	public static void displayAdminOptions() throws InvalidChoiceException {
		FlipfitAdminInterface adminService = new FlipfitAdminService() ;
		boolean flag= true ;
		do {
			System.out.println("Welcome to admin page :");
			System.out.println("1. View all Gym Owners : \n2. View all details of gym owner : \n3. View requests of gym owners : \n4. Approval of gym owner requests : \n5. Remove any gym owner : \n6. Cancel any pending request : \n7. Exit");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
				case 1:
					adminService.viewAllGymOwners();
					break;
				case 2:
					String temp = sc.nextLine();
					System.out.println("Enter Gym Owner ID : ");
					int gymOwnerId = sc.nextInt();
					adminService.viewGymOwnerDetails(gymOwnerId);
					break;
				case 3:
					adminService.viewGymOwnerRequests();
					break;
				case 4:
					String temp_ = sc.nextLine();
					System.out.println("Enter Gym Owner ID : ");
					int gymOwnerId_ = sc.nextInt();
					adminService.viewGymOwnerDetails(gymOwnerId_);
					break;
				case 5:
					String _temp = sc.nextLine();
					System.out.println("Enter Gym Owner ID : ");
					int _gymOwnerId = sc.nextInt();
					adminService.viewGymOwnerDetails(_gymOwnerId);
					break;
				case 6:
					String _temp_ = sc.nextLine();
					System.out.println("Enter Gym Owner ID : ");
					int _gymOwnerId_ = sc.nextInt();
					adminService.viewGymOwnerDetails(_gymOwnerId_);
					break;
				case 7:
					System.out.println("Thank you for using FlipFit App");
					flag= false ;
					break;
				default:
					System.out.println("invalid option");
			}
		}while(flag);

	}
}