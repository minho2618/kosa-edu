package com.edu.vo;

public class Resident {
	private String name;
	private int snn;
	private int age;
	private boolean isMarriage;
	private int carQuantity;
	
	public Resident() {}
	
	public Resident(String name, int snn, int age, boolean isMarage, int carQuantity) {
		this.name = name;
		this.snn = snn;
		this.age = age;
		this.isMarriage = isMarage;
		this.carQuantity = carQuantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSnn() {
		return snn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMarriage() {
		return isMarriage;
	}

	public void setMarage(boolean isMarriage) {
		this.isMarriage = isMarriage;
	}

	public int getCarQuantity() {
		return carQuantity;
	}

	public void setCarQuantity(int carQuantity) {
		this.carQuantity = carQuantity;
	}
	
	public String getResidentInfo() {
		//System.out.println(name + " " + snn + " " + age + " " + isMarriage + " " + carQuantity);
		return name + " " + snn + " " + age + " " + (isMarriage ? "기혼" : "미혼") + " " + carQuantity;
	}
}
