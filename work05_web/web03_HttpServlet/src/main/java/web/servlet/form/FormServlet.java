package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// thread 생성 -> service() -> doGet()
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼 값 받아온다
		 * 2. 그 값을 그대로 화면에 출력
		 */
		// 한글처리는 request, response 각각 따로 해줘야 한다.
		// 서버에서 브라우저로 응답할때 한글처리
		response.setContentType("text/html;charset=utf-8"); // 한글 처리
		
		// 브라우저에서 서버로 보낼때 한글처리...HttpServletRequest body 부분에 담긴 데이터 한글처리
		// Post 방식일 때만 적용
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		PrintWriter out = response.getWriter();
		
		/*
		 * 결과 페이지의 역할은 Servlet 역할이 아니다.
		 * Servlet은 로직 중심의 기술
		 * JSP는 Tag 중심의 기술이므로 JSP에서 담당하도록 한다.
		 */
		
		// out.println("<html><body>");
		//	out.println("<h2>당신의 이름은 "+ name + "</h2>");
		//	out.println("<h2>당신이 사는 곳은 "+ addr + "</h2>");
		//	out.println("</body></html>");
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
