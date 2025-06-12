package com.vo.parent;

import com.util.MyDate;

public class Employee {
	private int empno;
	private String name;
	private double salary;
	private MyDate birthDate;
	
	public static final String DEFAULT_NAME = "홍길동";
	public static final double DEFAULT_SALARY = 1000.0;
	public static final MyDate DEFALUT_DATE = new MyDate(1900, 1, 1);
	
	public Employee(int empno) {
		this(empno, DEFAULT_NAME, DEFAULT_SALARY, DEFALUT_DATE);
	}
	
	public Employee(int empno, String name, double salary, MyDate birthDate) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public int getEmpno() {
		return empno;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	public void changeSalary(double salary) {
		this.salary = salary;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return "Employee: empno=" + empno + ", name=" + name + ", salary=" + salary + ", birthDate=" + birthDate + " ";
	}
	
	
}
