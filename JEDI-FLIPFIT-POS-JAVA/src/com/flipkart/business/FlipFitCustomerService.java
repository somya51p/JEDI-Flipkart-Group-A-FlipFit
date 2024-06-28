package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.Roles;
import com.flipkart.bean.Users;

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomer flipfitcustomer = new FlipFitCustomer();
    Users user = new Users();


    public void createCustomer(int customerId, int userId, String name, String phoneNumber, String address, String userEmail, String userPass) {
        flipfitcustomer.setCustomerName(name);
        flipfitcustomer.setCustomerPhone(phoneNumber);
        flipfitcustomer.setCustomerAddress(address);
        user.setUserEmail(userEmail);
        user.setUserPassword(userPass);

        user.setRoleId(1);
        flipfitcustomer.setCustomerId(customerId);
        user.setUserId(userId);

        System.out.println("Customer Details are added!");
    }

    public void editProfile(){
        System.out.println("Customer details are updated!");
    }

    public void viewGyms(){
        customerDAO.viewGyms();
        System.out.println("All gyms are viewed");
    }

    public void viewSlots(){
        System.out.println("All slots are viewed");
    }

    public void filterSlots(){
        System.out.println("All slots are filtered");
    }

}
