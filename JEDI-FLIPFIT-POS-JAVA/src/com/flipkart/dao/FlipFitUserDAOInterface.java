package com.flipkart.dao;

public interface FlipFitUserDAOInterface {
    /**
     * Authenticates a user based on email, password, and role ID.
     *
     * @param email     The email of the user to authenticate.
     * @param password  The password of the user.
     * @param roleId    The role ID of the user (e.g., customer, gym owner).
     * @return          The user ID if authentication is successful; otherwise, 0.
     */
    public int authenticateUser(String email, String password, int roleId);

    /**
     * Creates a new user entry in the database.
     *
     * @param name      The name of the user.
     * @param password  The password of the user.
     * @param roleId    The role ID of the user (e.g., customer, gym owner).
     * @return          The generated user ID if creation is successful; otherwise, 0.
     */
    public int createUser(String name, String password, int roleId);
}
