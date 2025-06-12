package com.edu.oop.test;

import com.edu.oop.NoteBook;
import com.edu.oop.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		// 1. NoteBook, Programmer 객체를 생성 
		NoteBook noteBook = new NoteBook();
		Programmer programmer = new Programmer();
		
		// 2. 각 객체에 값을 주입
		noteBook.setNoteBook(1234, "ASUS", 1500);
		programmer.setProgrammer("John", "Java", 3000);
		programmer.useNoteBook(noteBook);
		
		// 3. Programmer 객체의 getter를 호출해 값을 전달받고 출력
		System.out.println(programmer.getProgrammer() + "\n" + programmer.getNoteBook().getNoteBook());
	}

}
