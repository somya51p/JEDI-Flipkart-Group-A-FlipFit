package com.flipkart.business;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipfitAdminDAOImpl;
import com.flipkart.dao.FlipfitAdminDAOInterface;

import java.util.List;


public class FlipfitAdminService implements FlipfitAdminInterface{
    FlipfitAdminDAOInterface adminDAO = new FlipfitAdminDAOImpl();

    public void createAdmin(int adminId, int userId, String userEmail, String userPass){
        System.out.println("Admin created");
    }

    public List<FlipFitGymOwner> viewAllGymOwners(){
        return adminDAO.viewAllGymOwners();
    }

    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId){
        return adminDAO.viewGymOwnerDetails(ownerId);
    }

    public List<FlipFitGymOwner> viewGymOwnerRequests(){
        return adminDAO.viewGymOwnerRequests();

    }
    public void approveGymOwnerRequests(int ownerId){
        adminDAO.approveGymOwnerRequests(ownerId);
        System.out.println("Approved the gym owner requests with Id "+ ownerId);
    }
    public void removeGymOwner(int ownerId){
        adminDAO.removeGymOwner(ownerId);
        System.out.println("Removed the gym owner with Id "+ ownerId);
    }
    public void cancelRequest(int ownerId) {
        adminDAO.cancelRequest(ownerId);
        System.out.println("Cancelled the gym owner request with Id " + ownerId);
    }
}
