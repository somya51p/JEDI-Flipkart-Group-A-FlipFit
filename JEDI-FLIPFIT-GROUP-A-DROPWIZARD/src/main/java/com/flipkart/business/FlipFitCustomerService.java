package main.java.com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

//    public static void main(String[] args) {
//        FlipFitCustomerInterface customerService = new FlipFitCustomerService();
//        customerService.viewSlots();
//    }

    public void createCustomer(int userId, String name, String phoneNumber, String address) {
        customerDAO.createCustomer(userId, name, phoneNumber, address);
        System.out.println("Customer Details are added!");

    }

    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException {
        customerDAO.editProfile(userId, name, phoneNumber, address);
        System.out.println("Customer details are updated!");
    }

    public List<FlipFitGym> viewGyms(){
        return customerDAO.viewGyms();
    }

    public HashMap<String,Integer> viewSlots(int gymId, String date){
        try{
            return customerDAO.viewSlots(gymId,date);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void filterSlots(){

        System.out.println("All slots filtered");
    }

}