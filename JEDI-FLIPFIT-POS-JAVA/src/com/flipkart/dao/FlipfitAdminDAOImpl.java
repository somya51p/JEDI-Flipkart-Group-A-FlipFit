package com.flipkart.dao;

public class FlipfitAdminDAOImpl implements FlipfitAdminDAOInterface{
    @Override
    public void createAdmin(int adminId, String adminEmail, String adminPassword) {

    }

    @Override
    public boolean viewGymOwnerDetails(int ownerId) {
        return false;
    }

    @Override
    public boolean viewGymOwnerRequests() {
        return false;
    }

    @Override
    public boolean approveGymOwnerRequests(int ownerId) {
        return false;
    }

    @Override
    public boolean removeGymOwner(int ownerId) {
        return false;
    }

    @Override
    public boolean cancelRequest(int ownerId) {
        return false;
    }
}
