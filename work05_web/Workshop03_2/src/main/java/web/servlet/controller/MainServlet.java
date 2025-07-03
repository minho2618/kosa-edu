package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;
import web.servlet.model.ProductDAOImpl;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html;charset=utf-8");
				
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String detail = request.getParameter("detail");
		
		// pvo 생성
		Product pvo = new Product(name, price, detail);
		
		try {
			ProductDAOImpl.getInstance().addProduct(pvo);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// 네비게이션		
		// 바인딩 작업은 안한다.
		// 비지니스 로직 호출 결과로 데이터를 반환받았을 경우만 한다
		//request.getRequestDispatcher("ListServlet").forward(request, response);
		response.sendRedirect("ListServlet");
		
	}
}
