package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Engineer extends Employee {
	private String tech;
	private int bonus;
	
	// this...이 클래스 자기자신을 가리키는 키워드
	// super...부모를 가리키는 키워드
	public Engineer(int empno, String name, double salary, MyDate birthDate, String dept, String tech, int bonus) {
		super(empno, name, salary, birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}

	/*
	 * 1. 부모가 가지는 기능을 물려받는다.
	 * 2. 자식 자기에 맞는 기능으로 고쳐쓴다.
	 * 
	 * 메소드 오버라이딩(상속관계에 있는 부모, 자식 클래스에서만 발생
	 * - 메소드 선언부는 동일
	 * - 메소드 구현부는 반드시 달라야 한다.
	 */
	@Override
	public String toString() {
		return super.toString() + ", tech=" + tech + ", bouns=" + bonus;
	}
	
	public void changeTech(String tech) {
		this.tech = tech;
	}
	public String getTech() {
		return tech;
	}
	
	public void changeBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getBonus() {
		return bonus;
	}
}
