package com.edu.exception.test;
/*
 * RuntimeException
 * 명시적으로 예외를 처리할 필요가 없다
 * 코드를 수정하면 된다.
 */
public class RuntimeExceptionTest1 {

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
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch");
			}
		}
		System.out.println("The end...");
	}

}
