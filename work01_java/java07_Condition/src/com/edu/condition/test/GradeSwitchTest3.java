package com.edu.condition.test;

public class GradeSwitchTest3 {
	public static void main(String[] args) {
		int grade = 80;
		
		switch (grade) {
			case 100:
			case 90:
				System.out.println("A Grade...");
				break;
			case 85:
			case 80:
				System.out.println("B Grade...");
				break;
			
			case 75:
			case 70:
				System.out.println("C Grade...");
				break;
				
			default:
				System.out.println("Nuts~~!!");
		}
	}
}
