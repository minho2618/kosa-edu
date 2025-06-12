package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Secretary extends Employee {
	private String nameOfBoss;		
	
	// this...이 클래스 자기자신을 가리키는 키워드
	// super...부모를 가리키는 키워드
	public Secretary(int empno, String name, double salary, MyDate birthDate, String nameOfBoss) {
		super(empno, name, salary, birthDate);
		this.nameOfBoss = nameOfBoss;
	}
	
	// 부모가 가진 기능을 물려받고 + 그걸 자식에게 맞게 고쳐쓴다.
	// Method Overriding
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", nameOfBoss=" + nameOfBoss;
	}
	
	public String getNameOfBoss() {
		return nameOfBoss;
	}
	public void changeNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}
}
