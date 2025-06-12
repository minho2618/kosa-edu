package com.edu.oop;

public class NoteBook {
	//필드 선언
	public int serialNumber;
	public String brand;
	public int price;
	
	// 필드에 값을 주입하는 통로
	public void setNoteBook(int serialNumber, String brand, int price) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.price = price;
	}
	
	// 필드에 주입된 값을 받아오는 통로
	public String getNoteBook() {
		return serialNumber + ", " + brand + ", " + price;
	}
}
