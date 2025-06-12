package com.edu.array.test;

import java.util.Scanner;

import com.edu.array.SawonMBTI;
/*
6
1 4 4 4 5 3
*/
public class SawonMBTITest3 {
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
	    int[ ] types = new int[5]; //5가지의 타입임으로
		
		for(int i=0; i<people.length; i++) {
			switch(people[i]) { //1,4,4,4,5,3
			case 1 :
				types[0]++;
				break;
			case 2 :
				types[1]++;
				break;
			case 3 :
				types[2]++;
				break;
			case 4 :
				types[3]++;
				break;
			case 5 :
				types[4]++;
				break;
			}//switch
		}//for
		int max = 0;
		for(int i=0; i<types.length; i++) {
			if(max<types[i]) max = types[i];
		}
		
		int answer = 0;
		for(int i=0;i<types.length; i++) {
			if(max==types[i]) {
				answer = i+1;
			}//
		}//		
		System.out.println("정답 :: "+answer);	
		System.out.println(max);
	}
}










