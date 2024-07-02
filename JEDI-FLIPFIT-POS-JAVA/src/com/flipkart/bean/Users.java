package com.flipkart.bean;

/**
 * Represents a user in the system.
 */
public class Users {

    private int userId;           // Unique identifier for the user
    private String userEmail;     // Email address of the user
    private String userPassword;  // Password of the user
    private int roleId;           // Identifier for the role assigned to the user

    /**
     * Constructs a Users object with the given details.
     *
     * @param userId        The unique identifier for the user.
     * @param userEmail     The email address of the user.
     * @param userPassword  The password of the user.
     * @param roleId        The identifier for the role assigned to the user.
     */
    public Users(int userId, String userEmail, String userPassword, int roleId) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roleId = roleId;
    }

    /**
     * Gets the unique identifier for the user.
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user.
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the email address of the user.
     * @return The user's email address.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the email address of the user.
     * @param userEmail The email address to set.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the password of the user.
     * @return The user's password.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the password of the user.
     * @param userPassword The password to set.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets the identifier for the role assigned to the user.
     * @return The role ID.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the identifier for the role assigned to the user.
     * @param roleId The role ID to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
