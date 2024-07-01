package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipfitAdminDAOImpl;
import com.flipkart.dao.FlipfitAdminDAOInterface;

import java.util.List;

/**
 * Service class implementing FlipfitAdminInterface.
 * Handles administrative operations for managing gym owners in the FlipFit system.
 */
public class FlipfitAdminService implements FlipfitAdminInterface {

    FlipfitAdminDAOInterface adminDAO = new FlipfitAdminDAOImpl();

    /**
     * Creates a new admin with the provided details.
     *
     * @param adminId   The ID of the admin.
     * @param userId    The ID of the user associated with the admin.
     * @param userEmail The email of the admin.
     * @param userPass  The password of the admin.
     */
    public void createAdmin(int adminId, int userId, String userEmail, String userPass) {
        System.out.println("Admin created");
    }

    /**
     * Retrieves a list of all gym owners in the system.
     *
     * @return A list of FlipFitGymOwner objects representing gym owners.
     */
    public List<FlipFitGymOwner> viewAllGymOwners() {
        return adminDAO.viewAllGymOwners();
    }

    /**
     * Retrieves details of a specific gym owner.
     *
     * @param ownerId The ID of the gym owner.
     * @return A list of FlipFitGymOwner objects representing the gym owner details.
     * @throws Exception if there is an error while retrieving gym owner details.
     */
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) throws Exception {
        return adminDAO.viewGymOwnerDetails(ownerId);
    }

    /**
     * Retrieves a list of gym owner requests awaiting approval.
     *
     * @return A list of FlipFitGymOwner objects representing gym owner requests.
     */
    public List<FlipFitGymOwner> viewGymOwnerRequests() {
        return adminDAO.viewGymOwnerRequests();
    }

    /**
     * Approves a gym owner request.
     *
     * @param ownerId The ID of the gym owner to approve.
     * @return true if the gym owner request is approved successfully, false otherwise.
     */
    public boolean approveGymOwnerRequests(int ownerId) {
        System.out.println("Approved the gym owner requests with Id " + ownerId);
        return adminDAO.approveGymOwnerRequests(ownerId);
    }

    /**
     * Removes a gym owner from the system.
     *
     * @param ownerId The ID of the gym owner to remove.
     */
    public void removeGymOwner(int ownerId) {
        adminDAO.removeGymOwner(ownerId);
        System.out.println("Removed the gym owner with Id " + ownerId);
    }

    /**
     * Cancels a pending request from a gym owner.
     *
     * @param ownerId The ID of the gym owner whose request is to be canceled.
     */
    public void cancelRequest(int ownerId) {
        adminDAO.cancelRequest(ownerId);
        System.out.println("Cancelled the gym owner request with Id " + ownerId);
    }
}
