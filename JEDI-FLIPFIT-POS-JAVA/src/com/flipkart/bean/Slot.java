package com.flipkart.bean;

/**
 * Represents a time slot for a gym session.
 */
public class Slot {

    private int slotId;         // Unique identifier for the slot
    private int gymId;          // Identifier for the gym where the slot is available
    private String slotTime;    // Time of the slot
    private int slotCapacity;   // Capacity of the slot (number of people it can accommodate)

    /**
     * Constructs a Slot object with the given details.
     *
     * @param slotId       The unique identifier for the slot.
     * @param gymId        The identifier of the gym where the slot is available.
     * @param slotTime     The time of the slot.
     * @param slotCapacity The capacity of the slot.
     */
    public Slot(int slotId, int gymId, String slotTime, int slotCapacity) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.slotTime = slotTime;
        this.slotCapacity = slotCapacity;
    }

    /**
     * Gets the unique identifier for the slot.
     * @return The slot ID.
     */
    public int getSlotId() {
        return slotId;
    }

    /**
     * Sets the unique identifier for the slot.
     * @param slotId The slot ID to set.
     */
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    /**
     * Gets the identifier for the gym where the slot is available.
     * @return The gym ID.
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the identifier for the gym where the slot is available.
     * @param gymId The gym ID to set.
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets the time of the slot.
     * @return The slot time.
     */
    public String getSlotTime() {
        return slotTime;
    }

    /**
     * Sets the time of the slot.
     * @param slotTime The slot time to set.
     */
    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    /**
     * Gets the capacity of the slot.
     * @return The slot capacity.
     */
    public int getSlotCapacity() {
        return slotCapacity;
    }

    /**
     * Sets the capacity of the slot.
     * @param slotCapacity The slot capacity to set.
     */
    public void setSlotCapacity(int slotCapacity) {
        this.slotCapacity = slotCapacity;
    }
}
