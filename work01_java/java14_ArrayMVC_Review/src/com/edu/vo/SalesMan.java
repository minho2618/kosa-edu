package com.edu.vo;

import com.edu.util.MyDate;

public class SalesMan {
	private int empno;
	private String name;
	private int bonus;
	private MyDate birthDate;
	
	public SalesMan() {}
	public SalesMan(int empno, String name, int bonus, MyDate birthDate) {
		super();
		this.empno = empno;
		this.name = name;
		this.bonus = bonus;
		this.birthDate = birthDate;
	}
	
	public int getEmpno() {
		return empno;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBonus() {
		return bonus;
	}
	public void changeBous(int bonus) {
		this.bonus = bonus;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	@Override
	public String toString() {
		return "SalesMan [empno=" + empno + ", name=" + name + ", bouns=" + bonus + ", birthDate=" + birthDate
				+ "]";
	}
	
}
