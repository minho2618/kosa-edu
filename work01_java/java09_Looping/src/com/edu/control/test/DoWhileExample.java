package com.edu.control.test;

import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("메시지를 입력하시오.");
		System.out.println("종료하려면 q를 입력하시오.");
		
		String str;
		do { 
			System.out.print(">>> ");
			str = sc.nextLine();
			System.out.println(str);
		} while (!str.equals("q"));
		
		System.out.println("");
		System.out.println("프로그램 종료");
		
		sc.close();
	}

}
