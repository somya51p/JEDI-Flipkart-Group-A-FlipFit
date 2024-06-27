package com.flipkart.business;

public interface FlipfitAdminInterface {
    public void createAdmin(int adminId, int userId, String email, String password, int roleId, String roleName, String roleDescription);
    public boolean viewGymOwnerDetails(int ownerId);
    public boolean viewGymOwnerRequests();
    public boolean approveGymOwnerRequests(int ownerId);
    public boolean removeGymOwner(int ownerId);
    public boolean cancelRequest(int ownerId);
}
