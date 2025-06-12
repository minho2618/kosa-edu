package com.edu.loop.test;

public class LoopingBreakTest2 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			if (sum >= 500)
				break;
		}
		System.out.println(sum);
	}
}
