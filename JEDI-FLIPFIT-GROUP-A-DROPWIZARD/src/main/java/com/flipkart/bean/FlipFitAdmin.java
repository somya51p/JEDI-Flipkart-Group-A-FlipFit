package com.flipkart.bean;

/**
 * Represents an administrator in the FlipFit system.
 */
public class FlipFitAdmin {
    private int adminId;  // Unique identifier for the administrator
    private int userId;   // Identifier of the associated user

    /**
     * Constructs a FlipFitAdmin object with the given adminId and userId.
     *
     * @param adminId The unique identifier for the administrator.
     * @param userId  The identifier of the associated user.
     */
    public FlipFitAdmin(int adminId, int userId) {
        this.adminId = adminId;
        this.userId = userId;
    }

    /**
     * Retrieves the adminId of the administrator.
     *
     * @return The adminId of the administrator.
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * Sets the adminId for the administrator.
     *
     * @param adminId The adminId to set.
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * Retrieves the userId associated with the administrator.
     *
     * @return The userId associated with the administrator.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the userId associated with the administrator.
     *
     * @param userId The userId to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
