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

    public void viewAllGymOwners(){
        List<FlipFitGymOwner> Output = adminDAO.viewAllGymOwners();
        for(FlipFitGymOwner s: Output){
            System.out.println("Owner ID: " + s.getOwnerId() + " ---> " + "Owner Name: " + s.getOwnerName());
        }
    }

    public void viewGymOwnerDetails(int ownerId){
        List<FlipFitGymOwner> Output = adminDAO.viewGymOwnerDetails(ownerId);
        System.out.println("View All the approved gym owner details");
        for(FlipFitGymOwner s : Output){
            System.out.println("ID: " + s.getOwnerId());
            System.out.println("Name: " + s.getOwnerName());
            System.out.println("Phone: " + s.getOwnerId());
            System.out.println("Address: " + s.getOwnerAddress());
            System.out.println("GST Number: " + s.getOwnerGstNum());
            System.out.println("PAN Number: " + s.getOwnerPanNum());
            System.out.println("Approval Status: " + s.getApprovalStatus());
            System.out.println("=================================");
        }
    }

    public void viewGymOwnerRequests(){
        List<FlipFitGymOwner> Output = adminDAO.viewGymOwnerRequests();
        System.out.println("View all the gym owner pending requests");
        for(FlipFitGymOwner s : Output){
            System.out.println("ID: " + s.getOwnerId());
            System.out.println("Name: " + s.getOwnerName());
            System.out.println("Phone: " + s.getOwnerId());
            System.out.println("Address: " + s.getOwnerAddress());
            System.out.println("GST Number: " + s.getOwnerGstNum());
            System.out.println("PAN Number: " + s.getOwnerPanNum());
            System.out.println("Approval Status: " + s.getApprovalStatus());
            System.out.println("=================================");
        }
    }
    public boolean approveGymOwnerRequests(int ownerId){
        adminDAO.approveGymOwnerRequests(ownerId);
        System.out.println("Approve the gym owner requests with Id "+ ownerId);
        return true;
    }
    public boolean removeGymOwner(int ownerId){
        adminDAO.removeGymOwner(ownerId);
        System.out.println("Remove the gym owner with Id "+ ownerId);
        return true;
    }
    public boolean cancelRequest(int ownerId) {
        adminDAO.cancelRequest(ownerId);
        System.out.println("Cancel the gym owner request with Id " + ownerId);
        return true;
    }
}
