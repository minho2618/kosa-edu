package com.vo.child;

import com.util.MyDate;
import com.vo.parent.Employee;

public class Manager extends Employee {
	private String dept;
	private int deptno;
	
	public Manager(int empno, String dept, int deptno) {
		super(empno);
		this.dept = dept;
		this.deptno = deptno;
	}
	
	public Manager(int empno, String name, double salary, MyDate birthDay, String dept, int deptno) {
		super(empno, name, salary, birthDay);
		this.dept = dept;
		this.deptno = deptno;
	}

	public String getDept() {
		return dept;
	}

	public int getDeptno() {
		return deptno;
	}
	
	public void setDept(String dept, int deptno) {
		this.dept = dept;
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return super.toString() + "manager: dept=" + dept + ", deptno=" + deptno;
	}
}
