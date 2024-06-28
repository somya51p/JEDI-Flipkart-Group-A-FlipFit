package com.flipkart.client;

import com.flipkart.business.FlipfitAdminInterface ;
import com.flipkart.business.FlipfitAdminService;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;

import java.util.Scanner;

public class GymFlipFitAdminMenu {

	public static void login(String email, String password)
	{
		FlipFitUserInterface user = new FlipFitUserService();

		if(user.authenticateUser(email, password, 3) > 0)
		{
			System.out.println("Logged in as Admin");
			displayAdminOptions();
		}
		else{
			System.out.println("Invalid credentials");
		}
	}

	public static void displayAdminOptions() {
		FlipfitAdminInterface adminService = new FlipfitAdminService() ;
		boolean flag= true ;
		do {
			System.out.println("Welcome to admin page :");
			System.out.println("1. View all details of gym owner : \n2. View requests of gym owners : \n3. Approval of gym owner requests : \n4. Remove any gym owner : \n 5. Cancel any pending request : \n6. Exit");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
				case 1:
					adminService.viewGymOwnerDetails(101);
					break;
				case 2:
					adminService.viewGymOwnerRequests();
					break;
				case 3:
					adminService.approveGymOwnerRequests(101);
					break;
				case 4:
					adminService.removeGymOwner(101);
					break;
				case 5:
					adminService.cancelRequest(101);
					break;
				case 6:
					System.out.println("Thank you for using FlipFit App");
					flag= false ;
					break;
				default:
					System.out.println("invalid option");
			}
		}while(flag);

	}
}