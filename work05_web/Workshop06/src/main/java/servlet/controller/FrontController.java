package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;
import servlet.model.User;
import servlet.model.UserDAOImpl;

@WebServlet("/Front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text:html/charset=utf-8;");
		
		String command = request.getParameter("command");
		String path = "./error/error.jsp";
		
		System.out.println(command);
		
		switch (command) {
		case "allBook":
			path = allBook(request, response);
			break;
		case "register":
			path = register(request, response);
			break;
		case "login":
			path = login(request, response);
			break;
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private String allBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "./error/error.jsp";
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		try {
			bookList = BookDAOImpl.getInstance().getAllBook();
			request.setAttribute("bookList", bookList);
			path = "./book/showAll.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return path;
	}
	


	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "./error/error.jsp";
		
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = bookNoList[0] + "-" + bookNoList[1] + "-" + bookNoList[2];
		String bookTitle = request.getParameter("bookTitle");
		String bookCategory = request.getParameter("bookCategory");
		
		String bookCountry = request.getParameter("bookCountry");
		String bookDate = request.getParameter("bookDate");
		String bookPublisher = request.getParameter("bookPublisher");
		
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPrice = request.getParameter("bookPrice");
		String bookCurrency = request.getParameter("currency");
		String bookSummary = request.getParameter("bookSummary");
		
		try {
			BookDAOImpl.getInstance().registerBook(isbn, bookTitle, bookCategory, bookCountry, 
					bookDate, bookPublisher, bookAuthor, Integer.parseInt(bookPrice), bookCurrency, bookSummary);
			
			path = "./book/bookSuccess.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return path;
	}
	

	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "./error/error.jsp";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		User user = null;
		try {
			 user = UserDAOImpl.getInstance().login(id, password);
			 if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				path = "loginSuccess.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return path;
	}
}
