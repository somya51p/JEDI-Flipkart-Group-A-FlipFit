package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;

import java.util.List;

public interface FlipFitGymOwnerDAOInterface {
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no);
    public void editProfile(int userId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum);
    public void registerGym(int userId, String name, String location);
    public void editGym(int gymId, String gymName, String gymLocation);
    public void removeGym(int gymId);
    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId);
    public List<Booking> viewAllBookings(int userId);
    public List<Booking> viewBookings(int gymId);
    public List<Slot> viewAvailableSlots(int gymId);
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity, int slotPrice);
    public void removeSlot( int gymId,int slotId);
}
