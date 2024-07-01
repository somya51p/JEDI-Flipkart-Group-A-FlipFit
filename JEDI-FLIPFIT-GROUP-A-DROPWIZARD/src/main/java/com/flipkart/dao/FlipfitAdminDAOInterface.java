package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

/**
 * Interface for administrative operations related to gym owners.
 */
public interface FlipfitAdminDAOInterface {

    /**
     * Creates a new admin with the specified details.
     *
     * @param adminId       The ID of the admin.
     * @param adminEmail    The email of the admin.
     * @param adminPassword The password of the admin.
     */
    public void createAdmin(int adminId, String adminEmail, String adminPassword);

    /**
     * Retrieves details of all registered gym owners.
     *
     * @return A list of FlipFitGymOwner objects representing all registered gym owners.
     */
    public List<FlipFitGymOwner> viewAllGymOwners();

    /**
     * Retrieves details of a specific gym owner based on owner ID.
     *
     * @param ownerId The ID of the gym owner to retrieve details for.
     * @return A list containing details of the gym owner identified by ownerId.
     * @throws Exception If no gym owner is found with the specified ownerId.
     */
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) throws Exception;

    /**
     * Retrieves details of gym owner requests pending approval.
     *
     * @return A list of FlipFitGymOwner objects representing pending gym owner requests.
     */
    public List<FlipFitGymOwner> viewGymOwnerRequests();

    /**
     * Approves a pending gym owner request.
     *
     * @param ownerId The ID of the gym owner request to approve.
     * @return true if the approval was successful, false otherwise.
     */
    public boolean approveGymOwnerRequests(int ownerId);

    /**
     * Removes a gym owner from the system.
     *
     * @param ownerId The ID of the gym owner to remove.
     * @return true if the removal was successful, false otherwise.
     */
    public boolean removeGymOwner(int ownerId);

    /**
     * Cancels a pending gym owner request.
     *
     * @param ownerId The ID of the gym owner request to cancel.
     * @return true if the cancellation was successful, false otherwise.
     */
    public boolean cancelRequest(int ownerId);
}
