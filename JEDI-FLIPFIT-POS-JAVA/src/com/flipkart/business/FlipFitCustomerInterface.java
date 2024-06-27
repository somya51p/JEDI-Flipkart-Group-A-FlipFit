package com.flipkart.business;

public interface FlipFitCustomerInterface {

    public void createCustomer(int customerId, int userId, String name, String phoneNumber, String address, String userEmail, String userPass);
    public void editProfile();
    public void viewGyms();
    public void viewSlots();
    public void filterSlots();
}
