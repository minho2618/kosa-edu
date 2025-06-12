package com.edu.array.test2;

import java.util.Scanner;

public class ArrayUsingScannerTest4 {

	public static void main(String[] args) {
		boolean run = true;		
		
		Scanner sc = new Scanner(System.in);
		
		
		while (run) {
			System.out.println("------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
			System.out.println("------------------------------------------------------");
			System.out.print("메뉴선택 > ");
			
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				studentCount();
				break;
			case 2:
				studentInputScores();				
				break;
			case 3:
				if (scores == null) {
					System.out.println("학생 점수가 입력되지 않았습니다.");
					break;
				}
				
				System.out.println("학생 성적 리스트입니다.");
				for (int score : scores) {
					System.out.print(score + " ");
				}
				System.out.println();
				break;
			case 4:
				if (scores == null) {
					System.out.println("학생 점수가 입력되지 않았습니다.");
					break;
				}
				
				// 최고점수
				// 평균점수
				int max = scores[0];
				int sum = 0;
				
				for (int score : scores) {
					max = (max < score) ? score : max;
//					if (max < score)
//						max = score;
					sum += score;
				}
				
				System.out.println("학생 최고 점수 >>> " + max);
				System.out.println("학생 평균 점수 >>> " + sum / scores.length);
				break;
			case 5:				
				run = false;
				break;
			default:
				System.out.println("다시 입력하시오.");
				
			}
		}
		System.out.println("프로그램을 종료합니다...");
	}
	
	private static void studentCount() {
		System.out.print("학생 수 입력 >> ");
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[sc.nextInt()];
			
		sc.close();
	}
	
	private static void studentInputScores() {
		if (scores == null) {
			System.out.println("학생 수가 입력되지 않았습니다.");
			break;
		}
			
		System.out.print("점수 입력 >> ");
		int idx = 0;
		for (int score : scores) {
			System.out.println(idx + 1 + "번 학생 성적 입력");
			scores[idx++] = sc.nextInt();
		}
	}
	
	private static void printStudentScores() {
		
	}
}
