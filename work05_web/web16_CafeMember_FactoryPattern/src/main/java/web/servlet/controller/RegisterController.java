package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class RegisterController implements Controller {
	
	@Override
	public ModelAndView requesetHandler(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id").trim(); 
		String password = request.getParameter("password").trim(); 
		String name = request.getParameter("name").trim(); 
		String address = request.getParameter("address").trim(); 
		
		Member pvo = null;
		String path = "find_fail.jsp";
		ModelAndView route = null;
		
		try {
			pvo = new Member(id, password, name, address);
			
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";

			route = new ModelAndView(path);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			route = new ModelAndView("index.jsp", true);
		}
		
		return route;
	}

}
