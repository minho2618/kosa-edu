package com.self.vo.child;

import com.self.util.MyDate;
import com.self.vo.parent.Employee;

public class Engineer extends Employee {
	private String tech;
	private double bonus;
	
	private static final double COMMON_BONUS = 30.0;
	
	public Engineer() {
		super();
	}
	

	public Engineer(int empno, String name, MyDate birthDate, double salary, String tech) {
		this(empno, name, birthDate, salary, tech, COMMON_BONUS);
	}


	public Engineer(int empno, String name, MyDate birthDate, double salary, String tech, double bonus) {
		super(empno, name, birthDate, salary);
		this.tech = tech;
		this.bonus = bonus;
	}

	public void changeTech(String tech) {
		this.tech = tech;
	}
	
	public void upgradeBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public String getTech() {
		return tech;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public String toString() {
		return super.toString() + "," + tech + "," + bonus;
	}	
}
