package com.self.vo;

public class Magazine extends Book {
	private String topic;
	
	public Magazine() {
		super();
	}

	public Magazine(int isbn, String title, String author, String publisher, double price, String topic) {
		super(isbn, title, author, publisher, price);
		this.topic = topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTopic() {
		return topic;
	}

	@Override
	public String toString() {
		return super.toString() + "Magazine: topic=" + topic;
	}
	
	
}
