package com.maharjan.amit.testingExceptions;

public class InvalidTransactionAmountException extends RuntimeException{
    public InvalidTransactionAmountException(String message) {
        super(message);
    }
}
