/*
 * 6. static 키워드는 final 키워드와 같이 사용되는 경우가 많음
 */

/*
 * Access Modifier ::: public < protected < private (나중에 진행)
 * Usage Modifier ::: static, final, abstract
 * 
 * static final
 * final static 순서 안 중요함 -> 전부 usage modifier 기 때문
 * 
 * -----------------------------------------------------
 * final :: "내가 마지막이야"라는 의미를 가지는 키워드
 * 
 * static final + 변수 --> "내가 마지막 변수야" --> 상수값 지정
 * final + 클래스 --> "내가 마지막 클래스야" --> 상속 금지
 * final + 메소드 --> "내가 마지막 메소드야" --> 오버라이딩 금지 (중요함)
 */

package com.edu.test;

class A {
	public final static int BASE_SALARY = 40000; // 값 변경 못함
	public final String text() {
		return "오버라이딩 금지";
	}
}

final class B { // 상속 금지...자식 클래스 못만듬
	
}

//class C extends B {
//	
//}

class D extends A {
//	@Override
//	public final String text() {
//		return "오버라이딩 금지 " + 1234;
//	}
}

public class StaticExamTest2 {

	public static void main(String[] args) {
		// A.BASE_SALARY = 20000;
	}

}
