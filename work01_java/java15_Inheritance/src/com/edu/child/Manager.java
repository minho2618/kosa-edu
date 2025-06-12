package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee {
	private String dept;		
	
	// this...이 클래스 자기자신을 가리키는 키워드
	// super...부모를 가리키는 키워드
	/*
	 * 자식 생성자
	 * 무조건 부모 생성자가 호출...super();
	 * 부모 명시적 생성자 호출...super(empno, name, salary, birthDate);
	 */
	public Manager(int empno, String name, double salary, MyDate birthDate, String dept) {
		super(empno, name, salary, birthDate);
		this.dept = dept;
	}
	
	// 부모가 가진 기능을 물려받고 + 그걸 자식에게 맞게 고쳐쓴다.
	// Method Overriding
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", dept=" + dept;
	}
	
	public String getDept() {
		return dept;
	}
	public String changeDept() {
		return dept;
	}
}
