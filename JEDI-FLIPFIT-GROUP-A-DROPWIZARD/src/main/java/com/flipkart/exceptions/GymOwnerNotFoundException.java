package com.flipkart.exceptions;

public class GymOwnerNotFoundException extends Exception{
    public GymOwnerNotFoundException(int ownerId) {
        super("Gym Owner " + ownerId + " not found!");
    }
}
