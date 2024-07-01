package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

/**
 * Service implementation for managing customer operations in FlipFit.
 */
public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

    /**
     * Creates a new customer with the specified details.
     *
     * @param userId      The ID of the customer.
     * @param name        The name of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param address     The address of the customer.
     */
    public void createCustomer(int userId, String name, String phoneNumber, String address) {
        customerDAO.createCustomer(userId, name, phoneNumber, address);
        System.out.println("Customer Details are added!");
    }

    /**
     * Edits the profile of an existing customer.
     *
     * @param userId      The ID of the customer whose profile is to be edited.
     * @param name        The updated name of the customer.
     * @param phoneNumber The updated phone number of the customer.
     * @param address     The updated address of the customer.
     * @throws UserNotFoundException If the customer with the specified ID is not found.
     */
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException {
        customerDAO.editProfile(userId, name, phoneNumber, address);
        System.out.println("Customer details are updated!");
    }

    /**
     * Retrieves a list of gyms available in the system.
     *
     * @return A list of FlipFitGym objects representing gyms.
     */
    public List<FlipFitGym> viewGyms() {
        return customerDAO.viewGyms();
    }

    /**
     * Retrieves available slots for a specific gym on a given date.
     *
     * @param gymId The ID of the gym.
     * @param date  The date for which slots are to be viewed.
     * @return A HashMap where keys are slot times and values are slot capacities.
     */
    public HashMap<String, Integer> viewSlots(int gymId, String date) {
        try {
            return customerDAO.viewSlots(gymId, date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Filters available slots based on certain criteria.
     * Implementing classes can define specific filters.
     */
    public void filterSlots() {
        System.out.println("All slots filtered");
    }
}
