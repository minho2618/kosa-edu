/*
 * static 키워드 성질
 * 1. static이 붙은 멤버(필드, 메소드)는 객체생성 과정을 건너뛴다.
 * 2. static이 붙은 멤버는 객체생성 안 해도 미리 메모리에 올라가있다.
 * 3. 자바는 2단계
 *    컴파일 ->  ~.java -> ~.class
 *    실행 
 *        ~.class 파일 JVM Loader(이때 static 멤버가 메모리에 올라간다)
 *        --> byteCode Verifier
 *        --> Interpreter
 *        --> 실행
 *        
 * 4. static한 필드, 메소드를 사용할 때는 
 *    클래스 이름.필드
 *    클래스 이름.메소드();
 *    ex)
 *    Integer.parseInt()
 *    Math.random()
 *    System.arraycopy()
 *    Arrays.copyOf()
 *    System.out...
 *    
 * 5. static 변수는 로컬레벨에서는 사용못함
 *    필드레벨만 사용가능
 * 6. static 키워드는 final 키워드와 같이 사용되는 경우가 많음
 * 7. static한 변수는 생성된 객체들에서 공유한다.(중요함)
 */

package com.edu.test;

class Member {
	static int ssn = 1234;
	static String name = "길동";
	int age = 19;
	
	public static void printMember() {
		System.out.println("우/유/빛/깔/" + name);
	}
	
	public void printMember2() {
		// static은 로컬 레벨에선 사용불가
		//static int count = 0;
		System.out.println("우/유/빛/깔/" + name);
	}
	
	// static은 static끼리 통함
	// -> static은 메모리 먼저 올라가니까
	public static void printMember3() {
		//System.out.println("우/유/빛/깔/" + name + ", 님은 " + age + "살");
	}
}


public class StaticExamTest1 {

	public static void main(String[] args) {
		Member.printMember();
		Member m = new Member();
		m.printMember2();
	}

}
