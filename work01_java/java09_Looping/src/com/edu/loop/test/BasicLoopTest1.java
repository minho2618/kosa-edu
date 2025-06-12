package com.edu.loop.test;
/*
 for (초기식;조건문;증감식) {// 코드 블럭}
 
 초기식
 while (조건문) {
 	// 코드 블럭
 	증감식
 }
 */
public class BasicLoopTest1 {

	public static void main(String[] args) {

		System.out.println("========= for =========\n");
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello for Looping..." + i);
		}
		
		System.out.println("========= while =========\n");
		int i = 10;
		while (i > 0) {
			System.out.println("Hello while Looping..." + i--);
		}
		
		System.out.println("========= do while =========\n");
		int j = 10;
		do  {
			System.out.println("Hello do while Looping..." + j--);
		} while (j > 0);
	}

}
