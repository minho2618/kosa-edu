package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public ModelAndView requesetHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션을 죽이는 로직을 작성
		String path = "index.jsp";
		
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("member") != null) {
				session.invalidate();
				path = "logout.jsp";
			}
		} catch (Exception e) {
			
		}
		
		return new ModelAndView(path);
	}

}
