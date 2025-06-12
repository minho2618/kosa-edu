package com.edu.array.test1;

import java.util.Scanner;

public class BasicArrayTest4 {

	public static void main(String[] args) {
		// 1. Scanner를 통해 배열의 크기 입력받음
		// 2. String 배열 names 생성
		// 3. 이름을 Scanner를 이용해서 입력
		// 4. 모든 이름을 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력 >>> ");
		int size = sc.nextInt();
		
		String[] names = new String[size];
				
		for (int i = 0; i < names.length; i++) {
			System.out.print("이름을 입력 >>> ");
			String name = sc.next();
			names[i] = name;
		}
		
		for (String name : names) {
			System.out.print(name + " ");
		}
		
		sc.close();
	}
	
}
