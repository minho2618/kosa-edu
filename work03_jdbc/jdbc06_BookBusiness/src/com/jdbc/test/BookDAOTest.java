package com.jdbc.test;

import com.jdbc.dao.impl.BookDAOImpl;
import com.jdbc.vo.Book;

import config.ServerInfo;

public class BookDAOTest {

	public static void main(String[] args) {
		BookDAOImpl dao = BookDAOImpl.getInstance();
		
		try {
			dao.registerBook(new Book("000001", "페인트", "이희영", "창비", 13000));
			System.out.println("책 등록 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.deleteBook("000001");
			System.out.println("책 삭제 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(dao.findByBook("1", "페인트"));
			System.out.println("제목과 isbn으로 책 검색 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(dao.findByWriter("이희영"));
			System.out.println("작가로 책 검색 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(dao.findByPublisher("창비"));
			System.out.println("출판사로 책 검색 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(dao.findByPrice(10000, 15000));
			System.out.println("가격대로 책 검색 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.discountBook(10, "창비");
			System.out.println("책 가격 할인 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
