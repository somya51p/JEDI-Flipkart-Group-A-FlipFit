package com.flipkart.business;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOInterface;

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
        ownerDAO.viewAllRegisteredGymCenters(userId);
        System.out.println("view All Gym Centers");
    }

    public void viewAllBookings(int userId) {
        ownerDAO.viewAllBookings(userId);
        System.out.println("view all bookings");
    }

    public void viewBookings(int gymId) {
        ownerDAO.viewBookings(gymId);
        System.out.println("view bookings for " + gymId);
    }

    public void viewAvailableSlots(int gymId) {
        ownerDAO.viewAvailableSlots(gymId);
        System.out.println("view available slots for " + gymId);
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
