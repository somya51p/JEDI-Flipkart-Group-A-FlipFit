package com.flipkart.bean;

public class FlipFitGymOwner {

    private int ownerId;
    private String ownerName;
    private String ownerPhone;
    private String ownerAddress;
    private String ownerGstNum;
    private String ownerPanNum;
    private String approvalStatus;
    private int userId;

    public FlipFitGymOwner(int ownerId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, String approvalStatus, int userId ) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerAddress = ownerAddress;
        this.ownerGstNum = ownerGstNum;
        this.ownerPanNum = ownerPanNum;
        this.approvalStatus = approvalStatus;
        this.userId = userId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPanNum() {
        return ownerPanNum;
    }

    public void setOwnerPanNum(String ownerPanNum) {
        this.ownerPanNum = ownerPanNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerGstNum() {
        return ownerGstNum;
    }

    public void setOwnerGstNum(String ownerGstNum) {
        this.ownerGstNum = ownerGstNum;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
