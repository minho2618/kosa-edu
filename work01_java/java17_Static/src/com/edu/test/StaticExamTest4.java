package com.edu.test;
// Static Initialization Block

/*
 * jvm...실행...제일 먼저 찾는 함수가 main()
 * main() 안 첫번째 코드보다 더 먼저 실행되는 부분이 있다.
 * 
 * 클래스의 생성자() {
 *     // 필드 초기화
 * }
 */

public class StaticExamTest4 {
	static int i = 100;
	// main block
	public static void main(String[] args) {
		System.out.println("1. main method block..." + i);
	}

	// static initialization block
	// 객체 생성 이전에 해야할 작업이 만약에 있다면 여기서
	static {
		i = 300;
		System.out.println("2. static block..." + i);
	}
}
