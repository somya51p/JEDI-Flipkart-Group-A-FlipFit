package com.flipkart.bean;

/**
 * Represents a user in the system with basic details.
 */
public class Users {

    private int userId;         // Unique identifier for the user
    private String userEmail;   // Email address of the user
    private String userPassword;// Password of the user
    private int roleId;         // Role ID indicating the user's role in the system

    /**
     * Constructor to initialize a Users object.
     *
     * @param userId       The unique identifier for the user.
     * @param userEmail    The email address of the user.
     * @param userPassword The password of the user.
     * @param roleId       The role ID indicating the user's role in the system.
     */
    public Users(int userId, String userEmail, String userPassword, int roleId) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roleId = roleId;
    }

    /**
     * Retrieves the user ID.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The user's email address.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the email address of the user.
     *
     * @param userEmail The user's email address to set.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The user's password.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the password of the user.
     *
     * @param userPassword The user's password to set.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Retrieves the role ID indicating the user's role in the system.
     *
     * @return The role ID of the user.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID indicating the user's role in the system.
     *
     * @param roleId The role ID to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
