package com.edu.exception.test;
/*
 * 예외를 처리하는 명시적인 방법
 * 1. try {
 *    // 예외 발생 가능성 있는 코드
 * } catch () {
 *     /// 예외 잡았을 경우 코드
 * }
 * 
 * ---------------------------
 * try {
 *     aaa
 * } catch(예외객체 e) {
 *     bbb
 * }
 * 
 * ccc
 * 
 * 
 * 1. 예외 발생 + 예외처리 안했다.
 * --> 아무것도 실행되지 않는다.
 * 
 * 2. 예외 발생 안했다
 * --> aaa + ccc
 * 
 * 3. 예외 발생 + 잘 잡았다.
 * ---> bbb + ccc;
 * 
 * 4. 예외 발생 + 못 잡았다.
 * --->  아무것도 실행되지 않는다.
 * 
 */
public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		String[] str = {
				"Hello",
				"No, I Mean it",
				"Nice to meet you",
		};
		
		// catch는 여러 번 작성할 수 있다.
		// 여러개의 catch문 중에서 단 하나만 동작한다.
		int i = 0;
		while(i <= 3) {
			try {
				System.out.println(str[i++]);
			} catch (NullPointerException e) {
				System.out.println("Nice Catch~ 1");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch~ 2");
			}
		}
		System.out.println("The end...");
	}

}
