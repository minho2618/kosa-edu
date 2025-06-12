package com.edu.exception;

// 사용자 정의 예외 클래스
public class DuplicateEmpException extends Exception {
	public DuplicateEmpException() {
		this("This is a DuplicateEmpException");
	}
	public DuplicateEmpException(String message) {
		super(message);
	}
}
