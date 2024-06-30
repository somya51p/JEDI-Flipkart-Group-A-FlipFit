package com.flipkart.business;

public interface FlipfitAdminInterface {
    public void createAdmin(int adminId, int userId, String userEmail, String userPass);
    public void viewAllGymOwners();
    public void viewGymOwnerDetails(int ownerId);
    public void viewGymOwnerRequests();
    public boolean approveGymOwnerRequests(int ownerId);
    public boolean removeGymOwner(int ownerId);
    public boolean cancelRequest(int ownerId);
}
