package com.edu.array.test2;

public class ArrayTest3 {

	public static void main(String[] args) {
		int[] scores = {79, 88, 91, 45, 100, 56};
		
		// 배열의 첫번째 값으로 최대값, 최소값을 초기화한다.
		int max = scores[0];
		int min = scores[0];
		
		for (int i : scores) {
			if (i > max)
				max = i;
			
			if (i < min)
				min = i;
		}
		
		System.out.printf("Max: %d, Min: %d", max, min);
	}
	
}
