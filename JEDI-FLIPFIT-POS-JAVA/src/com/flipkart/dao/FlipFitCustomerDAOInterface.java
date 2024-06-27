package com.flipkart.dao;

public interface FlipFitCustomerDAOInterface {
    public void createCustomer(int customerId, int userId, String name, String phoneNumber, String address, String userEmail, String userPass);
    public void editProfile();
    public void viewGyms();
    public void viewSlots();
    public void filterSlots();
}
