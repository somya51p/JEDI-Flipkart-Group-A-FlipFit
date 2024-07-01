package com.flipkart.business;

/**
 * Interface for managing user-related operations.
 */
public interface FlipFitUserInterface {

    /**
     * Authenticates a user based on email, password, and role ID.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @param roleId   The role ID of the user.
     * @return An integer representing the user's authentication status.
     */
    public int authenticateUser(String email, String password, int roleId);

    /**
     * Creates a new user with the specified name, password, and role ID.
     *
     * @param name     The name of the user.
     * @param password The password of the user.
     * @param roleId   The role ID of the user.
     * @return An integer representing the success status of user creation.
     */
    public int createUser(String name, String password, int roleId);
}
