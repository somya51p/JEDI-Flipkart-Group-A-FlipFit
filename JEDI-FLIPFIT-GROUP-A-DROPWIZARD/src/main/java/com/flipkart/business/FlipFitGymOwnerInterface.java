package com.flipkart.business;

public interface FlipFitGymOwnerInterface {

    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no);
    public void editProfile(int userId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum);
    public void registerGym(int gymId, String name, String location);
    public void editGym(int gymId, String gymName, String gymLocation);
    public void removeGym(int gymId);
    public void viewAllRegisteredGymCenters(int userId);
    public void viewAllBookings(int userId);
    public void viewBookings(int gymId);
    public void viewAvailableSlots(int gymId,String date);
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity);
    public void removeSlot( int gymId, int slotId);
}
