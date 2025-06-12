package com.edu.oop;

// NoteBook을 사용하는 Programmer
public class Programmer {
	// 필드 선언
	public String name;
	public String mainSkill;
    public int salary;	
    
    // Has a Relation
    public NoteBook noteBook;
    
    //주입의 통로 1
    public void setProgrammer(String name, String mainSkill, int salary) {
    	this.name = name;
    	this.mainSkill = mainSkill;
    	this.salary = salary;
    }
    
    //주입의 통로 2
    public void useNoteBook(NoteBook noteBook) {
    	this.noteBook = noteBook;
    }
    
    public String getProgrammer() {
    	return name + ", " + mainSkill + ", " + salary;
    }
    
    public NoteBook getNoteBook() {
    	return noteBook;
    }
}
