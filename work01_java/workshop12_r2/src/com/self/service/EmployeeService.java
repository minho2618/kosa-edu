package com.self.service;

import com.self.vo.child.Secretary;
import com.self.vo.parent.Employee;

// 팀원들 사이의 강력한 Contract
public interface EmployeeService {
	void addEmployee(Employee emp);
	void deleteEmployee(int empno);
	void updateEmployee(Employee emp);
	Employee getEmployee(int empno);
	Employee[] getEmployee();
	Secretary[] findCommonEmail(String email);
	String[] countDept();
	Employee findBabyOfEmployee();
}
