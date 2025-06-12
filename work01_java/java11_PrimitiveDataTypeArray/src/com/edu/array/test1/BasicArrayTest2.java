package com.edu.array.test1;

public class BasicArrayTest2 {

	public static void main(String[] args) {
		// arr이라는 int타입의 배열을 생성...11, 22, 33 값을 가짐
		// 선언 + 생성 + 초기화
		int[] arr = {11, 22, 33};
		
		System.out.println(arr);
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.printf("%d ", arr[i]);
//		}
		
		// 뭐가 어디에서 돌아가는가?
		for (int val : arr) {
			System.out.printf("%d ", val);
		}
	}
	
}
