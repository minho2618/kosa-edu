package com.edu.loop.test;

public class LoopingBreakTest3 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				continue;
			sum += i;
		}
		System.out.printf("%d\n", sum);
	}
}
