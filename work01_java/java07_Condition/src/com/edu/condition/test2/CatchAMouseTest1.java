package com.edu.condition.test2;

import java.util.Scanner;

public class CatchAMouseTest1 {
	/// 1. Scanner 로 값 입력
	/// 2. 받은 값을 가지고 메소드 호출
	/// 3. Back 된 값을 콘솔로 출력
	public static void main(String[] args) {
		// 1. scanner 객체 생성
		Scanner sc = new Scanner(System.in);		
		System.out.println("CatA, CatB, Mouse 각각의 위치를 숫자로 입력 >>>>");
		
		// 2. 각각의 위치값을 3개의 변수에 저장
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		CatAMouse algo = new CatAMouse();
		
		String result = algo.solve(catA, catB, mouse);
		
		System.out.println(result);
		
		sc.close();
	}

}

class CatAMouse {
	public String solve(int catA, int catB, int mouse) {
		if (Math.abs(mouse - catA) == Math.abs(mouse - catB))
			return "Mouse Escape!!";		
		else if (Math.abs(mouse - catA) < Math.abs(mouse - catB))		
			return "CatA catch a mouse";
		else
			return "CatB catch a mouse";
	}
}

/// CatA catch a mouse
/// CatB catch a mouse
/// Mouse Escape!!

/// Math 클래스에서 거리를 ...함수