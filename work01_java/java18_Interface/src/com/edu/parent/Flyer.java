package com.edu.parent;
/*
 * 인터페이스 구성요소
 * 1) public abstract method
 * 2) public static final 상수값
 * 
 * 날으는 것과 관련된 기능의 Template
 * 추상메소드들의 집합...
 * 
 * 핃드가 없다.
 * 
 * public static final 상수값은 존재할 수 있음
 */
public interface Flyer {
	int MAX_SPEED = 250; // public static final 이 자동으로 붙게된다.
	
	void flyer(); // public abstract 가 자동으로 붙게된다.
	public abstract void takeOff();
	void land();
}
