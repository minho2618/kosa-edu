package com.edu.condition.test;

import java.util.Scanner;

public class GradeIfTest2 {

	public static void main(String[] args) {
		// 해당 코드를 실행할 때마다 자동으로 학생성적이 랜덤하게 입력됨
		// 성적의 범위가 50 ~ 100 사이의 점수가 랜덤하게 입력되도록 코드를 작성
		int grade = (int)(Math.random() * 51) + 50;
		System.out.println(grade);
		
		if (grade >= 90) {
			System.out.println("A grade");
		} else if (grade >= 80) {
			System.out.println("B Grade");
		} else if (grade >= 70) {
			System.out.println("C Grade");
		} else {
			System.out.println("Try Again");
		}
	}

}
