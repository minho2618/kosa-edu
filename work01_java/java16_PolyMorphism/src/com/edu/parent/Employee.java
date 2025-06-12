package com.edu.parent;

import com.edu.util.MyDate;

// Parent Class...
public class Employee {
	private String name;
	private double salary;
	private MyDate birthDate;
	private int empNo;
	
	public Employee() {}
	public Employee(int empNo, String name, double salary, MyDate birthDate) {
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "empNo=" + empNo + ", name=" + name + ", salary=" + (int)salary + ", birthDate=" + birthDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getEmpno() {
		return empNo;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
}
