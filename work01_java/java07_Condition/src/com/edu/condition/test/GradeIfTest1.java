package com.edu.condition.test;

import java.util.Scanner;

/*
 116쪽 예제코드
 */

public class GradeIfTest1 {

	public static void main(String[] args) {
		/// 1. 학생 성적을 Local V로 초기화
		/// int grade로
		/// 값은 그때마다 다른 성적을 입력받아야 하기에 Scanner 사용

		/// 2. 만약에 성적이 90점 이상이면...A grade
		///	80~90 사이면 B Grade
		/// 70~80 사이면 C Grade
		///	나머지 Try Again
		Scanner sc = new Scanner(System.in);
		
		int grade = sc.nextInt();
		
		if (grade >= 90) {
			System.out.println("A grade");
		} else if (grade >= 80) {
			System.out.println("B Grade");
		} else if (grade >= 70) {
			System.out.println("C Grade");
		} else {
			System.out.println("Try Again");
		}
		
		sc.close();
	}

}
