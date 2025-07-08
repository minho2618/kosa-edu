package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class FindController implements Controller {

	@Override
	public ModelAndView requesetHandler(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		ModelAndView route = null;
		
		try {
			Member rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";

				route = new ModelAndView(path);
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			route = new ModelAndView("index.html", true);
		}
		
		return route;
	}

}
