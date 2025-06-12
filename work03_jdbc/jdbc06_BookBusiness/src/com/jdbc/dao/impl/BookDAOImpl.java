package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.jdbc.dao.BookDAO;
import com.jdbc.exception.BookNotFoundException;
import com.jdbc.exception.DMLException;
import com.jdbc.exception.DuplicateISBNException;
import com.jdbc.exception.InvalidInputException;
import com.jdbc.vo.Book;

import config.ServerInfo;

public class BookDAOImpl implements BookDAO {
	private static BookDAOImpl dao = new BookDAOImpl();
	
	private BookDAOImpl() { }
	
	public static BookDAOImpl getInstance() {
		return dao;
	}

	/// 공통로직
	private Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
	}
	
	private PreparedStatement getPreparedStatement(Connection conn, String query) throws SQLException {
		return conn.prepareStatement(query);
	}
	
	/// 비지니스 로직
	@Override
	public void registerBook(Book vo) throws DMLException, DuplicateISBNException {
		String query = "INSERT INTO book (isbn, title, writer, publisher, price) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = getConnect(); PreparedStatement ps = getPreparedStatement(conn, query);) {
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getWriter());
			ps.setString(4, vo.getPublisher());
			ps.setInt(5, vo.getPrice());
			ps.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new DuplicateISBNException(vo.getIsbn() + "번은 이미 등록되었습니다.");
		} catch (SQLException e) {
			throw new DMLException("책 등록 중 문제가 발생했습니다.");
		}
	}

	@Override
	public void deleteBook(String isbn) throws DMLException, BookNotFoundException {
		String query = "DELETE FROM book WHERE isbn=?";
		try (
				Connection conn = getConnect();
				PreparedStatement ps = getPreparedStatement(conn, query);
			) {
			ps.setString(1, isbn);
			ps.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new BookNotFoundException(isbn + "번은 존재하지 않습니다.");
		} catch (SQLException e) {
			throw new DMLException("책 삭제 중 문제가 발생했습니다.");
		}
	}

	@Override
	public Book findByBook(String isbn, String title) throws DMLException {
		String query = "SELECT isbn, title, writer, publisher, price FROM book WHERE isbn=? AND title=?";
		Book book = null;
		try (Connection conn = getConnect(); PreparedStatement ps = getPreparedStatement(conn, query);) {
			ps.setString(1, isbn);
			ps.setString(2, title);
			
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("writer"), rs.getString("publisher"), rs.getInt("price") );
				}
			}
		} catch (SQLException e) {
			throw new DMLException("책 검색 중 문제가 발생했습니다.");
		}
		
		return book;
	}

	@Override
	public ArrayList<Book> findByWriter(String writer) throws DMLException {
		String query = "SELECT isbn, title, writer, publisher, price FROM book WHERE writer=?";
		ArrayList<Book> books = new ArrayList<>();
		try (Connection conn = getConnect(); PreparedStatement ps = getPreparedStatement(conn, query);) {
			ps.setString(1, writer);
			
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					books.add(new Book(rs.getString("isbn"), rs.getString("title"), 
							rs.getString("writer"), rs.getString("publisher"), rs.getInt("price")));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("책 검색 중 문제가 발생했습니다.");
		}
		
		return books;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publisher) throws DMLException {
		String query = "SELECT isbn, title, writer, publisher, price FROM book WHERE publisher=?";
		ArrayList<Book> books = new ArrayList<>();
		try (Connection conn = getConnect(); PreparedStatement ps = getPreparedStatement(conn, query);) {
			ps.setString(1, publisher);
			
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					books.add(new Book(rs.getString("isbn"), rs.getString("title"), 
							rs.getString("writer"), rs.getString("publisher"), rs.getInt("price")));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("책 검색 중 문제가 발생했습니다.");
		}
		
		return books;
	}

	@Override
	public ArrayList<Book> findByPrice(int min, int max) throws DMLException, InvalidInputException {
		String query = "SELECT isbn, title, writer, publisher, price FROM book WHERE price BETWEEN ? AND ?";
		ArrayList<Book> books = new ArrayList<>();
		try (Connection conn = getConnect(); PreparedStatement ps = getPreparedStatement(conn, query);) {
			ps.setInt(1, min);
			ps.setInt(2, max);
			
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					books.add(new Book(rs.getString("isbn"), rs.getString("title"), 
							rs.getString("writer"), rs.getString("publisher"), rs.getInt("price")));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("책 검색 중 문제가 발생했습니다.");
		}
		
		return books;
	}

	@Override
	public void discountBook(int per, String publisher) throws DMLException {
		// 출판사 책 조회
		String query = "UPDATE book SET price=price*(100-?)/100 WHERE publisher=?";
		try (
				Connection conn = getConnect();
				PreparedStatement ps = getPreparedStatement(conn, query);
			) {
			ps.setInt(1, per);
			ps.setString(2, publisher);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DMLException("책 할인 적용 중 문제가 발생했습니다.");
		}	
	}

}
