package com.edu.refactoring.test;

import java.util.Random;
import java.util.Scanner;

import com.edu.refactoring.Game;

public class GameTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요. ");
		
		int type = sc.nextInt();
		
		Game game = new Game();
		game.setGameRule(type);
		
		while (!game.isFinished()) {
			System.out.print("가위바위보 중 하나 입력: ");
			String n = sc.next();
			game.playGame(n);
		}
		
		System.out.println(game.gameResult());

		sc.close();
	}

}
