package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class LoginController implements Controller {

	@Override
	public ModelAndView requesetHandler(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Member member = null;
		String path ="index.jsp";
		ModelAndView route = null;
		
		try {
			member = MemberDAOImpl.getInstance().login(id, password);
			if (member != null) { 
				HttpSession session = request.getSession(); 
				session.setAttribute("member", member); 
				path = "login_result.jsp";
			}
			
			route = new ModelAndView(path, true);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			route = new ModelAndView("index.jsp", true);
		}
		
		return route;
	}

}
