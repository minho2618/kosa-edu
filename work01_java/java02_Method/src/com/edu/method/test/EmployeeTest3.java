package com.edu.method.test;

import java.util.Date;

import com.edu.method.Employee;

public class EmployeeTest3 {

	public static void main(String[] args) {
		/*
		 Employee 3명을 각각 생성
		 James, Scott, Adams;
		 
		 필드에 값 할당은 setEmployee 함수로
		 필드에 주입된 값은 getEmployee 함수로 출력		 
		 */
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		
		e1.setEmployee("James", "Texas", new Date(2008, 10, 15));
		e2.setEmployee("Scott", "Texas", new Date(2008, 11, 15));
		e3.setEmployee("Adams", "Texas", new Date(2008, 12, 15));
		
		System.out.println(e1.getEmployee());
		System.out.println(e2.getEmployee());
		System.out.println(e3.getEmployee());
	}

}