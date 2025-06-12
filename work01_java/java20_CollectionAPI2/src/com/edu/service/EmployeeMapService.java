package com.edu.service;

import java.util.ArrayList;

import com.edu.exception.DuplicateEmpException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Employee;

//기능의 Template을 모아놓은 인터페이스....
public interface EmployeeMapService {
	void addEmployee(Employee e) throws DuplicateEmpException;//public abstract가 생략....	
	void deleteEmployee(int empId) throws RecordNotFoundException;
	void updateEmployee(Employee e) throws RecordNotFoundException; 
	
	//Method Overloading
	ArrayList<Employee> findEmployees(String addr);
	ArrayList<Employee> findEmployees();
	
}
