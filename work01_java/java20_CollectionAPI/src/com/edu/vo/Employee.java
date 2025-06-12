package com.edu.vo;

// Parent Class...
public class Employee implements Comparable<Employee> {
	private String name;
	private double salary;
	private int empNo;
	
	public Employee() {}
	public Employee(int empNo, String name, double salary) {
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
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
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", empNo=" + empNo + "]";
	}
	public double getSalary() {
		return salary;
	}
	
	@Override
	public int compareTo(Employee e) {
		return -Double.compare(this.getSalary(), e.getSalary());
	}
}
