package com.flipkart.dao;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.exceptions.GymNotFoundException;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

/**
 * Interface for operations related to FlipFit customers.
 */
public interface FlipFitCustomerDAOInterface {

    /**
     * Creates a new customer in the database.
     * @param userId The ID of the customer.
     * @param name The name of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param address The address of the customer.
     */
    public void createCustomer(int userId, String name, String phoneNumber, String address);

    /**
     * Edits the profile of an existing customer in the database.
     * @param userId The ID of the customer.
     * @param name The updated name of the customer.
     * @param phoneNumber The updated phone number of the customer.
     * @param address The updated address of the customer.
     * @throws UserNotFoundException If no customer with the specified userId is found.
     */
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException;

    /**
     * Retrieves a list of all gyms from the database.
     * @return A list of FlipFitGym objects representing all gyms.
     */
    public List<FlipFitGym> viewGyms();

    /**
     * Retrieves slot availability for a specific gym on a given date.
     * @param gymId The ID of the gym.
     * @param date The date for which slot availability is queried.
     * @return A HashMap where keys are slot times and values are available seats.
     * @throws GymNotFoundException If no gym with the specified gymId is found.
     */
    public HashMap<String,Integer> viewSlots(int gymId, String date) throws GymNotFoundException;

    /**
     * Placeholder method for filtering slots based on specific criteria.
     * To be implemented in the implementing class as per requirements.
     */
    public void filterSlots();
}
