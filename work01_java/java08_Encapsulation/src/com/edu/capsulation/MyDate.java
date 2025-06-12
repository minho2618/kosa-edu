package com.edu.capsulation;
//날짜 관련된 정보를 저장하는 클래스
public class MyDate {
	
	// 해당 클래스의 멤버들끼리만 접근을 허용함
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		//필드 초기화하기 전에 제어한다.
		if (month >= 1 && month <= 12) {			
			this.month = month;
		} else {
			System.out.println("잘못된 월 입력입니다...");
			//return;
			System.exit(0);
		}
		
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		
//		if (day >= 1 && day <= 31) {	
//			if ((month == 4 || month == 6 || month == 9 || month == 11)) {
//				if (day <= 30) {
//					this.day = day;
//					isCorrect = true;
//				}	
//				else {
//					System.out.println("잘못된 일 입력입니다...");	
//				}
//			} else if (month == 2) {
//				if (day <= 28) {
//					this.day = day;
//					isCorrect = true;
//				}	
//				else {
//					System.out.println("잘못된 일 입력입니다...");	
//				}
//			} else {
//				this.day = day;
//				isCorrect = true;
//			} 
//		} else {
//			System.out.println("잘못된 일 입력입니다...");	
//		}	
		
		switch(month) {
			case 2:
				if (day >= 1 && day <= 28) {
					this.day = day;
				} else {
					System.out.println("잘못된 일 입력입니다...");	
					System.exit(0);
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (day >= 1 && day <= 30) {
					this.day = day;
				} else {
					System.out.println("잘못된 일 입력입니다...");	
					System.exit(0);
				}				
				break;
			default:
				if (day >= 1 && day <= 31) {
					this.day = day;
				} else {
					System.out.println("잘못된 일 입력입니다...");	
					System.exit(0);
				}
		}			
		
		return;
	}
}
