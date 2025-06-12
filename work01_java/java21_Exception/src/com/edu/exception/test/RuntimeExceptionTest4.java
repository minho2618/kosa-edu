package com.edu.exception.test;

public class RuntimeExceptionTest4 {

	public static void main(String[] args) {
		RuntimeException re = new RuntimeException();
		re.go();
		
		System.out.println("The end...");
	}

}

class RuntimeException {
	// 예외는 메소드 블락 안에서 줄단위로 발생한다.
	// 예외는 jvm이 예외 객체를 생성해서 다시 프로그램 코드 라인으로 던져서 발생
	// 예외가 발생하면 그 지점에서 터져버리고 비정상적으로 프로그램을 종료
	// 예외를 처리한다는 것은 해당지점에서 폭탁을 처리한 후 정상적으로 프로그램을 종료하려는 기술
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
