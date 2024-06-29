package main.java.com.flipkart.business;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

public interface FlipFitCustomerInterface {

    public void createCustomer(int userId, String name, String phoneNumber, String address);
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException ;
    public List<FlipFitGym> viewGyms();
    public HashMap<String,Integer> viewSlots(int gymId, String date);
    public void filterSlots();
}
