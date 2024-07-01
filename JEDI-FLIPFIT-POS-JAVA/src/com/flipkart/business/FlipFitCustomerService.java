package com.flipkart.business;

import com.flipkart.bean.*;
        import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

/**
 * Service class implementing operations for FlipFit customer management.
 */
public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

    //    public static void main(String[] args) {
    //        FlipFitCustomerInterface customerService = new FlipFitCustomerService();
    //        customerService.viewSlots();
    //    }

    /**
     * Creates a new customer with the specified details.
     *
     * @param userId      The ID of the user.
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
     * @param userId      The ID of the user/customer to edit.
     * @param name        The updated name of the customer.
     * @param phoneNumber The updated phone number of the customer.
     * @param address     The updated address of the customer.
     * @throws UserNotFoundException If the specified user ID is not found.
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
     * Retrieves available slots for a specified gym on a given date.
     *
     * @param gymId The ID of the gym to view slots for.
     * @param date  The date for which slots are to be viewed.
     * @return A HashMap where keys represent slot times and values represent slot capacities.
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
     * Placeholder method for filtering slots.
     * Actual implementation may vary based on filtering requirements.
     */
    public void filterSlots() {
        System.out.println("All slots filtered");
    }
}
