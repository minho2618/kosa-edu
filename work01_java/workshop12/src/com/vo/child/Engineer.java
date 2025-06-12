package com.vo.child;

import com.util.MyDate;
import com.vo.parent.Employee;

public class Engineer extends Employee {
	private String tech;
	private int bonus;
	
	public Engineer(int empno, String tech, int bonus) {
		super(empno);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	public Engineer(int empno, String name, double salary, MyDate birthDay, String tech, int bonus) {
		super(empno, name, salary, birthDay);
		this.tech = tech;
		this.bonus = bonus;
	}

	public String getTech() {
		return tech;
	}

	public int getBonus() {
		return bonus;
	}
	
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + "engineer: tech=" + tech + ", bonus=" + bonus;
	}
}
