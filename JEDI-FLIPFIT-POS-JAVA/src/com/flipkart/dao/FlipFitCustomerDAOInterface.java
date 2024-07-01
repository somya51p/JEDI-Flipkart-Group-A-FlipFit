package com.flipkart.dao;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.exceptions.GymNotFoundException;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

/**
 * Interface for FlipFitCustomerDAO operations related to customer interactions with gyms and slots.
 */
public interface FlipFitCustomerDAOInterface {

    /**
     * Creates a new customer record in the database.
     *
     * @param userId      The user ID of the customer.
     * @param name        The name of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param address     The address of the customer.
     */
    public void createCustomer(int userId, String name, String phoneNumber, String address);

    /**
     * Edits the profile of an existing customer in the database.
     *
     * @param userId      The user ID of the customer.
     * @param name        The updated name of the customer.
     * @param phoneNumber The updated phone number of the customer.
     * @param address     The updated address of the customer.
     * @throws UserNotFoundException If the customer with the given user ID is not found.
     */
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException;

    /**
     * Retrieves a list of all gyms available in the system.
     *
     * @return List of FlipFitGym objects representing gyms.
     */
    public List<FlipFitGym> viewGyms();

    /**
     * Retrieves the availability of slots for a specific gym on a given date.
     *
     * @param gymId The ID of the gym.
     * @param date  The date for which slot availability is queried.
     * @return HashMap where key is slot time and value is number of available seats.
     * @throws GymNotFoundException If the gym with the given ID is not found.
     */
    public HashMap<String, Integer> viewSlots(int gymId, String date) throws GymNotFoundException;

    /**
     * Filters slots based on specific criteria (to be implemented).
     */
    public void filterSlots();
}
