package com.edu.capsulation.test;
/*
 Encapsulation 코드 작성 패턴
 1. 필드 앞에는 private
 2. void setter(xxx) ---> public
 	xxx getter()	 ---> public
 3. setter 메소드에서 필드 초기화하기 직전에 타당한 값만 필드에 할당 되도록 제어문을 달아준다.
 	"필드는 유효값만 들어가도록"
 */
import java.util.Scanner;

import com.edu.capsulation.MyDate;

public class MyTest {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		
		Scanner sc = new Scanner(System.in);
//		md.month = 33;
//		md.day = 13;
		
		System.out.println("월 일 입력 >>>");
		md.setMonth(sc.nextInt());
		md.setDay(sc.nextInt());
		
		//if (md.getMonth() == 0 || md.getDay() == 0)
		System.out.println("오늘은 " + md.getMonth() + "월 " + md.getDay() + "일입니다!!!");
		
		sc.close();
	}

}
