package com.flipkart.business;

import com.flipkart.exceptions.UserNotFoundException;

public interface FlipFitCustomerInterface {

    public void createCustomer(int userId, String name, String phoneNumber, String address);
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException;
    public void viewGyms();
    public void viewSlots();
    public void filterSlots();
}
