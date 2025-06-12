package com.edu.exception.test2;

class ZeroBoom extends Exception {
	ZeroBoom() {  }
	ZeroBoom(String message) { super(message); }
}

public class UserExceptionTest2 {

	public static void main(String[] args) {
		Users u = new Users();
		try {
			System.out.println("go()를 호출합니다.");
			u.go();
		} catch (ZeroBoom e) {
			System.out.println(e.getMessage());
		}
		System.out.println("이 부분을 수행하고 프로그램을 마칩니다.");
	}

}

class Users {
	public void go() throws ZeroBoom {
		int i = 10; int j = 0;
		
		if (j == 0) {
			throw new ZeroBoom("분모가 0이면 폭탄이 터집니다.");
		}
	}
}