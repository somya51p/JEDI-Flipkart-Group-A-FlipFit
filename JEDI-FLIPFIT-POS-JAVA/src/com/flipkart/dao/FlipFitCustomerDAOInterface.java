package com.flipkart.dao;
import com.flipkart.exceptions.UserNotFoundException;
public interface FlipFitCustomerDAOInterface {
    public void createCustomer(int userId, String name, String phoneNumber, String address);
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException ;
    public void viewGyms();
    public void viewSlots(int gymId, String date);
    public void filterSlots();
}
