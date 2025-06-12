package com.self.service.impl.test;


import com.self.service.impl.BookManagerImpl;
import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerImplTest {

	public static void main(String[] args) {
		Book b1 = new Magazine(111, "월간 과학 탐구", "김민준 편집장", "미래 과학사", 9500.0, "과학");
		Book b2 = new Novel(222, "밤의 도서관", "엘리엇 제이", "별빛 출판사", 15800.0, new String[]{"판타지", "미스터리"});
		Book b3 = new Magazine(333, "스타일 매거진", "최서아", "글램 퍼블리싱", 12000.0, "패션");
		Book b4 = new Novel(444, "듄", "프랭크 허버트", "황금가지", 22500.0, new String[]{"SF", "어드벤처"});
		Book b5 = new Novel(555, "경성의 그림자", "김민지", "문학의 숲", 14000.0, new String[]{"로맨스", "시대극", "역사"});
		Book b6 = new Magazine(666, "비즈니스 인사이트", "이코노미 연구소", "경영 프레스", 15000.0, "경제경영");
		Book b7 = new Novel(777, "사라진 목격자", "박현수", "스릴러 하우스", 16500.0, new String[]{"스릴러", "서스펜스", "미스터리"});
		Book b8 = new Magazine(888, "오늘의 요리", "박지현 셰프", "맛있는 책방", 8800.0, "요리");
		
		BookManagerImpl bookService = BookManagerImpl.getInstance();
		
		// 1. 책 추가 및 전체 검색
		System.out.println("==== 책 추가 및 전체 검색 ====");
		
		bookService.insertBook(b1);
		bookService.insertBook(b2);
		bookService.insertBook(b3);
		bookService.insertBook(b4);
		bookService.insertBook(b5);
		bookService.insertBook(b6);
		bookService.insertBook(b7);
		bookService.insertBook(b8);
		System.out.println();
		for (Book b : bookService.getAllBook()) {
			System.out.println(b);
		}
		
		System.out.println();
		
		// 2. 책 삭제
		System.out.println("==== 책 삭제 : 666 ====");
		bookService.deleteBook(666);
		for (Book b : bookService.getAllBook()) {
			System.out.println(b);
		}
		
		System.out.println();
		
		// 3. 책 수정
		System.out.println("==== 책 수정 ====");
		bookService.updateBook(new Novel(777, "사라진 목격자", "박현수", "스릴러 하우스", 18000.0, new String[]{"스릴러", "서스펜스", "미스터리"}));
		bookService.updateBook(new Magazine(888, "오늘의 요리", "박지현 셰프", "맛있는 책방", 8800.0, "요리 및 생활"));
		bookService.updateBook(new Novel(444, "듄", "프랭크 허버트", "황금가지", 22500.0, new String[]{"SF", "어드벤처", "대하소설"}));
		for (Book b : bookService.getAllBook()) {
			System.out.println(b);
		}
		
		System.out.println();
		
		// 4. 책 검색(isbn)
		System.out.println("==== 책 검색(isbn): 444 ====");
		System.out.println(bookService.getBook(444).toString()); 
		
		System.out.println();
		
		// 5. 전체 책 수량
		System.out.println("==== 전체 책 수량 ====");
		System.out.println(bookService.getNumberOfBooks() + "권"); 
		
		System.out.println();
		
		// 6. 책 검색(제목)
		System.out.println("==== 책 검색(제목) : 밤의 도서관 ====");
		for (Book b : bookService.searchBookByTitle("밤의 도서관"))
			System.out.println(b);
		
		System.out.println();
		
		// 7. 책 가격대
		System.out.println("==== 책 가격대 : 15000원에서 20000원 사이 ====");
				
		for (Book b : bookService.searchBookByPrice(15000, 20000)) {
			System.out.println(b);
		}

		System.out.println();

		// 8. 전체 책 가격 합
		System.out.println("==== 전체 책 가격 합 ====");
		System.out.println(bookService.getSumPriceOfBooks() + "원"); 
				
		System.out.println();
	
		// 9. 전체 책 가격 평균
		System.out.println("==== 전체 책 가격 평균 ====");
		System.out.println(bookService.getAvgPriceOfBooks() + "원"); 
				
		System.out.println();

		// 10. 제목을 가지고 해당 책의 카테고리를 반환
		System.out.println("==== 제목을 가지고 해당 책의 카테고리를 반환 : 듄 ====");
		System.out.println(bookService.checkBookCategory("듄"));
		
		System.out.println();

		// 11. 장르에 해당하는 책들을 반환
		System.out.println("==== 장르에 해당하는 책들을 반환 : 미스터리 ====");				
		for (Book b : bookService.searchNovelByGenre("미스터리")) {
			System.out.println(b);
		}
		
		System.out.println();
	}

}
