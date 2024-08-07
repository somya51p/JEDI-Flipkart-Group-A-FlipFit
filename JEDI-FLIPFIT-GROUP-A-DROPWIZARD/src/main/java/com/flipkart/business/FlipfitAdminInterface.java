package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipfitAdminInterface {
    public void createAdmin(int adminId, int userId, String userEmail, String userPass);
    public List<FlipFitGymOwner> viewAllGymOwners();
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) throws Exception;
    public List<FlipFitGymOwner> viewGymOwnerRequests();
    public boolean approveGymOwnerRequests(int ownerId);
    public void removeGymOwner(int ownerId);
    public void cancelRequest(int ownerId);
}
