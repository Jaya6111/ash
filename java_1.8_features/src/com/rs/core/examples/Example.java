package com.rs.core.examples;

public class Example {
	public static void main(String[] args) {
		try {
			// Some code that may throw your custom exception
			validateInput("invalid");
		} catch (CustomException e) {
			System.err.println("Caught custom exception: " + e.getMessage());
		}
	}

	public static void validateInput(String input) throws CustomException {
		if ("invalid".equals(input)) {
			throw new CustomException();
		}
		// Continue with the normal code
	}
}
