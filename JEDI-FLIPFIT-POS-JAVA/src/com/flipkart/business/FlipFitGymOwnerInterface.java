package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;

import java.util.HashMap;
import java.util.List;

/**
 * Interface defining operations for a Gym Owner in the FlipFit application.
 */
public interface FlipFitGymOwnerInterface {

    /**
     * Creates a new Gym Owner with the specified details.
     *
     * @param userId   The user ID associated with the Gym Owner.
     * @param name     The name of the Gym Owner.
     * @param phone    The phone number of the Gym Owner.
     * @param address  The address of the Gym Owner.
     * @param pan_no   The PAN number of the Gym Owner.
     * @param gst_no   The GST number of the Gym Owner.
     */
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no);

    /**
     * Edits the profile of the Gym Owner with the specified details.
     *
     * @param userId         The user ID of the Gym Owner.
     * @param ownerName      The updated name of the Gym Owner.
     * @param ownerPhone     The updated phone number of the Gym Owner.
     * @param ownerAddress   The updated address of the Gym Owner.
     * @param ownerGstNum    The updated GST number of the Gym Owner.
     * @param ownerPanNum    The updated PAN number of the Gym Owner.
     */
    public void editProfile(int userId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum);

    /**
     * Registers a new gym under the Gym Owner.
     *
     * @param userId    The user ID of the Gym Owner.
     * @param name      The name of the Gym to register.
     * @param location  The location of the Gym.
     */
    public void registerGym(int userId, String name, String location);

    /**
     * Edits the details of an existing Gym.
     *
     * @param gymId       The ID of the Gym to edit.
     * @param gymName     The updated name of the Gym.
     * @param gymLocation The updated location of the Gym.
     */
    public void editGym(int gymId, String gymName, String gymLocation);

    /**
     * Removes a Gym owned by the Gym Owner.
     *
     * @param gymId   The ID of the Gym to remove.
     */
    public void removeGym(int gymId);

    /**
     * Retrieves a list of all Gyms registered by the Gym Owner.
     *
     * @param userId   The user ID of the Gym Owner.
     * @return         List of all registered Gyms.
     */
    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId);

    /**
     * Retrieves a list of all bookings made across all Gyms owned by the Gym Owner.
     *
     * @param userId   The user ID of the Gym Owner.
     * @return         List of all bookings across Gyms.
     */
    public List<Booking> viewAllBookings(int userId);

    /**
     * Retrieves a list of bookings made for a specific Gym.
     *
     * @param gymId   The ID of the Gym to retrieve bookings for.
     * @return        List of bookings for the specified Gym.
     */
    public List<Booking> viewBookings(int gymId);

    /**
     * Retrieves available slots for a specific Gym on a given date.
     *
     * @param gymId   The ID of the Gym to retrieve available slots for.
     * @param date    The date for which slots are to be retrieved.
     * @return        HashMap containing slot times as keys and available capacities as values.
     */
    public HashMap<String,Integer> viewAvailableSlots(int gymId, String date);

    /**
     * Adds a new slot for bookings to a specific Gym.
     *
     * @param gymId         The ID of the Gym to add the slot to.
     * @param slotId        The ID of the slot to add.
     * @param slotTime      The time of the slot.
     * @param slotCapacity  The capacity of the slot.
     * @param slotPrice     The price of the slot.
     */
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity, int slotPrice);

    /**
     * Removes a slot from a specific Gym.
     *
     * @param gymId   The ID of the Gym to remove the slot from.
     * @param slotId  The ID of the slot to remove.
     */
    public void removeSlot(int gymId, int slotId);
}
