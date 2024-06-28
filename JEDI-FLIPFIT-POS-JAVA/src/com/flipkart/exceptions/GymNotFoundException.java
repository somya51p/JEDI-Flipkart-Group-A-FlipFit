package com.flipkart.exceptions;

public class GymNotFoundException extends Exception{
    public GymNotFoundException(int gymId){
        super("Gym Centre " + gymId + " not found!");
    }
}