package com.edu.service;

import java.util.Date;

public class Board {
	public String title;
	public String content;
	public Date date;
	public int count;
	//4. Writer 와 연관성
	public Writer writer;
	
	public void setBoard(String title, String content, Date date, int count, Writer writer) {
		this.title = title;
		this.content = content;
		this.date = date;
		this.count = count;
		this.writer = writer;
	}
	
	public String getBoard() {
		return writer.name + " " + title + " " + content;
	}
	
	public void updateCount() {
		count += 1;
	}
}
