package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class AllMemberController implements Controller {
	
	@Override
	public ModelAndView requesetHandler(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		ModelAndView route = null;
		
		try {
			ArrayList<Member> list = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list); 
			path = "allView.jsp";
			
			route = new ModelAndView(path);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			route = new ModelAndView("index.jsp", true);
		}
		
		return route;
	}
}
