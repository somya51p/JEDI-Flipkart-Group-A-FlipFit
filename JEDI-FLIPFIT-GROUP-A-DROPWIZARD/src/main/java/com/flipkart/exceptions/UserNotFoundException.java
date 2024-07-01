package com.flipkart.exceptions;

/**
 * Custom exception class for user not found scenarios.
 */
public class UserNotFoundException extends Exception {

	/**
	 * Constructor to initialize the exception with a custom error message.
	 *
	 * @param message The error message describing the user not found scenario.
	 */
	public UserNotFoundException(String message) {
		super(message);
		System.out.println("User not found!!"); // Note: This print statement will not be executed upon exception creation.
	}
}
