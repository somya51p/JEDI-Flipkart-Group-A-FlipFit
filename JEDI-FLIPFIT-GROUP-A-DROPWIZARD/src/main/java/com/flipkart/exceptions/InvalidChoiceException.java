package main.java.com.flipkart.exceptions;

import java.io.InvalidObjectException;


public class InvalidChoiceException extends InvalidObjectException {

    public InvalidChoiceException(String message){
        super(message);
        System.out.println("Please enter valid choice");
    }
}