package com.rs.core.examples;

public class CustomException extends Exception {
    // You can add constructors and other methods if needed
    public CustomException() {
        this("This is a custom exception."); // Call the parameterized constructor
    }

    public CustomException(String message) {
        super(message);
    }
}
