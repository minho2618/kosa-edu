package com.edu.constructor.test;

import com.edu.constructor.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		//1. 객체 생성
		Shirt longT = new Shirt("ABC", 105, true);
		Shirt shortT = new Shirt("DEF", 110, false);
		Shirt T = new Shirt("GHI", 100, false);
		
		System.out.println(longT.getDetails());
		System.out.println(shortT.getDetails());
		System.out.println(T.getDetails());
	}

}
