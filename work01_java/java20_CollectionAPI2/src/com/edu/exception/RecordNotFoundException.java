package com.edu.exception;

// 사용자 정의 예외 클래스
public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		this("This is a RecordNotFoundException");
	}
	public RecordNotFoundException(String message) {
		super(message);
	}
}
