package com.flipkart.business;

public interface FlipFitCustomerInterface {

    public void createCustomer(int userId, String name, String phoneNumber, String address);
    public void editProfile();
    public void viewGyms();
    public void viewSlots();
    public void filterSlots();
}
