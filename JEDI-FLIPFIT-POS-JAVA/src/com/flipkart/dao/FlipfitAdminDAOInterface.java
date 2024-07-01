package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

/**
 * Interface defining operations for admin management of gym owners in FlipFit system.
 */
public interface FlipfitAdminDAOInterface {

    /**
     * Creates a new admin with specified details.
     *
     * @param adminId       ID of the admin.
     * @param adminEmail    Email of the admin.
     * @param adminPassword Password of the admin.
     */
    public void createAdmin(int adminId, String adminEmail, String adminPassword);

    /**
     * Retrieves a list of all registered gym owners.
     *
     * @return List of FlipFitGymOwner objects representing all registered gym owners.
     */
    public List<FlipFitGymOwner> viewAllGymOwners();

    /**
     * Retrieves details of a specific gym owner identified by ownerId.
     *
     * @param ownerId ID of the gym owner whose details are to be retrieved.
     * @return List containing details of the gym owner identified by ownerId.
     */
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId);

    /**
     * Retrieves a list of gym owner requests pending for approval.
     *
     * @return List of FlipFitGymOwner objects representing pending gym owner requests.
     */
    public List<FlipFitGymOwner> viewGymOwnerRequests();

    /**
     * Approves a pending gym owner request identified by ownerId.
     *
     * @param ownerId ID of the gym owner whose request is to be approved.
     * @return true if the request is approved successfully, false otherwise.
     */
    public boolean approveGymOwnerRequests(int ownerId);

    /**
     * Removes a gym owner identified by ownerId.
     *
     * @param ownerId ID of the gym owner to be removed.
     * @return true if the gym owner is successfully removed, false otherwise.
     */
    public boolean removeGymOwner(int ownerId);

    /**
     * Cancels a pending request for gym owner approval identified by ownerId.
     *
     * @param ownerId ID of the gym owner whose request is to be canceled.
     * @return true if the request is successfully canceled, false otherwise.
     */
    public boolean cancelRequest(int ownerId);
}
