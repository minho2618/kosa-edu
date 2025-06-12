package com.edu.array.test1;

public class BasicArrayTest1 {

	public static void main(String[] args) {
		// 1. int 배열 arr 선언
		int[] arr;
		
		// 2. arr을 생성...사이즈는 3
		arr = new int[3];
		
		// 3. 배열의 주소값르 출력
		System.out.println("arr 주소값: " + arr);
		System.out.println();
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("arr의 %d번째 수: %d\n", i + 1, arr[i]);
		}
		System.out.println();
		
		// 4. 각각 배열의 요소에 11, 22, 33을 입력
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		
		// for 문울 이용해서 arr 배열에 들어있는 값들을 출력
		for (int i = 0; i < 3; i++) {
			System.out.printf("arr의 %d번째 수: %d\n", i + 1, arr[i]);
		}
	}
	
}
