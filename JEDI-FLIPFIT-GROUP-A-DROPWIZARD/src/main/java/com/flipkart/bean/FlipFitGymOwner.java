package com.flipkart.bean;

/**
 * Represents a gym owner in the FlipFit system.
 */
public class FlipFitGymOwner {

    private int ownerId;          // Unique identifier for the gym owner
    private String ownerName;     // Name of the gym owner
    private String ownerPhone;    // Phone number of the gym owner
    private String ownerAddress;  // Address of the gym owner
    private String ownerGstNum;   // GST number of the gym owner
    private String ownerPanNum;   // PAN number of the gym owner
    private String approvalStatus; // Approval status of the gym owner
    private int userId;           // User identifier associated with the gym owner

    /**
     * Constructs a FlipFitGymOwner object with the given details.
     *
     * @param ownerId        The unique identifier for the gym owner.
     * @param ownerName      The name of the gym owner.
     * @param ownerPhone     The phone number of the gym owner.
     * @param ownerAddress   The address of the gym owner.
     * @param ownerGstNum    The GST number of the gym owner.
     * @param ownerPanNum    The PAN number of the gym owner.
     * @param approvalStatus The approval status of the gym owner.
     * @param userId         The user identifier associated with the gym owner.
     */
    public FlipFitGymOwner(int ownerId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, String approvalStatus, int userId) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerAddress = ownerAddress;
        this.ownerGstNum = ownerGstNum;
        this.ownerPanNum = ownerPanNum;
        this.approvalStatus = approvalStatus;
        this.userId = userId;
    }

    /**
     * Retrieves the ownerId of the gym owner.
     *
     * @return The ownerId of the gym owner.
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the ownerId for the gym owner.
     *
     * @param ownerId The ownerId to set.
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Retrieves the ownerName of the gym owner.
     *
     * @return The ownerName of the gym owner.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the ownerName for the gym owner.
     *
     * @param ownerName The ownerName to set.
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Retrieves the ownerPhone of the gym owner.
     *
     * @return The ownerPhone of the gym owner.
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }

    /**
     * Sets the ownerPhone for the gym owner.
     *
     * @param ownerPhone The ownerPhone to set.
     */
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    /**
     * Retrieves the ownerAddress of the gym owner.
     *
     * @return The ownerAddress of the gym owner.
     */
    public String getOwnerAddress() {
        return ownerAddress;
    }

    /**
     * Sets the ownerAddress for the gym owner.
     *
     * @param ownerAddress The ownerAddress to set.
     */
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    /**
     * Retrieves the ownerGstNum of the gym owner.
     *
     * @return The ownerGstNum of the gym owner.
     */
    public String getOwnerGstNum() {
        return ownerGstNum;
    }

    /**
     * Sets the ownerGstNum for the gym owner.
     *
     * @param ownerGstNum The ownerGstNum to set.
     */
    public void setOwnerGstNum(String ownerGstNum) {
        this.ownerGstNum = ownerGstNum;
    }

    /**
     * Retrieves the ownerPanNum of the gym owner.
     *
     * @return The ownerPanNum of the gym owner.
     */
    public String getOwnerPanNum() {
        return ownerPanNum;
    }

    /**
     * Sets the ownerPanNum for the gym owner.
     *
     * @param ownerPanNum The ownerPanNum to set.
     */
    public void setOwnerPanNum(String ownerPanNum) {
        this.ownerPanNum = ownerPanNum;
    }

    /**
     * Retrieves the approvalStatus of the gym owner.
     *
     * @return The approvalStatus of the gym owner.
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Sets the approvalStatus for the gym owner.
     *
     * @param approvalStatus The approvalStatus to set.
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * Retrieves the userId associated with the gym owner.
     *
     * @return The userId associated with the gym owner.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the userId associated with the gym owner.
     *
     * @param userId The userId to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
