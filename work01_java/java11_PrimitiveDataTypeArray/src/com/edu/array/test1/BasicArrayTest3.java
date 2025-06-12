package com.edu.array.test1;

public class BasicArrayTest3 {

	public static void main(String[] args) {
		int[] scores = {86, 92, 94, 78, 80, 76};
		
		int sum = 0;
		int avg = 0;
		
		for (int score : scores) {
			sum += score;
		}
		
		avg = (int)(sum / scores.length);
		
		System.out.println("성적의 총합: " + sum);
		System.out.println("성적의 평균: " + avg);
	}
	
}
