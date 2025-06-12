package com.edu.oop;

/*
	 Greeting 클래스는 두가지 구성요소로 이뤄져 있다.
	 필드
	 메소드
 */

public class Greeting {
	// 어떤 대상에서 어떤 인삿말을 할지를 필드로 선언
	// 필드 선언 : 변수타입 + 변수이름
	public String greet;
	public String target;
	
	// 기능...콘솔창에 값을 출력하는 기능을 정의
	public void printMessage() {
		System.out.println(target + ", " + greet);
	}
	
}
