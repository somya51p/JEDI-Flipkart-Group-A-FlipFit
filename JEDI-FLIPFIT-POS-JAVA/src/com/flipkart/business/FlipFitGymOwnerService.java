package com.flipkart.business;
import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOInterface;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {

    FlipFitGymOwnerDAOInterface ownerDAO = new FlipFitGymOwnerDAOImpl();
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

    public void viewAvailableSlots(int gymId) {
        List<Slot> slots = ownerDAO.viewAvailableSlots(gymId);
        for (Slot slot : slots) {
            System.out.println("\nSlot Id: " + slot.getSlotId());
            System.out.println("Gym Id: " + slot.getGymId());
            System.out.println("Capacity: " + slot.getSlotCapacity());
        }
        System.out.println("viewed available slots for " + gymId);
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
