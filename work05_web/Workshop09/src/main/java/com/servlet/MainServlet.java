package com.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.Count;
import com.edu.Kickboard;

@WebServlet("/front.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		if (command.equals("count")) {
			bookCount(request, response);
		} else if (command.equals("kickboard")) {
			kickboardCount(request, response);
		}
	}
	
	private void bookCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("book");
		String str = new Count().execute(book);
		
		request.setAttribute("str", str);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}
	
	private void kickboardCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		//String path = ".\\" + request.getContextPath() + "\\res";
		String path =  request.getServletContext().getRealPath("/res");
		File file = new File(path, fname);
		
		int num = new Kickboard().execute(file);
		
		request.setAttribute("num", num);
		request.getRequestDispatcher("Result2.jsp").forward(request, response);
	}
}
