package com.flipkart.client;
import com.flipkart.business.*;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.exceptions.WrongCredentialsException;

import java.util.*;

/**
 * Main application class for FlipFit, which handles user login, registration,
 * and menu navigation for different roles (Customer, Gym Owner, Admin).
 */
public class GymFlipFitApplication {

    /**
     * Handles user login based on role (Customer, Gym Owner, Admin).
     */
    public static void login() {

        Scanner in = new Scanner(System.in);
        System.out.println("------- Login ------ ");
        System.out.println("Enter your email: ");
        String email = in.next();
        System.out.println("Enter your password: ");
        String password = in.next();
        System.out.println("Enter your role: \n1. Customer\n2. Gym owner\n3. Admin");
        int role = in.nextInt();

        if(role == 1) {
            try {
                GymFlipFitCustomerMenu.login(email, password);
            } catch (Exception e) {
                System.out.println("Error:"+e.getMessage());
            }
        } else if(role == 2) {
            try {
                GymFlipFitOwnerMenu.login(email, password);
            } catch (Exception e) {
                System.out.println("Error:"+e.getMessage());
            }
        } else if(role == 3) {
            try {
                GymFlipFitAdminMenu.login(email, password);}
            catch(Exception e) {
                System.out.println("Error:"+e.getMessage());
            }
        }  else {
            System.out.println("Invalid role choice");
        }
    }

    /**
     * Registers a new customer.
     *
     * @throws UserNotFoundException If the user is not found during registration.
     */
    public static void registerCustomer() throws UserNotFoundException {

        FlipFitCustomerInterface customerService = new FlipFitCustomerService();
        FlipFitUserInterface userService = new FlipFitUserService();
        Scanner in = new Scanner(System.in);

        System.out.println("------ Register as Customer ------ ");
        System.out.println("Enter your name: ");
        String userName = in.nextLine();
        System.out.println("Enter your phone number: ");
        String userPhoneNumber = in.next();
        System.out.println("Enter your address: ");
        String temp = in.nextLine();
        String address = in.nextLine();
        System.out.println("Enter your email: ");
        String userEmail = in.next();
        System.out.println("Enter your password: ");
        String userPassword = in.next();
        System.out.println("Enter your confirm password: ");
        String confirmUserPassword = in.next();
        if(userPassword.equals(confirmUserPassword)) {
            int userId = userService.createUser(userEmail, userPassword, 1);
            if(userId > 0) {
                customerService.createCustomer(userId, userName, userPhoneNumber, address);
                System.out.println("You have successfully registered as Customer");
                System.out.println("*********************************************");
                login();
            }

        } else {
            System.out.println("Passwords do not match");
        }
    }

    /**
     * Registers a new gym owner.
     *
     * @throws UserNotFoundException If the user is not found during registration.
     */
    public static void registerGymOwner() throws UserNotFoundException {

        FlipFitGymOwnerInterface gymOwnerService = new FlipFitGymOwnerService();
        FlipFitUserInterface userService = new FlipFitUserService();
        Scanner in = new Scanner(System.in);

        System.out.println("------ Register as Gym owner ------ ");
        System.out.println("Enter your name: ");
        String ownerName = in.next();
        System.out.println("Enter your email: ");
        String ownerEmail = in.next();
        System.out.println("Enter your phone number: ");
        String ownerPhoneNumber = in.next();
        System.out.println("Enter your address: ");
        String temp = in.nextLine();
        String ownerAddress = in.nextLine();
        System.out.println("Enter your Gst number: ");
        String gstNumber = in.next();
        System.out.println("Enter your PAN number: ");
        String panNumber = in.next();
        System.out.println("Enter your password: ");
        String ownerPassword = in.next();
        System.out.println("Enter your confirm password: ");
        String confirmOwnerPassword = in.next();
        if(ownerPassword.equals(confirmOwnerPassword)) {
            int userId = userService.createUser(ownerEmail, ownerPassword, 2);
            if(userId > 0) {
                gymOwnerService.createGymOwner(userId, ownerName, ownerPhoneNumber,  ownerAddress,
                        panNumber, gstNumber);
                System.out.println("You have successfully registered as Gym owner");
                System.out.println("*********************************************");
                login();
            }

        } else {
            System.out.println("Passwords do not match");
        }
    }

    /**
     * Main method to run the FlipFit application.
     *
     * @param args Command-line arguments (not used).
     * @throws UserNotFoundException If the user is not found during registration.
     */

    public static void main(String[] args) throws UserNotFoundException {

        System.out.println("--------Welcome to FlipFit Application--------");
        System.out.println("Enter preferred choices: \n1. Login\n2. Register as Customer\n3. Register as Gym owner\n4. Exit");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                login();
                break;
            case 2:
                registerCustomer();
                break;
            case 3:
                registerGymOwner();
                break;
            case 4:
                System.out.println("Thank you for using FlipFit App");
                in.close();
                break;
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}