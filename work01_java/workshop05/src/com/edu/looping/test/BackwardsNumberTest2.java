package com.edu.looping.test;

import java.util.Scanner;

public class BackwardsNumberTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while (true) {
			System.out.printf("1 이상의 숫자를 입력하세요 : ");
			num = sc.nextInt();
			if (num >= 1)
				break;
//			else
//				System.out.println("1 이상의 숫자를 입력해주세요");
		}
		
		for (int i = num; i > 0; i--) {
			System.out.printf("%d ", i);
		}
		
		sc.close();

	}

}
