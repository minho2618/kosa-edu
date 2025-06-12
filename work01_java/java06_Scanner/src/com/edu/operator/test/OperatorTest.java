package com.edu.operator.test;
// 자바에서 사용되는 기본적인 연산자
public class OperatorTest {
	int size; // Field
	
	public static void main(String[] args) {
		//Local Variable
		int i = 6;
		int j = 3;
		i++;
		
//		System.out.println("연산자 = : 할당(assign)");
//		System.out.println("연산자 % : 나머지(modular) " + i % j);
//		System.out.println("연산자 / : " + i / j);
		
		int num = 98;
		
//		System.out.println("십의 자리 => " + num / 10);
//		System.out.println("일의 자리 => " + num % 10);
		
//		int k = 10;
//		System.out.println(k++);
//		System.out.println(k);
//		
//		int m = 10;
//		System.out.println(--m);
//		System.out.println(m);
		
		/// same object? another object?
		Operator1 o1 = new Operator1();
		Operator1 o2 = new Operator1();
		
		/*
		 주소값이 같으면 Heap에 올라가있는 같은 객체를 가리킨다.
		 주소값이 다르면 Heap에 올라가있는 서로다른 객체를 가리킨다.
		 */
//		System.out.println(o1);
//        System.out.println(o2);
        
//        System.out.println("Same object ==>" + (o1 == o2));
//        System.out.println("Another object ==>" + (o1 != o2));
        
        //// Short Circuit -->    ////
        /// 뒷부분의 논리연산자를 진행시키지 않고 건너뛸 수 있다.
        /// 뒷 부분 수행시 발생할 수 있는 예외상황을 건너뛸 수 있다.
//        System.out.println(o1.test1() | o2.test2());
//        System.out.println(o1.test1() & o2.test2());
//        
//        System.out.println(o1.test1() || o2.test2());
//        System.out.println(o1.test2() && o2.test1());
        
        
		/// ==, equals() ///
		System.out.println(o1.equals(o2)); // false...주소값 비교하는 함수
		System.out.println(o1 == o2); // false...값 비교하는 연산자
		
		System.out.println("msg == " + (o1.msg == o2.msg));
		// equals()는 스트링 데이터값을 비교할 때는 반드시 equals를 사용, == 연산자 사용하면 안됨
		System.out.println("msg equals " + (o1.msg.equals(o2.msg))); 
        
	}//main

}//class

class Operator1 {
	String msg = "Hello";
	public boolean test1() {
		System.out.println("test1() calling...");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() calling...");
		return false;
	}
}

class Operator2 {
	public boolean test1() {
		System.out.println("test1() calling...");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() calling...");
		return false;
	}
}

