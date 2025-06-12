package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		NoteBook nb = new NoteBook();
		
		nb.serialNumber = 1234;
		nb.brand = "LG";
		nb.price = 3000.0;
		
		nb.printNoteBookInfo();
	}

}
