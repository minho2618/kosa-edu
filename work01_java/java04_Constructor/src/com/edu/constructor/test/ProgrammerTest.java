package com.edu.constructor.test;

import com.edu.constructor.NoteBook;
import com.edu.constructor.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		  1. programmer 객체 2명 생성
		 	James, 김안나 - 정보는 알아서
		 2. James가 Apple사 노트북을 구매
		 	김안나가 LG사 노트북을 구매
		 3. James의 연봉을 출력
		 
		 4. 김안나의 급여를 50만원 인상
		 	김안나의 연봉를 출력
		 
		 5.각각 개발자의 정보를 최종적으로 출력
		 */
		
		// 1.
		Programmer james = new Programmer("James", "Java", 300, 50);
		Programmer anna = new Programmer("김안나", "Javascript", 200, 20);
				
		// 2.
		NoteBook macBook = new NoteBook(123L, "Apple", 200.0f);
		NoteBook gram = new NoteBook(456L, "LG", 150.0f);
		
		james.buyNoteBook(macBook);
		anna.buyNoteBook(gram);
		
		// 3.
		System.out.println(james.getAnnualSalary());
		
		// 4.
		anna.increaseSalary(50f);
		System.out.println(anna.getAnnualSalary());
		
		// 5.
		System.out.println(james.getProgrammerInfo());
		System.out.println(anna.getProgrammerInfo());		
	}

}
