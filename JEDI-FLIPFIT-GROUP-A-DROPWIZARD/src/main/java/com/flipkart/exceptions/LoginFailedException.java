package com.flipkart.exceptions;

/**
 * Custom exception class for login failures.
 */
public class LoginFailedException extends RuntimeException {

    /**
     * Constructor to initialize the exception with a custom error message.
     *
     * @param message The error message describing the reason for login failure.
     */
    public LoginFailedException(String message) {
        super(message);
        System.out.println("Unable to login, Check your username and password");
        // Note: This print statement will not be executed upon exception creation.
    }
}
