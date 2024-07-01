package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipfitAdminDAOImpl;
import com.flipkart.dao.FlipfitAdminDAOInterface;

import java.util.List;

/**
 * Service class implementing FlipfitAdminInterface to provide administrative operations.
 */
public class FlipfitAdminService implements FlipfitAdminInterface {

    FlipfitAdminDAOInterface adminDAO = new FlipfitAdminDAOImpl();

    /**
     * Creates an admin with the provided details.
     *
     * @param adminId   The ID of the admin.
     * @param userId    The user ID associated with the admin.
     * @param userEmail The email of the admin.
     * @param userPass  The password of the admin.
     */
    public void createAdmin(int adminId, int userId, String userEmail, String userPass) {
        System.out.println("Admin created");
        // Actual implementation may involve storing admin details in the database via adminDAO
    }

    /**
     * Retrieves a list of all gym owners.
     *
     * @return A list of FlipFitGymOwner objects representing all gym owners.
     */
    public List<FlipFitGymOwner> viewAllGymOwners() {
        return adminDAO.viewAllGymOwners();
    }

    /**
     * Retrieves details of a specific gym owner based on ownerId.
     *
     * @param ownerId The ID of the gym owner.
     * @return A list containing details of the specified gym owner.
     */
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) {
        return adminDAO.viewGymOwnerDetails(ownerId);
    }

    /**
     * Retrieves a list of gym owner requests.
     *
     * @return A list of FlipFitGymOwner objects representing gym owner requests.
     */
    public List<FlipFitGymOwner> viewGymOwnerRequests() {
        return adminDAO.viewGymOwnerRequests();
    }

    /**
     * Approves a gym owner's request based on ownerId.
     *
     * @param ownerId The ID of the gym owner whose request is to be approved.
     */
    public void approveGymOwnerRequests(int ownerId) {
        adminDAO.approveGymOwnerRequests(ownerId);
        System.out.println("Approved the gym owner requests with Id " + ownerId);
    }

    /**
     * Removes a gym owner based on ownerId.
     *
     * @param ownerId The ID of the gym owner to be removed.
     */
    public void removeGymOwner(int ownerId) {
        adminDAO.removeGymOwner(ownerId);
        System.out.println("Removed the gym owner with Id " + ownerId);
    }

    /**
     * Cancels a gym owner's request based on ownerId.
     *
     * @param ownerId The ID of the gym owner whose request is to be canceled.
     */
    public void cancelRequest(int ownerId) {
        adminDAO.cancelRequest(ownerId);
        System.out.println("Cancelled the gym owner request with Id " + ownerId);
    }
}
