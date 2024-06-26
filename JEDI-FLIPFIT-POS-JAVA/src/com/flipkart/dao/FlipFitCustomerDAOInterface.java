package com.flipkart.dao;

public interface FlipFitCustomerDAOInterface {
    public void createCustomer(int id, String name, String email, String phoneNumber, String address, String password);
    public void editProfile();
    public void viewGyms();
    public void viewSlots();
    public void filterSlots();
}
