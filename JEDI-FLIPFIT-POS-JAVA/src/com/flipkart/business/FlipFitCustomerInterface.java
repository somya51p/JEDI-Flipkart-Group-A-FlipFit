package com.flipkart.business;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

/**
 * Interface defining operations for FlipFit customer management.
 */
public interface FlipFitCustomerInterface {

    /**
     * Creates a new customer with the specified details.
     *
     * @param userId      The ID of the user.
     * @param name        The name of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param address     The address of the customer.
     */
    public void createCustomer(int userId, String name, String phoneNumber, String address);

    /**
     * Edits the profile of an existing customer.
     *
     * @param userId      The ID of the user/customer to edit.
     * @param name        The updated name of the customer.
     * @param phoneNumber The updated phone number of the customer.
     * @param address     The updated address of the customer.
     * @throws UserNotFoundException If the specified user ID is not found.
     */
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException;

    /**
     * Retrieves a list of gyms available in the system.
     *
     * @return A list of FlipFitGym objects representing gyms.
     */
    public List<FlipFitGym> viewGyms();

    /**
     * Retrieves available slots for a specified gym on a given date.
     *
     * @param gymId The ID of the gym to view slots for.
     * @param date  The date for which slots are to be viewed.
     * @return A HashMap where keys represent slot times and values represent slot capacities.
     */
    public HashMap<String, Integer> viewSlots(int gymId, String date);

    /**
     * Filters slots based on certain criteria.
     * Actual implementation may vary based on filtering requirements.
     */
    public void filterSlots();
}
