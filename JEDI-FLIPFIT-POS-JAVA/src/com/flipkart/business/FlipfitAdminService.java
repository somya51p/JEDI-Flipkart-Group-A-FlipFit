package com.flipkart.business;

public class FlipfitAdminService {
        FlipfitAdmin flipfitadmin = new FlipfitAdmin();

        public void createAdmin(int adminId, String adminEmail, String adminPassword){
              flipfitadmin.setAdminId(adminId);
              flipfitadmin.setAdminEmail(adminEmail);
              flipfitadmin.setAdminPassword(adminPassword);
              System.out.println("Admin created");
        }

        public boolean viewGymOwnerDetails(int ownerId){
              System.out.println("View All the approved gym owner details");
              return true;
        }
        public boolean viewGymOwnerRequests(){
                System.out.println("View all the gym owner pending requests");
                return true;
        }
        public boolean approveGymOwnerRequests(int ownerId){
                System.out.println("Approve the gym owner requests with Id "+ ownerId);
                return true;
        }
        public boolean removeGymOwner(int ownerId){
                System.out.println("Remove the gym owner with Id "+ ownerId);
                return true;
        }
        public boolean cancelRequest(int ownerId) {
                System.out.println("Cancel the gym owner request with Id " + ownerId);
                return true;
        }
}
