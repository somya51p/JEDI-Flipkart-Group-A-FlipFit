package com.flipkart.dao;

public interface FlipFitGymOwnerDAOInterface {
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no);
    public void editProfile(int ownerId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, String approvalStatus);
    public void registerGym(int gymId, String name, String location);
    public void editGym(int gymId, String gymName, String gymLocation);
    public void removeGym(int gymId);
    public void viewAllRegisteredGymCenters();
    public void viewAllBookings();
    public void viewBookings(int gymId);
    public void viewAvailableSlots(int gymId);
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity);
    public void removeSlot( int slotId);
}
