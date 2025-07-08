package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class UpdateController implements Controller {

	@Override
	public ModelAndView requesetHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("address");
		
		String path = "index.jsp";
		
		Member pvo = new Member(id, password, name, addr);
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			// 바인딩...세션
			HttpSession session = request.getSession();
			if (session.getAttribute("member") != null) { // 로그인상태일 때만 바인딩
				session.setAttribute("member", pvo);
				
				path = "update_result.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView(path);
	}

}
