package com.flipkart.dao;

public interface FlipFitGymOwnerDAOInterface {
    public void createGymOwner(int id, String name, String email, String phone, String address, String pan_no, String gst_no, String status);
    public void editProfile(int id, String name, String email, String phone, String password, String address, String pan_no, String gst_no, String status);
    public void registerGym(int gymId, String name, String location);
    public void editGym(int gymId);
    public void removeGym(int gymId);
    public void viewAllRegisteredGymCenters();
    public void viewAllBookings();
    public void viewBookings(int gymId);
    public void viewAvailableSlots(int gymId);
    public void addSlot(int gymId, int slotId);
    public void removeSlot(int gymId, int slotId);
}
