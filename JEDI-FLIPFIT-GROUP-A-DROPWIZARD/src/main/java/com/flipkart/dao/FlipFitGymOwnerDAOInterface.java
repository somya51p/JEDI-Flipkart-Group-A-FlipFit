package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;

import java.util.List;

/**
 * Interface defining operations that a FlipFit Gym Owner DAO should implement.
 */
public interface FlipFitGymOwnerDAOInterface {

    /**
     * Creates a new gym owner record in the database.
     * @param userId The ID of the user who is becoming a gym owner.
     * @param name The name of the gym owner.
     * @param phone The phone number of the gym owner.
     * @param address The address of the gym owner.
     * @param pan_no The PAN number of the gym owner.
     * @param gst_no The GST number of the gym owner.
     */
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no);

    /**
     * Updates the profile information of a gym owner.
     * @param userId The ID of the gym owner whose profile is being updated.
     * @param ownerName The new name of the gym owner.
     * @param ownerPhone The new phone number of the gym owner.
     * @param ownerAddress The new address of the gym owner.
     * @param ownerGstNum The new GST number of the gym owner.
     * @param ownerPanNum The new PAN number of the gym owner.
     */
    public void editProfile(int userId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum);

    /**
     * Registers a new gym under a gym owner.
     * @param userId The ID of the gym owner registering the gym.
     * @param name The name of the gym.
     * @param location The location of the gym.
     */
    public void registerGym(int userId, String name, String location);

    /**
     * Updates the details of a gym.
     * @param gymId The ID of the gym to be updated.
     * @param gymName The new name of the gym.
     * @param gymLocation The new location of the gym.
     */
    public void editGym(int gymId, String gymName, String gymLocation);

    /**
     * Removes a gym owned by the gym owner.
     * @param gymId The ID of the gym to be removed.
     */
    public void removeGym(int gymId);

    /**
     * Retrieves a list of all gyms registered by the gym owner.
     * @param userId The ID of the gym owner.
     * @return A list of FlipFitGym objects representing all registered gyms.
     */
    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId);

    /**
     * Retrieves a list of all bookings made by customers at gyms owned by the gym owner.
     * @param userId The ID of the gym owner.
     * @return A list of Booking objects representing all bookings.
     */
    public List<Booking> viewAllBookings(int userId);

    /**
     * Retrieves a list of bookings made at a specific gym owned by the gym owner.
     * @param gymId The ID of the gym.
     * @return A list of Booking objects representing bookings at the gym.
     */
    public List<Booking> viewBookings(int gymId);

    /**
     * Retrieves a list of available slots for booking at a specific gym.
     * @param gymId The ID of the gym.
     * @return A list of Slot objects representing available slots at the gym.
     */
    public List<Slot> viewAvailableSlots(int gymId);

    /**
     * Adds a new slot for booking at a specific gym.
     * @param gymId The ID of the gym.
     * @param slotId The ID of the slot.
     * @param slotTime The time of the slot.
     * @param slotCapacity The capacity of the slot.
     * @param slotPrice The price of the slot.
     */
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity, int slotPrice);

    /**
     * Removes a slot from booking availability at a specific gym.
     * @param gymId The ID of the gym.
     * @param slotId The ID of the slot to be removed.
     */
    public void removeSlot(int gymId, int slotId);
}
