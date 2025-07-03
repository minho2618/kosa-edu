package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

import web.servlet.model.Member;

@WebServlet(urlPatterns = { "/Register" }, loadOnStartup = 2)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		/*
		 * 1. 폼값 받아서
		 * 2. DAO 반환받고
		 * 3. biz 로직 호출...registerMember(값)
		 * 4. 네비게이션
		 */
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		Member pvo = new Member(id, pass, name); // Parameter VO
		
		// request.setAttribute("vo", pvo);
		
		// ServletContext 사용
		// ServletContext context = getServletContext();
		// context.setAttribute("vo", pvo);
		
		// Session 사용
		HttpSession session = request.getSession();
		session.setAttribute("vo", pvo);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h3>");
		out.println("Link to Next Pagge");
		out.println("<a href=list.jsp>ListServlet Page</a>");
		out.println("</h3></body></html>");
	}
}
