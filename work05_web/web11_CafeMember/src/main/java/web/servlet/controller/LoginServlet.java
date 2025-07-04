package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		Member member = null;
		String path = "index.html";
		
		try {
			member = dao.login(request.getParameter("id"), request.getParameter("password"));
			if (member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				path = "login_result.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		

		request.getRequestDispatcher(path).forward(request, response);
	}

	
}
