package com.edu.looping.test;

import java.util.Scanner;

public class BackwardsNumberTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		for (int i = num; i > 0; i--) {
			System.out.printf("%d ", i);
		}
		
		sc.close();

	}

}
