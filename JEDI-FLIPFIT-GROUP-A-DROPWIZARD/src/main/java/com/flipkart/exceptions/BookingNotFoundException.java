package com.flipkart.exceptions;

/**
 * Custom exception class for handling booking not found scenarios.
 */
public class BookingNotFoundException extends Exception {

    /**
     * Constructor to initialize the exception with a custom error message.
     *
     * @param message Error message describing the reason for booking not being found.
     */
    public BookingNotFoundException(String message) {
        super(message);
    }
}
