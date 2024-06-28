package com.flipkart.dao;

import java.util.ArrayList;

public interface FlipfitAdminDAOInterface {
    public void createAdmin(int adminId, String adminEmail, String adminPassword);
    public ArrayList viewAllGymOwners();
    public boolean viewGymOwnerDetails(int ownerId);
    public boolean viewGymOwnerRequests();
    public boolean approveGymOwnerRequests(int ownerId);
    public boolean removeGymOwner(int ownerId);
    public boolean cancelRequest(int ownerId);
}
