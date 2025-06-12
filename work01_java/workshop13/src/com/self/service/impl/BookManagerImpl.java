package com.self.service.impl;

import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerImpl implements BookManager {
	private static BookManagerImpl bookManger = new BookManagerImpl();
	private int numberOfBook;
	private int idx;
	private final static int MAX_BOOKS = 100;
	private Book[] books;
	
	private BookManagerImpl() {
		books = new Book[MAX_BOOKS];
	}
	
	public static BookManagerImpl getInstance() {
		return bookManger;
	}

	@Override
	public void insertBook(Book book) {
		books[idx++] = book;
		numberOfBook += 1;
		System.out.println("'" + book.getTitle() + "' 추가 완료됨. 현재 " + (MAX_BOOKS - numberOfBook) + "권 추가 가능함.");
	}

	@Override
	public void deleteBook(int isbn) {
		int deleteIdx = whereBookByIsbn(isbn);
		
		if (deleteIdx == -1) {
			System.out.println("해당하는 책이 없습니다.");
			return;
		}
		
		for (int j = deleteIdx; j < idx; j++) {		
			if (j + 1 == idx) {
				books[j] = null;
				break;
			}
			books[j] = books[j + 1];
		}
		
		idx -= 1;
		numberOfBook -= 1;
	}

	@Override
	public void updateBook(Book book) {
//		int updateIdx = whereBookByIsbn(book.getIsbn());
//		
//		books[updateIdx].setTitle(book.getTitle());
//		books[updateIdx].setPrice(book.getPrice());
//		books[updateIdx].setAuthor(book.getAuthor());
//		books[updateIdx].setPublisher(book.getPublisher());
//		if (book instanceof Magazine) {
//			((Magazine) books[updateIdx]).setTopic(((Magazine) book).getTopic());
//		} else if (book instanceof Novel) {
//			((Novel) books[updateIdx]).setGenre(((Novel) book).getGenre());
//		}

		// 향상된 for 문...update 안됨
		// 값 수정 안됨
//		for (Book b : books) {
//			if (b == null) break;
//			
//			if (b.getIsbn() == book.getIsbn()) {
//				if (b instanceof Magazine) b = (Magazine)book;
//				else if (b instanceof Novel) b = (Novel)book;
//			}
//		}
		
		for (int i = 0; i < idx; i++) {
		if (books[i] == null) break;
		
		if (books[i] .getIsbn() == book.getIsbn()) {
			if (books[i]  instanceof Magazine) books[i]  = (Magazine)book;
			else if (books[i]  instanceof Novel) books[i]  = (Novel)book;
		}
	}
		
	}

	@Override
	public Book getBook(int isbn) {
		int bIdx = whereBookByIsbn(isbn);
		
		if (bIdx == -1)
			return null;
		else
			return books[bIdx];
	}

	@Override
	public Book[] getAllBook() {
		Book[] returnBooks = new Book[numberOfBook];
		
		System.arraycopy(books, 0, returnBooks, 0, numberOfBook);
		
		return returnBooks;
	}

	@Override
	public int getNumberOfBooks() {
		return numberOfBook;
	}

	@Override
	public Book[] searchBookByTitle(String title) {
		Book[] tmpBooks = new Book[numberOfBook];
		int count = 0;
		
		for (Book b : books) {
			if (b == null)
				break;
			
			if (b.getTitle().equals(title))
				tmpBooks[count++] = b;
		}
		
		Book[] resultBooks = new Book[count];
		System.arraycopy(tmpBooks, 0, resultBooks, 0, count);
		
		return resultBooks;
	}

	@Override
	public Book[] searchBookByPrice(int min, int max) {
		Book[] tmpBooks = new Book[numberOfBook];
		int count = 0;
		
		for (Book b : books) {
			if (b == null)
				break;
			
			if (b.getPrice() <= max && b.getPrice() <= min)
				tmpBooks[count++] = b;
		}
		
		Book[] resultBooks = new Book[count];
		System.arraycopy(tmpBooks, 0, resultBooks, 0, count);
		
		return resultBooks;
	}

	@Override
	public double getSumPriceOfBooks() {
		int sum = 0;
		
		for (Book b : books) {
			if (b == null)
				break;
			
			sum += b.getPrice();
		}
		
		return sum;
	}

	@Override
	public double getAvgPriceOfBooks() {		
		return getSumPriceOfBooks() / numberOfBook;
	}

	@Override
	public String checkBookCategory(String title) {
		Book target = null;
		
		for (Book b : books) {
			if (b == null)
				break;
			
			if (b.getTitle().equals(title)) {
				target = b;
				break;
			}
		}
		
		if (target == null) {		
			return "";
		} else if (target instanceof Magazine) {
			return "Magazine";
		} else if (target instanceof Novel) {
			return "Novel";
		}
		
		return "";
	}

	@Override
	public Book[] searchNovelByGenre(String genre) {
		Book[] tmpBooks = new Book[numberOfBook];
		int count = 0;
		
		for (Book b : books) {
			if (b == null)
				break;
			
			if (b instanceof Novel) {
				String[] genres = ((Novel) b).getGenre();
				for (String s : genres) {
					if (s.equals(genre)) {
						tmpBooks[count++] = b;
					}
				}
			}
		}
		
		Book[] resultBooks = new Book[count];
		System.arraycopy(tmpBooks, 0, resultBooks, 0, count);
		
		return resultBooks;
	}
	
	/// private function
	
	private int whereBookByIsbn(int isbn) {
		int bIdx = -1;
		
		// 해당하는 책의 위치를 찾기
		for (int i = 0; i < idx; i++) {				
			if (books[i].getIsbn() == isbn) {
				bIdx = i;
				break;
			}
		}
		
		return bIdx;
	}
}
