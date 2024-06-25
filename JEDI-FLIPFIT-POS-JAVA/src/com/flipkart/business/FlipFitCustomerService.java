package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;

public class FlipFitCustomerService {

    FlipFitCustomer flipfitcustomer = new FlipFitCustomer();

    public void createCustomer(int id, String name, String email, String phoneNumber, String address, String password) {
        flipfitcustomer.setCustomerId(id);
        flipfitcustomer.setCustomerName(name);
        flipfitcustomer.setCustomerEmail(email);
        flipfitcustomer.setCustomerPhone(phoneNumber);
        flipfitcustomer.setCustomerAddress(address);
        flipfitcustomer.setCustomerPassword(password);
        System.out.println("Customer Details are added!");
    }

    public void editProfile(){
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

    public void bookSlots(){
        System.out.println("Slot is booked");
    }

    public void viewBookings(){
        System.out.println("All bookings are viewed");
    }

    public void cancelBookings(){
        System.out.println("Slot is cancelled");
    }

}
