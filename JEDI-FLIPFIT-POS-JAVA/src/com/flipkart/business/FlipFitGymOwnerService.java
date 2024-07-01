package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOInterface;

import java.util.HashMap;
import java.util.List;

/**
 * Service class implementing FlipFitGymOwnerInterface to manage gym owner operations.
 */
public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {

    FlipFitGymOwnerDAOInterface ownerDAO = new FlipFitGymOwnerDAOImpl();
    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

    /**
     * Creates a new gym owner with the specified details.
     *
     * @param userId    The ID of the user.
     * @param name      The name of the gym owner.
     * @param phone     The phone number of the gym owner.
     * @param address   The address of the gym owner.
     * @param pan_no    The PAN number of the gym owner.
     * @param gst_no    The GST number of the gym owner.
     */
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        ownerDAO.createGymOwner(userId, name, phone, address, pan_no, gst_no);
        System.out.println("Gym owner details added successfully!");
    }

    /**
     * Edits the profile of the gym owner with the specified details.
     *
     * @param userId        The ID of the gym owner.
     * @param name          The updated name of the gym owner.
     * @param phone         The updated phone number of the gym owner.
     * @param address       The updated address of the gym owner.
     * @param pan_no        The updated PAN number of the gym owner.
     * @param gst_no        The updated GST number of the gym owner.
     */
    public void editProfile(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        ownerDAO.editProfile(userId, name, phone, address, pan_no, gst_no);
        System.out.println("Gym owner details updated successfully!");
    }

    /**
     * Registers a new gym with the specified details.
     *
     * @param gymId     The ID of the gym.
     * @param name      The name of the gym.
     * @param location  The location of the gym.
     */
    public void registerGym(int gymId, String name, String location) {
        ownerDAO.registerGym(gymId, name, location);
        System.out.println("Gym registered successfully!");
    }

    /**
     * Edits the details of an existing gym.
     *
     * @param gymId         The ID of the gym to edit.
     * @param gymName       The updated name of the gym.
     * @param gymLocation   The updated location of the gym.
     */
    public void editGym(int gymId, String gymName, String gymLocation) {
        ownerDAO.editGym(gymId, gymName, gymLocation);
        System.out.println("Gym " + gymId + " edited successfully!");
    }

    /**
     * Removes a gym based on the gym ID.
     *
     * @param gymId The ID of the gym to remove.
     */
    public void removeGym(int gymId) {
        ownerDAO.removeGym(gymId);
        System.out.println("Gym " + gymId + " removed successfully!");
    }

    /**
     * Retrieves a list of all registered gym centers for a specific gym owner.
     *
     * @param userId The ID of the gym owner.
     * @return A list of FlipFitGym objects representing registered gyms.
     */
    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId) {
        return ownerDAO.viewAllRegisteredGymCenters(userId);
    }

    /**
     * Retrieves all bookings made by customers of a specific gym owner.
     *
     * @param userId The ID of the gym owner.
     * @return A list of Booking objects representing all bookings.
     */
    public List<Booking> viewAllBookings(int userId) {
        return ownerDAO.viewAllBookings(userId);
    }

    /**
     * Retrieves all bookings made for a specific gym owned by the gym owner.
     *
     * @param gymId The ID of the gym.
     * @return A list of Booking objects representing bookings for the gym.
     */
    public List<Booking> viewBookings(int gymId) {
        return ownerDAO.viewBookings(gymId);
    }

    /**
     * Retrieves available slots for a specific gym on a given date.
     *
     * @param gymId The ID of the gym.
     * @param date  The date for which slots are to be retrieved.
     * @return A HashMap where keys represent slot times and values represent slot capacities.
     */
    public HashMap<String, Integer> viewAvailableSlots(int gymId, String date) {
        try {
            return customerDAO.viewSlots(gymId, date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Adds a new slot to a specific gym.
     *
     * @param gymId         The ID of the gym.
     * @param slotId        The ID of the slot.
     * @param slotTime      The time of the slot.
     * @param slotCapacity  The capacity of the slot.
     */
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity) {
        ownerDAO.addSlot(gymId, slotId, slotTime, slotCapacity);
        System.out.println("Added slot " + slotId + " for gym " + gymId);
    }

    /**
     * Removes a slot from a specific gym.
     *
     * @param gymId  The ID of the gym.
     * @param slotId The ID of the slot to remove.
     */
    public void removeSlot(int gymId, int slotId) {
        ownerDAO.removeSlot(gymId, slotId);
        System.out.println("Removed slot " + slotId + " for gym " + gymId);
    }
}
