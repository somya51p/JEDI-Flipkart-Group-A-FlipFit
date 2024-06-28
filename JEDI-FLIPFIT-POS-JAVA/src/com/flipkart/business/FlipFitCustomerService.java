package com.flipkart.business;

import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

    public static void main(String[] args) {
        FlipFitCustomerInterface customerService = new FlipFitCustomerService();
        customerService.viewSlots();
    }

    public void createCustomer(int userId, String name, String phoneNumber, String address) {
        customerDAO.createCustomer(userId, name, phoneNumber, address);
        System.out.println("Customer Details are added!");

    }

    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException {
        customerDAO.editProfile(userId, name, phoneNumber, address);
        System.out.println("Customer details are updated!");
    }

    public void viewGyms(){
        System.out.println("All gyms are viewed");
    }

    public void viewSlots(){
        int gymId=1;
        String date="228/06/2024";
        System.out.println("All slots are viewed");
        // Print the map
        HashMap<String,Integer>AvailableSlots=customerDAO.viewSlots(gymId,date);
        // Print the available slots
        for (Map.Entry<String, Integer> entry : AvailableSlots.entrySet()) {
            System.out.println("Slot Time: " + entry.getKey() + ", Available Slots: " + entry.getValue());
        }
        }

    public void filterSlots(){
        System.out.println("All slots are filtered");
    }

}
