package com.jdbc.exception;

public class DuplicateISBNException extends Exception {
	public DuplicateISBNException() {
		this("This is DuplicateNumException");
	}
	
	public DuplicateISBNException(String message) {
		System.out.println(message);
	}
	
	@Override
	public String getMessage() {
		return "This is DuplicateNumException";
	}
}
