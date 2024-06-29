package main.java.com.flipkart.bean;

public class Slot {

    private int slotId;
    private int gymId;
    private String slotTime;
    private int slotCapacity;

    public Slot(int slotId, int gymId, String slotTime, int slotCapacity) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.slotTime = slotTime;
        this.slotCapacity = slotCapacity;
    }
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public int getSlotCapacity() {
        return slotCapacity;
    }

    public void setSlotCapacity(int slotCapacity) {
        this.slotCapacity = slotCapacity;
    }
}
