package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;

import java.util.HashMap;
import java.util.List;

/**
 * Interface defining operations that a gym owner can perform in FlipFit.
 */
public interface FlipFitGymOwnerInterface {

    /**
     * Creates a new gym owner with the specified details.
     *
     * @param userId   The ID of the gym owner.
     * @param name     The name of the gym owner.
     * @param phone    The phone number of the gym owner.
     * @param address  The address of the gym owner.
     * @param pan_no   The PAN number of the gym owner.
     * @param gst_no   The GST number of the gym owner.
     */
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no);

    /**
     * Edits the profile details of the gym owner.
     *
     * @param userId        The ID of the gym owner whose profile is to be edited.
     * @param ownerName     The updated name of the gym owner.
     * @param ownerPhone    The updated phone number of the gym owner.
     * @param ownerAddress  The updated address of the gym owner.
     * @param ownerGstNum   The updated GST number of the gym owner.
     * @param ownerPanNum   The updated PAN number of the gym owner.
     */
    public void editProfile(int userId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum);

    /**
     * Registers a new gym with the specified details.
     *
     * @param userId    The ID of the gym owner registering the gym.
     * @param name      The name of the gym.
     * @param location  The location of the gym.
     */
    public void registerGym(int userId, String name, String location);

    /**
     * Edits the details of an existing gym.
     *
     * @param gymId     The ID of the gym to be edited.
     * @param gymName   The updated name of the gym.
     * @param gymLocation The updated location of the gym.
     */
    public void editGym(int gymId, String gymName, String gymLocation);

    /**
     * Removes a gym from the system.
     *
     * @param gymId The ID of the gym to be removed.
     */
    public void removeGym(int gymId);

    /**
     * Retrieves a list of all registered gyms owned by a specific gym owner.
     *
     * @param userId The ID of the gym owner.
     * @return A list of FlipFitGym objects representing registered gyms.
     */
    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId);

    /**
     * Retrieves a list of all bookings made by a specific gym owner.
     *
     * @param userId The ID of the gym owner.
     * @return A list of Booking objects representing bookings made by the gym owner.
     */
    public List<Booking> viewAllBookings(int userId);

    /**
     * Retrieves a list of bookings made for a specific gym.
     *
     * @param gymId The ID of the gym.
     * @return A list of Booking objects representing bookings made for the gym.
     */
    public List<Booking> viewBookings(int gymId);

    /**
     * Retrieves available slots for a specific gym on a given date.
     *
     * @param gymId The ID of the gym.
     * @param date  The date for which slots are to be viewed.
     * @return A HashMap where keys are slot times and values are slot capacities.
     */
    public HashMap<String, Integer> viewAvailableSlots(int gymId, String date);

    /**
     * Adds a new slot to a specific gym.
     *
     * @param gymId      The ID of the gym.
     * @param slotId     The ID of the slot to be added.
     * @param slotTime   The time of the slot.
     * @param slotCapacity The capacity of the slot.
     * @param slotPrice  The price of the slot.
     */
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity, int slotPrice);

    /**
     * Removes a slot from a specific gym.
     *
     * @param gymId  The ID of the gym.
     * @param slotId The ID of the slot to be removed.
     */
    public void removeSlot(int gymId, int slotId);
}
