package com.flipkart.client;
import com.flipkart.business.FlipFitCustomerInterface;
import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitGymOwnerInterface;
import com.flipkart.business.FlipFitGymOwnerService;

import java.util.*;

public class GymFlipFitApplication {
    public static void main(String[] args) {
        FlipFitCustomerInterface userService = new FlipFitCustomerService();
        FlipFitGymOwnerInterface gymOwnerService = new FlipFitGymOwnerService();

        System.out.println("--------Welcome to FlipFit Application-------- ");
        System.out.println("Enter preferred choices: \n1. Login\n2. Register as Customer\n3. Register as Gym owner\n4. Change Password\n5. Exit");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Enter your email: ");
                String email = in.next();
                System.out.println("Enter your password: ");
                String password = in.next();
                System.out.println("Enter your role: \n1. Customer\n2. Gym owner\n3. Admin");
                int role = in.nextInt();
                if(role == 1) {
                    System.out.println("Logged in as Customer");
                } else if(role == 2) {
                    System.out.println("Logged in as Gym owner");
                    GymFlipFitOwnerMenu.displayGymOwnerOptions();
                } else if(role == 3) {
                    System.out.println("Logged in as Admin");
                }  else {
                    System.out.println("Invalid role choice");
                }
                break;
            case 2:
                System.out.println("Register as Customer: ");
                System.out.println("Enter your name: ");
                String userName = in.next();
                System.out.println("Enter your email: ");
                String userEmail = in.next();
                System.out.println("Enter your phone number: ");
                String userPhoneNumber = in.next();
                System.out.println("Enter your address: ");
                String address = in.next();
                System.out.println("Enter your password: ");
                String userPassword = in.next();
                System.out.println("Enter your confirm password: ");
                String confirmUserPassword = in.next();
                if(userPassword.equals(confirmUserPassword)) {
                    userService.createCustomer(101,userName,userEmail, userPhoneNumber,address, userPassword);
                    System.out.println("You have successfully registered as Customer");
                } else {
                    System.out.println("Passwords do not match");
                }
            case 3:
                System.out.println("Register as Gym owner: ");
                System.out.println("Enter your name: ");
                String ownerName = in.next();
                System.out.println("Enter your email: ");
                String ownerEmail = in.next();
                System.out.println("Enter your phone number: ");
                String ownerPhoneNumber = in.next();
                System.out.println("Enter your address: ");
                String ownerAddress = in.next();
                System.out.println("Enter your Gst number: ");
                String gstNumber = in.next();
                System.out.println("Enter your PAN number: ");
                String panNumber = in.next();
                System.out.println("Enter your password: ");
                String ownerPassword = in.next();
                System.out.println("Enter your confirm password: ");
                String confirmOwnerPassword = in.next();
                if(ownerPassword.equals(confirmOwnerPassword)) {
                    gymOwnerService.createGymOwner(1, ownerName, ownerEmail, ownerPhoneNumber, ownerAddress,
                            panNumber, gstNumber, "Pending");
                    System.out.println("You have successfully registered as Gym owner");
                } else {
                    System.out.println("Passwords do not match");
                }
            case 4:
                System.out.println("Change Password: ");
                System.out.println("Enter your old password: ");
                String oldPassword = in.nextLine();
                System.out.println("Enter your new password: ");
                String newPassword = in.nextLine();
                if(oldPassword.equals(newPassword)) {
                    System.out.println("New password cannot match old password");
                } else {
                    System.out.println("Passwords changed successfully");
                }
            case 5:
                in.close();
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}
