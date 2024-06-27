package com.flipkart.business;
import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.Roles;
import com.flipkart.bean.Users;

public class FlipfitAdminService implements FlipfitAdminInterface{
        FlipFitAdmin flipfitadmin = new FlipFitAdmin();
        Users user= new Users();

        public void createAdmin(int adminId, int userId, String userEmail, String userPass){

              flipfitadmin.setUserId(userId);

              user.setUserEmail(userEmail);
              user.setUserPassword(userPass);

              user.setRoleId(3);
              flipfitadmin.setAdminId(adminId);
              user.setUserId(userId);

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
