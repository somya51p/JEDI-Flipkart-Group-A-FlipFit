package com.flipkart.exceptions;

/**
 * Custom exception class for handling booking failures.
 */
public class BookingFailedException extends Exception {

    /**
     * Constructor to initialize the exception with a custom error message.
     *
     * @param message Error message describing the reason for the booking failure.
     */
    public BookingFailedException(String message) {
        super(message);
    }
}
