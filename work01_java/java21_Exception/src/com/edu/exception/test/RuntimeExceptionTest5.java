package com.edu.exception.test;
/*
 *  try {
 *     // 예외 발생 안하면 이쪽이 실행
 *  } catch() {
 *     // 예외 발생 시 이쪽으로 코드가 넘어온다.
 *  } finally {
 *     // 예외와 상관없이 무조건 수행되어져야하는 코드
 *     // 자원을 쓰고나서 마지막으로 닫아주는 코드
 *  }
 */
public class RuntimeExceptionTest5 {

	public static void main(String[] args) {
		RuntimeException2 re = new RuntimeException2();
		re.go();
		
		System.out.println("The end...");
	}

}

class RuntimeException2 {
	public void go() {
			System.out.println("Statement...1");
			System.out.println("Statement...2");
			
			int i = 0; int j = 0;
			try {
				System.out.println("Statement...3" + i / j);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Statement...4");
	}
}
