package com.flipkart.business;

/**
 * Interface defining operations related to user authentication and creation in FlipFit.
 */
public interface FlipFitUserInterface {

    /**
     * Authenticates a user based on email, password, and role ID.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @param roleId   The role ID of the user.
     * @return An integer representing the authentication result.
     */
    public int authenticateUser(String email, String password, int roleId);

    /**
     * Creates a new user with the specified name, password, and role ID.
     *
     * @param name     The name of the user.
     * @param password The password of the user.
     * @param roleId   The role ID of the user.
     * @return An integer representing the creation result.
     */
    public int createUser(String name, String password, int roleId);
}
