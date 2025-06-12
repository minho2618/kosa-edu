package com.edu.condition.test2;

import java.util.Scanner;

public class Game369Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 2자리수만 입력 >> ");
		int num = sc.nextInt();
		
		Game369 game = new Game369();
		String result = game.solve(num);
		
		System.out.println(result);
	}

}

class Game369 {
	public String solve(int num) {
		String result = "";
		
		int tenNum = (int)(num / 10);
		int oneNum = (int)(num % 10);
		
		if (tenNum % 3 != 0 && oneNum % 3 != 0)
			return result + num;
		
		if (tenNum % 3 == 0)
			result = result + "@";
		
		if (oneNum % 3 == 0 && oneNum != 0)
			result = result + "@";
		
		return result;
	}
}