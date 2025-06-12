package com.edu.constructor;

public class NoteBook {
	long serialNumber;
	String maker;
	float price;
	
	public NoteBook() {}
	
	public NoteBook(long serialNumber, String maker, float price) {
		//필드 초기화
		this.serialNumber = serialNumber;
		this.maker = maker;
		this.price = price;
	}
	
	public void discountPrice(int discountValue) {
		this.price -= discountValue;
	}
	
	public String getDetails() {
		return serialNumber + "\t" + maker + "\t" + price;
	}
	
	
}
