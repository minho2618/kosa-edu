package com.self.vo.child;

import com.self.util.MyDate;
import com.self.vo.parent.Employee;

public class Manager extends Employee{
	private String dept;
	private int deptno;
	
	private static final String DEFALUT_DEPT = "부서없음";
	private static final int DEFALUT_DEPTNO = 1;
	
	public Manager() {
		super();
	}
	
	public Manager(int empno, String name, MyDate birthDate, double salary) {
		this(empno, name, birthDate, salary, DEFALUT_DEPT, DEFALUT_DEPTNO);
	}
	
	public Manager(int empno, String name, MyDate birthDate, double salary, String dept, int deptno) {
		super(empno, name, birthDate, salary);
		this.dept = dept;
		this.deptno = deptno;
	}	
	
	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	public void changeDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public String getDept() {
		return dept;
	}
	
	public int getDeptno() {
		return deptno;
	}
	
	public String toString() {
		return super.toString() + "," + dept + "," + deptno;
	}
}






