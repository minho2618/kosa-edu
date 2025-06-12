package com.edu.constructor.test;
/*
 ShirtTest는 Shirt 객체를 생성할 때 인자값으로 실제값을 바로 입력했다.
 즉, 컴파일 시점에 실제값이 입력되었다.
 프로그램은 실행할 때마다 서로 다른 값을 받아들일 수 있는 통로를 가져야한다.
 
 실행시점에서 값을 받아들이기 위해서는 Scanner를 사용할 수 있어야 한다.
 우리는 실행할 때 키보드를 통해서 원하는 값을 읽어들이는 Scanner를 사용할 것이다.
 
 1. Scanner 객체 생성
 	Scnnaer의 멤버가 메모리에 올라간다.
 2. Scanner의 메소드를 사용(호출)
 3. 
 
 */

import java.util.Scanner;

import com.edu.constructor.Shirt;

public class ShirtTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 키보드를 통해서 읽어들이는 Scanner 생성
		System.out.println("원하는 셔츠 정보를 키보드로 입력받으세요>>>");
//		System.out.println("셔츠 메이커 입력 ==>");
//		String maker = sc.nextLine();
//		
//		System.out.println("셔츠 사이즈 입력 ==>");
//		int size = sc.nextInt();
//		
//		System.out.println("셔츠 긴팔여부 입력 ==>");
//		boolean longSleeved = sc.nextBoolean();
//		
//		Shirt longT = new Shirt(maker, size, longSleeved);
//		System.out.println(longT.getDetails());
		
		System.out.println("셔츠 메이커, 사이즈, 긴팔여부 입력 ==>");
		String maker = sc.next();
		int size = sc.nextInt();
		boolean longSleeved = sc.nextBoolean();
		
		Shirt longT = new Shirt(maker, size, longSleeved);
		System.out.println(longT.getDetails());
		
	}

}
