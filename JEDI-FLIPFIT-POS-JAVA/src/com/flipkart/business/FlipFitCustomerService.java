package com.flipkart.business;

import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.exceptions.UserNotFoundException;

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
        System.out.println("All gyms are viewed");
    }

    public void viewSlots(){
        System.out.println("All slots are viewed");
    }

    public void filterSlots(){
        System.out.println("All slots are filtered");
    }

}
