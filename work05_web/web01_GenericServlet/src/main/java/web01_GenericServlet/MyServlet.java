package web01_GenericServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet extends GenericServlet {

	@Override
	public void service(ServletRequest requeset, ServletResponse response) throws ServletException, IOException {
		/*
		 * request 안 요청 정보를 바탕으로 
		 * 요청을 실행한 후 
		 * response 안에 결과를 담아서 
		 * 클라이언트에게 정보를 전달
		 */
		
		PrintWriter out =  response.getWriter();
		out.println("<html><body><h2>");
		out.println("Hello, MyServlet");
		out.println("</h2></body></html>");
	}
	
}
