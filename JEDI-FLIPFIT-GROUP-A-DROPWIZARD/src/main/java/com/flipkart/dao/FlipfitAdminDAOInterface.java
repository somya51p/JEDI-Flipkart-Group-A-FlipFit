package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipfitAdminDAOInterface {
    public void createAdmin(int adminId, String adminEmail, String adminPassword);
    public List<FlipFitGymOwner> viewAllGymOwners();
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) throws Exception;
    public List<FlipFitGymOwner> viewGymOwnerRequests();
    public boolean approveGymOwnerRequests(int ownerId);
    public boolean removeGymOwner(int ownerId);
    public boolean cancelRequest(int ownerId);
}
