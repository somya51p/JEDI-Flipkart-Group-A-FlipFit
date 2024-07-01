package com.flipkart.dao;

/**
 * Interface for User Data Access Object (DAO) operations.
 */
public interface FlipFitUserDAOInterface {

    /**
     * Authenticates a user based on email, password, and role ID.
     *
     * @param email The email of the user.
     * @param password The password of the user.
     * @param roleId The role ID of the user.
     * @return The user ID if authentication succeeds, 0 otherwise.
     */
    public int authenticateUser(String email, String password, int roleId);

    /**
     * Creates a new user record in the database.
     *
     * @param name The name of the user.
     * @param password The password of the user.
     * @param roleId The role ID of the user.
     * @return The generated user ID if user creation succeeds, 0 otherwise.
     */
    public int createUser(String name, String password, int roleId);

}
