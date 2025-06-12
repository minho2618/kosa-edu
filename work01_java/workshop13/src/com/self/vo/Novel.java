package com.self.vo;

import java.util.Arrays;

public class Novel extends Book {
	private String[] genre;
	
	public Novel() {
		super();
	}

	public Novel(int isbn, String title, String author, String publisher, double price, String[] genre) {
		super(isbn, title, author, publisher, price);
		this.genre = genre;
	}
	
	public void setGenre(String[] genre) {
		this.genre = genre;
	}
	public String[] getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return super.toString() + "Novel: genre=" + Arrays.toString(genre);
	}
	
	
}
