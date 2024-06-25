package com.flipkart.bean;

public class FlipFitGym {
    private int id;
    private int gymOwnerId;
    private String gymName;
    private String location;
    private boolean approvalStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(int gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
