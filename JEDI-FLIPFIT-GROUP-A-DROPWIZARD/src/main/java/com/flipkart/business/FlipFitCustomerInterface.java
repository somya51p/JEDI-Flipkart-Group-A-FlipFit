package com.flipkart.business;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

/**
 * Interface defining operations available to customers in the FlipFit system.
 */
public interface FlipFitCustomerInterface {

    /**
     * Creates a new customer with the specified details.
     *
     * @param userId      The ID of the customer.
     * @param name        The name of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param address     The address of the customer.
     */
    public void createCustomer(int userId, String name, String phoneNumber, String address);

    /**
     * Edits the profile of an existing customer.
     *
     * @param userId      The ID of the customer whose profile is to be edited.
     * @param name        The updated name of the customer.
     * @param phoneNumber The updated phone number of the customer.
     * @param address     The updated address of the customer.
     * @throws UserNotFoundException If the customer with the specified ID is not found.
     */
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException;

    /**
     * Retrieves a list of gyms available in the system.
     *
     * @return A list of FlipFitGym objects representing gyms.
     */
    public List<FlipFitGym> viewGyms();

    /**
     * Retrieves available slots for a specific gym on a given date.
     *
     * @param gymId The ID of the gym.
     * @param date  The date for which slots are to be viewed.
     * @return A HashMap where keys are slot times and values are slot capacities.
     */
    public HashMap<String, Integer> viewSlots(int gymId, String date);

    /**
     * Filters available slots based on certain criteria.
     * Implementing classes can define specific filters.
     */
    public void filterSlots();
}
