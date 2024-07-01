package com.flipkart.bean;

/**
 * Represents a time slot in a gym with details such as ID, gym ID, time, and capacity.
 */
public class Slot {

    private int slotId;         // Unique identifier for the slot
    private int gymId;          // ID of the gym to which the slot belongs
    private String slotTime;    // Time of the slot (e.g., "10:00 AM - 11:00 AM")
    private int slotCapacity;   // Maximum capacity of the slot

    /**
     * Constructor to initialize a Slot object.
     *
     * @param slotId       The unique identifier for the slot.
     * @param gymId        The ID of the gym to which the slot belongs.
     * @param slotTime     The time period of the slot (e.g., "10:00 AM - 11:00 AM").
     * @param slotCapacity The maximum capacity of the slot.
     */
    public Slot(int slotId, int gymId, String slotTime, int slotCapacity) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.slotTime = slotTime;
        this.slotCapacity = slotCapacity;
    }

    /**
     * Retrieves the slot ID.
     *
     * @return The slot ID.
     */
    public int getSlotId() {
        return slotId;
    }

    /**
     * Sets the slot ID.
     *
     * @param slotId The slot ID to set.
     */
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    /**
     * Retrieves the gym ID associated with the slot.
     *
     * @return The gym ID.
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the gym ID associated with the slot.
     *
     * @param gymId The gym ID to set.
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Retrieves the time period of the slot.
     *
     * @return The slot time.
     */
    public String getSlotTime() {
        return slotTime;
    }

    /**
     * Sets the time period of the slot.
     *
     * @param slotTime The slot time to set.
     */
    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    /**
     * Retrieves the maximum capacity of the slot.
     *
     * @return The slot capacity.
     */
    public int getSlotCapacity() {
        return slotCapacity;
    }

    /**
     * Sets the maximum capacity of the slot.
     *
     * @param slotCapacity The slot capacity to set.
     */
    public void setSlotCapacity(int slotCapacity) {
        this.slotCapacity = slotCapacity;
    }
}
