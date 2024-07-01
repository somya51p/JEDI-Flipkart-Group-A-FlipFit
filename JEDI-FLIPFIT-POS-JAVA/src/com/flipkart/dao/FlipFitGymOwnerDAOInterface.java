package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;

import java.util.List;

/**
 * Interface defining operations for gym owners in the FlipFit system.
 */
public interface FlipFitGymOwnerDAOInterface {

    /**
     * Creates a new gym owner entry in the database.
     *
     * @param userId    The user ID of the owner.
     * @param name      The name of the owner.
     * @param phone     The phone number of the owner.
     * @param address   The address of the owner.
     * @param pan_no    The PAN number of the owner.
     * @param gst_no    The GST number of the owner.
     */
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no);

    /**
     * Updates the profile of a gym owner.
     *
     * @param userId        The user ID of the owner.
     * @param ownerName     The updated name of the owner.
     * @param ownerPhone    The updated phone number of the owner.
     * @param ownerAddress  The updated address of the owner.
     * @param ownerGstNum   The updated GST number of the owner.
     * @param ownerPanNum   The updated PAN number of the owner.
     */
    public void editProfile(int userId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum);

    /**
     * Registers a new gym under a gym owner.
     *
     * @param gymId     The gym ID to be registered.
     * @param name      The name of the gym.
     * @param location  The location of the gym.
     */
    public void registerGym(int gymId, String name, String location);

    /**
     * Updates the details of a gym.
     *
     * @param gymId         The ID of the gym to be updated.
     * @param gymName       The updated name of the gym.
     * @param gymLocation   The updated location of the gym.
     */
    public void editGym(int gymId, String gymName, String gymLocation);

    /**
     * Removes a gym from the system.
     *
     * @param gymId     The ID of the gym to be removed.
     */
    public void removeGym(int gymId);

    /**
     * Retrieves all gyms registered by a specific user.
     *
     * @param userId    The user ID of the owner.
     * @return          A list of FlipFitGym objects representing all registered gyms.
     */
    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId);

    /**
     * Retrieves all bookings associated with a specific user (gym owner).
     *
     * @param userId    The user ID of the owner.
     * @return          A list of Booking objects representing all bookings.
     */
    public List<Booking> viewAllBookings(int userId);

    /**
     * Retrieves all bookings associated with a specific gym.
     *
     * @param gymId     The ID of the gym.
     * @return          A list of Booking objects representing all bookings of the gym.
     */
    public List<Booking> viewBookings(int gymId);

    /**
     * Retrieves all available time slots for a specific gym.
     *
     * @param gymId     The ID of the gym.
     * @return          A list of Slot objects representing all available slots of the gym.
     */
    public List<Slot> viewAvailableSlots(int gymId);

    /**
     * Adds a new time slot for a specific gym.
     *
     * @param gymId         The ID of the gym.
     * @param slotId        The ID of the slot.
     * @param slotTime      The time of the slot.
     * @param slotCapacity  The capacity of the slot.
     */
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity);

    /**
     * Removes a time slot from a specific gym.
     *
     * @param gymId     The ID of the gym.
     * @param slotId    The ID of the slot to be removed.
     */
    public void removeSlot(int gymId, int slotId);
}
