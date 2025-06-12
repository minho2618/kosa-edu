package com.edu.constructor.test;

import java.util.Scanner;
import com.edu.constructor.Shirt;

public class ShirtTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 셔츠 정보를 키보드로 입력받으세요>>>");
		System.out.println("셔츠 메이커, 사이즈, 긴팔여부 입력 ==>");
		String maker = sc.next();
		
		String s = sc.next();
		// parseInt()는 static한 성질의 기능이기 때문에
		// 객체생성할 필요없다. 이유는 미리 메모리에 올라가있는 기능이다.
		// 클래스이름.기능(); 바로 사용할 수 있다.
		int size = Integer.parseInt(s);
		
		String ls = sc.next();
		boolean longSleeved = Boolean.parseBoolean(ls);
		
		/*
		 size ::: String --> int
		 longSleeved ::: String --> boolean
		 으로 데이터형을 바꿔줘야 한다.
		 
		  형 변환 시키는 기능을 연결 --> Wrapper Class를 제공한다. Integer Boolean
		 */
		
		Shirt longT = new Shirt(maker, size, longSleeved);
		System.out.println(longT.getDetails());
		
	}

}
