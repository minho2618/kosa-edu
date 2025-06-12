package com.edu.oop;

public class NoteBook {
	public int serialNumber;
	public String brand;
	public double price;

	public void printNoteBookInfo() {
		System.out.println(brand + " " + serialNumber + " : " + price);
	}
}
