package com.flipkart.business;
import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.Roles;
import com.flipkart.bean.Users;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.dao.FlipfitAdminDAOImpl;
import com.flipkart.dao.FlipfitAdminDAOInterface;


public class FlipfitAdminService implements FlipfitAdminInterface{

        FlipfitAdminDAOInterface adminDAO = new FlipfitAdminDAOImpl();

        public void createAdmin(int adminId, int userId, String userEmail, String userPass){
            System.out.println("Admin created");
        }

        public boolean viewGymOwnerDetails(int ownerId){
            adminDAO.viewGymOwnerDetails(ownerId);
            System.out.println("View All the approved gym owner details");
            return true;
        }
        public boolean viewGymOwnerRequests(){
            adminDAO.viewGymOwnerRequests();
            System.out.println("View all the gym owner pending requests");
            return true;
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
