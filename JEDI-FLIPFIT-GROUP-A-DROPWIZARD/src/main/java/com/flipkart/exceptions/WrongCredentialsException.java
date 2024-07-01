package com.flipkart.exceptions;

/**
 * Custom exception class for wrong credentials scenarios.
 */
public class WrongCredentialsException extends Exception {

	/**
	 * Constructor to initialize the exception with a default error message.
	 */
	public WrongCredentialsException() {
		super("Invalid Credentials!"); // Sets the error message using the parent class constructor.
	}
}
