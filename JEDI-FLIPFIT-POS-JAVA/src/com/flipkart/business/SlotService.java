package com.flipkart.business;

import com.flipkart.bean.Slot;

public class SlotService {
     Slot slot = new Slot();
    public void createSlot(int slotId, int gymId, String slotTime, int slotCapacity)
    {
        slot.setSlotId(slotId);
        slot.setGymId(gymId);
        slot.setSlotTime(slotTime);
        slot.setSlotCapacity(slotCapacity);

        System.out.println("Slot Successfully created!");
    }
}
