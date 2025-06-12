package com.vo.child;

import com.util.MyDate;
import com.vo.parent.Employee;

public class Architect extends Employee {
	private String project;
	private int supervision;
	
	public Architect(int empno, String project, int supervision) {
		super(empno);
		this.project = project;
		this.supervision = supervision;
	}
	
	public Architect(int empno, String name, double salary, MyDate birthDay, String project, int supervision) {
		super(empno, name, salary, birthDay);
		this.project = project;
		this.supervision = supervision;
	}

	public String getProject() {
		return project;
	}

	public int getSupervision() {
		return supervision;
	}
	
	public void setProject(String project) {
		this.project = project;
	}
	
	public void setSupervision(int supervision) {
		this.supervision = supervision;
	}
	
	@Override
	public String toString() {
		return super.toString() + "architect: project=" + project + ", supervision=" + supervision;
	}
}
