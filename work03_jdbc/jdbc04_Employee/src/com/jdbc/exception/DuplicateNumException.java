package com.jdbc.exception;

public class DuplicateNumException extends Exception {
	public DuplicateNumException() {
		this("This is DuplicateNumException");
	}
	
	public DuplicateNumException(String message) {
		System.out.println(message);
	}
	
	@Override
	public String getMessage() {
		return "This is DuplicateNumException";
	}
}
