package com.flipkart.exceptions;

/**
 * Custom exception class for handling gym not found scenarios.
 */
public class GymNotFoundException extends Exception {

    /**
     * Constructor to initialize the exception with a custom error message based on the gym ID.
     *
     * @param gymId The ID of the gym that was not found.
     */
    public GymNotFoundException(int gymId) {
        super("Gym Centre " + gymId + " not found!");
    }
}
