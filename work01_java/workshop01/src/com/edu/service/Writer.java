package com.edu.service;

public class Writer {
	public String name;
	public String id;
	
	public void setWriterInfo(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getWriterInfo() {
		return name + " " + id;
	}
}
