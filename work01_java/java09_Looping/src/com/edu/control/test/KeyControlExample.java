package com.edu.control.test;

import java.util.Scanner;

public class KeyControlExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int speed = 0;
		
		while (run) {
			System.out.println("-------------------------");
			System.out.println("1. 증가 | 2. 감소 | 3. 중지");
			System.out.println("-------------------------");
			System.out.print(">>> ");
			
			String strNum = sc.nextLine();
			if (strNum.equals("1")) {
				speed += 1;
				System.out.printf("현재 속도: %d\n", speed);
			} else if (strNum.equals("2")) {
				speed -= 1;
				System.out.printf("현재 속도: %d\n", speed);
			} else if (strNum.equals("3")) {
				run = false;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		
		sc.close();
	}
}
