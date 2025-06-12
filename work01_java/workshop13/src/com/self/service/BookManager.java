package com.self.service;

import com.self.vo.Book;

public interface BookManager {
	void insertBook(Book book);
	void deleteBook(int isbn);
	void updateBook(Book book);
	Book getBook(int isbn);
	Book[] getAllBook();
	int getNumberOfBooks();
	Book[] searchBookByTitle(String title);
	Book[] searchBookByPrice(int min, int max);
	double getSumPriceOfBooks();
	double getAvgPriceOfBooks();
	
	// 제목을 가지고 해당 책의 카테고리를 반환
	String checkBookCategory(String title);
	// 장르에 해당하는 책들을 반환
	Book[] searchNovelByGenre(String genre);
}
