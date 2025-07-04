package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Member;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 1. 폼값 받아서
		 * 2. pvo 생성
		 * 3. DAO리턴 받고 비지니스로직 호출
		 * 4. 반환되는 값을 바인딩
		 * 5. 세션에 바인딩
		 *    로그인, 회원 정보 수정때만 세션에 바인딩
		 * 6. 페이지 이동
		 */
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Member pvo = new Member(id, password, "총종각", "종각");
		
		HttpSession session = request.getSession(); // 맨 처음 만들어진 세션
		System.out.println("LoginServletsession => JSESSION => " + session.getId());
		session.setAttribute("vo", pvo); //로그인 정보를 바인딩
		
		// 네비게이션...???
		response.sendRedirect("BuyServlet");
	}

}
