package com.vashtibauson.library.exception;

/**
 * Exception thrown when an invalid input type is encountered.
 */
public class InvalidInputTypeException extends Exception {

    /**
     * Constructs an InvalidInputTypeException with the specified detail message.
     *
     * @param message The detail message
     */
    public InvalidInputTypeException(String message) {
        super(message);
    }
}
