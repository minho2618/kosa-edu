package com.edu.overloading.test;

import com.edu.overloading.Employee;

public class EmployeeTest1 {

	public static void main(String[] args) {
		Employee e1 = new Employee(7788); //필드 초기화
		Employee e2 = new Employee(7369, "Scott");
		Employee e3 = new Employee(7512, "Adams", 30000.0, "Brandon");
		
		System.out.println(e1.getDetails());
		System.out.println(e2.getDetails());
		System.out.println(e3.getDetails());	
	}

}
