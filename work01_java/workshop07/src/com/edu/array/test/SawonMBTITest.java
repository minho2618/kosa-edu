package com.edu.array.test;

import java.util.Scanner;

import com.edu.array.SawonMBTI;
/*
6
1 4 4 4 5 3
*/
public class SawonMBTITest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("K전자 신입사원수 입력 >>> ");
		int num = sc.nextInt();//배열의 사이즈
		int[ ] people =new int[num]; //6
		
	    System.out.println("공백을 기준으로 각 사원에 대한 성격 유형을 직접 입력 >>> ");
	    for (int i = 0; i < people.length; i++) {
	    	people[i] = sc.nextInt();
	    }
		
		// 코드 작성
		SawonMBTI sawonMBTI = new SawonMBTI(people);
	    
		int answer = sawonMBTI.getMostNum();
		
		System.out.println("정답 :: "+answer);
	}
}










