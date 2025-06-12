package com.edu.oop.test;

import com.edu.oop.Greeting;

/*
 필드에 값을 주입
 주입된 값을 호출...메소드 호출
 */

public class GreetingTestApp {

	public static void main(String[] args) {
		// 1. 클래스의 멤버를 메모리에 올린다. == 객체 생성
		Greeting g = new Greeting();
		
		// 2. 메모리 올라간 멤버에 접근
		//    필드 접근...필드에 값을 할당...필드초기화
		//    메소드 접근...메소드 호출
		g.greet = "반갑습니다.";
		g.target = "MSA FullStack 3기 여러분";
		
		g.printMessage();

	}

}
