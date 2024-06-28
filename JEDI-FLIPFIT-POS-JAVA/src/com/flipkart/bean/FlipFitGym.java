package com.flipkart.bean;

public class FlipFitGym {
    private int gymId;
    private int gymOwnerId;
    private String gymName;
    private String gymLocation;

    public FlipFitGym(int gymId, int gymOwnerId, String gymName, String gymLocation) {
        this.gymId = gymId;
        this.gymOwnerId = gymOwnerId;
        this.gymName = gymName;
        this.gymLocation = gymLocation;
    }
    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
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

    public String getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }
}
