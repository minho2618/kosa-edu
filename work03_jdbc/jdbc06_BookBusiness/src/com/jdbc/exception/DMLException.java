package com.jdbc.exception;

public class DMLException extends Exception {
	public DMLException() {
		this("This is DMLException");
	}
	
	public DMLException(String message) {
		System.out.println(message);
	}
	
	@Override
	public String getMessage() {
		return "This is DMLException";
	}
}
