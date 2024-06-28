package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.List;

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

    public void createCustomer(int userId, String name, String phoneNumber, String address) {
        customerDAO.createCustomer(userId, name, phoneNumber, address);
        System.out.println("Customer Details are added!");

    }

    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException {
        customerDAO.editProfile(userId, name, phoneNumber, address);
        System.out.println("Customer details are updated!");
    }

    public void viewGyms(){
        List<FlipFitGym> gyms = customerDAO.viewGyms();
        // print the list
        for (FlipFitGym gym : gyms) {
            System.out.println("\nGym Id: " + gym.getGymId());
            System.out.println("Gym: " + gym.getGymName());
            System.out.println("Location: " + gym.getGymLocation());
        }
        System.out.println("All gyms viewed");
    }

    public void viewSlots(int gymId, String date){
        List<Slot> slots = customerDAO.viewSlots(gymId, date);
        for (Slot slot : slots) {
            System.out.println("\nSlot Id: " + slot.getSlotId());
            System.out.println("Gym Id: " + slot.getGymId());
            System.out.println("Capacity: " + slot.getSlotCapacity());
        }
        System.out.println("All slots viewed");
    }

    public void filterSlots(){

        System.out.println("All slots filtered");
    }

}