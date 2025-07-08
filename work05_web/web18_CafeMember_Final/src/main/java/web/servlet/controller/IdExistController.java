package web.servlet.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class IdExistController implements Controller {

	@Override
	public ModelAndView requesetHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		boolean flag = false;
		String path ="index.jsp";
		ModelAndView route = null;
		
		try {
			flag = MemberDAOImpl.getInstance().idExist(id);
			
			
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("result.jsp").forward(request, response);
			
			//route = new ModelAndView("register.jsp");
			
			/*
			 * PrintWriter out = response.getWriter(); out.print(flag);
			 */		
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			route = new ModelAndView("index.jsp", true);
		}
		
		return null;
	}

}
