package com.edu.constructor.test;

import com.edu.constructor.NoteBook;
import com.edu.constructor.Programmer;
/*
 NoteBook ---> Programmer
 Hasing 공식
 
 class Programmer {
 	//1.
 	NoteBook noteBook;
 	
 	//2. 주입의 통로 2가지(생성자, setter)
 	public void setNoteBook(NoteBook noteBook) {
 		this.noteBook = noteBook;
 	}	
 }
 */

public class ProgrammerTest2 {

	public static void main(String[] args) {		
		Programmer james = new Programmer("James", "Java", 300, 50);
		Programmer anna = new Programmer("김안나", "Javascript", 200, 20);
		
		james.buyNoteBook(new NoteBook(123L, "Apple", 200.0f));
		anna.buyNoteBook(new NoteBook(456L, "LG", 150.0f));
		
		james = anna;
		
//		System.out.println(james.getAnnualSalary());
//		
//		anna.increaseSalary(50f);
//		System.out.println(anna.getAnnualSalary());
		
		System.out.println(james.getProgrammerInfo());
		System.out.println(anna.getProgrammerInfo());		
		
		System.out.println();
		System.out.println(james);
		System.out.println(anna);
	}

}
