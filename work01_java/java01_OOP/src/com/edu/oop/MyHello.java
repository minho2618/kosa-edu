package com.edu.oop;
/*
 MyHello라는 클래스는 실행메소드...main 메소드를 가지고 있는 Test 클래스이다.
 Test 클래스는 자바의 OOP와 전혀 상관없는 클래스이다.
 결록적으로 MyHello는 OOP기법으로 작성된 클래스가 아니다.
 
 :::
 
 OOP 프로그램으로 다시 작성
 인사말을 콘솔창에 출력하는 기능을 가지는 클래스를 하나 설계
 
 Greeting 
 서로 다른 값이 저장되는 공간 --- field (변수)
 - 어떤 인사말
 - 어떤 대상에게 하는 인사말인지
 
 field에 저장된 값을 콘솔창에 출력하는 기능 --- method (function, 함수)
 */

public class MyHello {

	public static void main(String[] args) {
		//콘솔에 문자를 출력하는 기능을 호출
		System.out.println("Hello......JAVA~~!!");
	}//main 

} //class

