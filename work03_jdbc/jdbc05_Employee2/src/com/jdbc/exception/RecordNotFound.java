package com.jdbc.exception;

public class RecordNotFound extends Exception {
	public RecordNotFound() {
		this("This is RecordNotFound");
	}
	
	public RecordNotFound(String message) {
		super(message);
	}
}
