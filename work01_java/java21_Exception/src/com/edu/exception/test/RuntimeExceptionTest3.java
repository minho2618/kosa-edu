package com.edu.exception.test;

public class RuntimeExceptionTest3 {

	public static void main(String[] args) {
		String[] str = {
				"Hello",
				"No, I Mean it",
				"Nice to meet you",
		};
		
		int i = 0;
		while(i <= 3) {
			try {
				System.out.println(str[i++]);
			} catch (NullPointerException e) {
				System.out.println("Nice Catch~ 1");
			} catch (ArithmeticException e) {
				System.out.println("Nice Catch~ 2");
			} catch (Exception e) { // 자식은 부모한테 안길수 있다.
				System.out.println("Nice Catch~ 3");
			}
		}
		System.out.println("The end...");
	}

}
