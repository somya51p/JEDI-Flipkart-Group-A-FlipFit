package com.flipkart.business;

import com.flipkart.dao.FlipFitUserDAOImpl;
import com.flipkart.dao.FlipFitUserDAOInterface;

/**
 * Service class implementing FlipFitUserInterface for user authentication and creation operations.
 */
public class FlipFitUserService implements FlipFitUserInterface {

    FlipFitUserDAOInterface userDAO = new FlipFitUserDAOImpl();

    /**
     * Authenticates a user based on email, password, and role ID.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @param roleId   The role ID of the user.
     * @return An integer representing the authentication result.
     */
    public int authenticateUser(String email, String password, int roleId) {
        try {
            return userDAO.authenticateUser(email, password, roleId);
        } catch (Exception e) {
            System.out.println(e);
            return 0; // Return 0 on error
        }
    }

    /**
     * Creates a new user with the specified email, password, and role ID.
     *
     * @param email    The email of the user to create.
     * @param password The password of the user to create.
     * @param roleId   The role ID of the user to create.
     * @return The ID of the newly created user if successful, otherwise 0.
     */
    public int createUser(String email, String password, int roleId) {
        int userId = userDAO.createUser(email, password, roleId);
        if (userId > 0) {
            System.out.println("User created");
            return userId; // Return user ID if creation is successful
        } else {
            System.out.println("User creation failed");
        }
        return 0; // Return 0 if creation failed
    }
}
