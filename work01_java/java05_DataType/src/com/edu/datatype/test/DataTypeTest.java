package com.edu.datatype.test;

public class DataTypeTest {
	int c;
	public static void main(String[] args) {
		byte a = 100;
		//127까지의 값의 범위를 가진다.
//		byte b = 128;
		int b = 128;
				
		System.out.println("a==>" + a);
		System.out.println("b==>" + b);
		
		float salary1 = 300.34f;
		
		double salary2 = 300.34;
		
		long salary3 = 200l;
		
		short x, y, c;
		x = 1; y = 2;
		c = (short)(x + y); 
		// 실제값이 아니기 때문에 타입 비교가 된다. 
		// 이때 사칙연산이 적용되면 int로 형이 승격된다.			
		//c = 1 + 2;
		
		System.out.println(c);
	}

}
