package com.edu.constructor;

//NoteBook을 사용하는 개발자
public class Programmer {
	String name;
	String mainSkill;
	double salary;
	int bouns;
	
	NoteBook noteBook;
	
	public Programmer() {}
	
	public Programmer(String name, String mainSkill, double salary,	int bouns) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
		this.bouns = bouns;
	}
	
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}
	
	public String getProgrammerInfo() {
		return name + "\t" + salary + "\t" + mainSkill;
	}
	
	//기능 추가
	//1. 개발자의 연봉을 반환하는 기능을 정의...
	public float getAnnualSalary() {
		return (float)(salary * 12f + bouns);
	}
	
	//2. 개발자의 급여를 기존보다 (50)만원 더 인상하는 기능을 정의
	public void increaseSalary(float increaseValue) {
		salary += increaseValue;
	}
}
