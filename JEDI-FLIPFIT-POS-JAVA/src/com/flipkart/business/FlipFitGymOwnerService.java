package com.flipkart.business;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOInterface;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {

    FlipFitGymOwnerDAOInterface ownerDAO = new FlipFitGymOwnerDAOImpl();
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        ownerDAO.createGymOwner(userId, name, phone, address, pan_no, gst_no);
        System.out.println("Customer Details are added!");
    }

    public void editProfile(int ownerId, String name, String email, String phone, String password, String address, String pan_no, String gst_no) {
        System.out.println("edited gym owner details");
    }

    public void registerGym(int gymId, String name, String location) {
        System.out.println("gym registered successfully");
    }

    public void editGym(int gymId) {
        System.out.println("gym " + gymId + "edited successfully");
    }

    public void removeGym(int gymId) {
        System.out.println("gym " + gymId + "removed successfully");
    }

    public void viewAllRegisteredGymCenters() {
        System.out.println("view All Gym Centers");
    }

    public void viewAllBookings() {
        System.out.println("view all bookings");
    }

    public void viewBookings(int gymId) {
        System.out.println("view bookings for " + gymId);
    }

    public void viewAvailableSlots(int gymId) {
        System.out.println("view available slots for " + gymId);
    }

    public void addSlot(int gymId, int slotId) {
        System.out.println("Added slot " + slotId + "for gym " + gymId);
    }

    public void removeSlot(int gymId, int slotId) {
        System.out.println("Removed slot " + slotId + "for gym " + gymId);
    }

}
