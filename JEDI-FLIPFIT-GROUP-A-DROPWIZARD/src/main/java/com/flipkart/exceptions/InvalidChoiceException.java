package com.flipkart.exceptions;

import java.io.InvalidObjectException;

/**
 * Custom exception class for handling invalid choices.
 */
public class InvalidChoiceException extends InvalidObjectException {

    /**
     * Constructor to initialize the exception with a custom error message.
     *
     * @param message The error message describing the invalid choice.
     */
    public InvalidChoiceException(String message) {
        super(message);
        System.out.println("Please enter valid choice"); // Note: This print statement will not be executed upon exception creation.
    }
}
