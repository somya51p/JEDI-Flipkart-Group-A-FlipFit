package com.flipkart.exceptions;

/**
 * Custom exception class for handling gym owner not found scenarios.
 */
public class GymOwnerNotFoundException extends Exception {

    /**
     * Constructor to initialize the exception with a custom error message based on the owner ID.
     *
     * @param ownerId The ID of the gym owner that was not found.
     */
    public GymOwnerNotFoundException(int ownerId) {
        super("Gym Owner " + ownerId + " not found!");
    }
}
