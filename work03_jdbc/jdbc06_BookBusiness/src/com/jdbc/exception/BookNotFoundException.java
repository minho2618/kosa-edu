package com.jdbc.exception;

public class BookNotFoundException extends Exception {
	public BookNotFoundException() {
		this("This is RecordNotFound");
	}
	
	public BookNotFoundException(String message) {
		super(message);
	}
}
