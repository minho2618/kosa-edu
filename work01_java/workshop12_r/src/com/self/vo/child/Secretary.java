package com.self.vo.child;

import com.self.util.MyDate;
import com.self.vo.parent.Employee;

public class Secretary extends Employee{
	private String email;
	private String phoneNumber;
	
	private static final String DEFALUT_EMAIL = "알수없음@모름";
	
	public Secretary() {
		super();
	}

	public Secretary(int empno, String name, MyDate birthDate, double salary, String phoneNumber) {
		this(empno, name, birthDate, salary, DEFALUT_EMAIL, phoneNumber);
	}
	
	public Secretary(int empno, String name, MyDate birthDate, double salary, String email, String phoneNumber) {
		super(empno, name, birthDate, salary);
		this.email = email;
		this.phoneNumber = phoneNumber;
	}



	public void changeEmail(String email) {
		this.email = email;
	}
	
	public void changePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return super.toString() + "," + email + "," + phoneNumber;
	}

	
	
	
}
