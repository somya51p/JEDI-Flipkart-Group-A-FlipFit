package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;

/**
 * Interface for Flipfit Admin operations.
 */
public interface FlipfitAdminInterface {

    /**
     * Creates an admin with the specified details.
     *
     * @param adminId The ID of the admin.
     * @param userId The user ID associated with the admin.
     * @param userEmail The email of the admin.
     * @param userPass The password of the admin.
     */
    public void createAdmin(int adminId, int userId, String userEmail, String userPass);

    /**
     * Views all gym owners.
     *
     * @return A list of all gym owners.
     */
    public List<FlipFitGymOwner> viewAllGymOwners();

    /**
     * Views details of a specific gym owner.
     *
     * @param ownerId The ID of the gym owner.
     * @return A list containing details of the specified gym owner.
     */
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId);

    /**
     * Views all gym owner requests.
     *
     * @return A list of gym owner requests.
     */
    public List<FlipFitGymOwner> viewGymOwnerRequests();

    /**
     * Approves a gym owner's request.
     *
     * @param ownerId The ID of the gym owner whose request is to be approved.
     */
    public void approveGymOwnerRequests(int ownerId);

    /**
     * Removes a gym owner.
     *
     * @param ownerId The ID of the gym owner to be removed.
     */
    public void removeGymOwner(int ownerId);

    /**
     * Cancels a gym owner's request.
     *
     * @param ownerId The ID of the gym owner whose request is to be canceled.
     */
    public void cancelRequest(int ownerId);
}
