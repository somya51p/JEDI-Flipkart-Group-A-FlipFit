package main.java.com.flipkart.business;
import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {

    FlipFitGymOwnerDAOInterface ownerDAO = new FlipFitGymOwnerDAOImpl();
    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        ownerDAO.createGymOwner(userId, name, phone, address, pan_no, gst_no);
        System.out.println("Customer Details are added!");
    }

    public void editProfile(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        ownerDAO.editProfile(userId, name, phone, address, pan_no, gst_no);
        System.out.println("edited gym owner details");
    }

    public void registerGym(int gymId, String name, String location) {
        ownerDAO.registerGym(gymId, name, location);
        System.out.println("gym registered successfully");
    }

    public void editGym(int gymId, String gymName, String gymLocation) {
        ownerDAO.editGym(gymId, gymName, gymLocation);
        System.out.println("gym " + gymId + "edited successfully");
    }

    public void removeGym(int gymId) {
        ownerDAO.removeGym(gymId);
        System.out.println("gym " + gymId + "removed successfully");
    }

    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId) {
        return ownerDAO.viewAllRegisteredGymCenters(userId);
    }

    public List<Booking> viewAllBookings(int userId) {
        return ownerDAO.viewAllBookings(userId);
    }

    public List<Booking> viewBookings(int gymId) {
        return ownerDAO.viewBookings(gymId);

    }

    public HashMap<String,Integer> viewAvailableSlots(int gymId,String date) {
        try{
            return customerDAO.viewSlots(gymId,date);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity) {
        ownerDAO.addSlot(gymId, slotId, slotTime, slotCapacity);
        System.out.println("Added slot " + slotId + "for gym " + gymId);
    }

    public void removeSlot(int gymId, int slotId) {
        ownerDAO.removeSlot(gymId, slotId);
        System.out.println("Removed slot " + slotId + "for gym " + gymId);
    }

}
