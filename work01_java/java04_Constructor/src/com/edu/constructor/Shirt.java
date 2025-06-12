package com.edu.constructor;

//다양한 소매길이를 나타낼 수 있는 셔츠타입의 클래스
public class Shirt {
	//필드는 선언만 하더라도 무조건 기본값을 가지고 있다.
	public String brand; //null
	public int size; //0
	public boolean longSleeved; //false
	
	public Shirt() {} // 기본 생성자
	
	public Shirt(String brand, int size, boolean longSleeved) { // 명시적  생성자
		this.brand = brand;
		this.size = size;
		this.longSleeved = longSleeved;
	}
	
	// 메소드 정의 = 메소드 선언부 + 메소드 구현부
	public void setShirt(String brand, int size, boolean longSleeved) {
		// 필드 초기화
		this.brand = brand;
		this.size = size;
		this.longSleeved = longSleeved;
	}	
	
	public String getDetails() {
		return brand + "\t " + size + "\t" + longSleeved;
	}
}
