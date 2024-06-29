package com.flipkart.business;
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

    public void viewAllRegisteredGymCenters(int userId) {
        List<FlipFitGym> gyms = ownerDAO.viewAllRegisteredGymCenters(userId);

        for (FlipFitGym gym : gyms) {
            System.out.println("\nGym Id: " + gym.getGymId());
            System.out.println("Gym: " + gym.getGymName());
            System.out.println("Location: " + gym.getGymLocation());
        }
        System.out.println("view All Gym Centers");
    }

    public void viewAllBookings(int userId) {
        List<Booking> bookings = ownerDAO.viewAllBookings(userId);
        for (Booking booking : bookings) {
            System.out.println("\nBooking Id: " + booking.getBookingId());
            System.out.println("Customer Id: " + booking.getCustomerId());
            System.out.println("Gym Id: " + booking.getGymId());
            System.out.println("Booking Date: " + booking.getBookingDate());
            System.out.println("Slot: " + booking.getBookingTimeSlot());
            System.out.println("Transaction  Id: " + booking.getTransactionId());
        }
        System.out.println("viewed all bookings");
    }

    public void viewBookings(int gymId) {
        List<Booking> bookings = ownerDAO.viewBookings(gymId);
        for (Booking booking : bookings) {
            System.out.println("\nBooking Id: " + booking.getBookingId());
            System.out.println("Customer Id: " + booking.getCustomerId());
            System.out.println("Booking Date: " + booking.getBookingDate());
            System.out.println("Slot: " + booking.getBookingTimeSlot());
            System.out.println("Transaction  Id: " + booking.getTransactionId());
        }
        System.out.println("viewed bookings for " + gymId);
    }

    public void viewAvailableSlots(int gymId,String date) {
        try{
            System.out.println("viewed available slots for " + gymId);
            // Print the map
            HashMap<String,Integer> AvailableSlots=customerDAO.viewSlots(gymId,date);
            // Print the available slots
            for (Map.Entry<String, Integer> entry : AvailableSlots.entrySet()) {
                System.out.println("Slot Time: " + entry.getKey() + ", Available Slots: " + entry.getValue());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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
