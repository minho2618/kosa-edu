package com.jdbc.exception;

public class InvalidInputException extends Exception {
	public InvalidInputException() {
		this("This is DMLException");
	}
	
	public InvalidInputException(String message) {
		System.out.println(message);
	}
	
	@Override
	public String getMessage() {
		return "This is DMLException";
	}
}
