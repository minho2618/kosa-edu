package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

// 확장자가 .do로 들어오는 모든 요청은 DispatcherServlet이 받는다.
@WebServlet("*.do")
public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	// 이전 방식과 다른 방식으로 command 값을 받아오자
	// hidden 태그 방식이 아닌
	// 들어온 요청을 직접 받아서 command 값으로 연결
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI(); // web16_CafeMember_FactoryPattern/find.do
		System.out.println("getRequestURI() => " + requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("getContextPath() => " + contextPath);
				
		String command = requestURI.substring(contextPath.length() + 1);
		System.out.println("command => " + command);
		
		// 1. command 값을 주고 controller를 반환
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		ModelAndView mv = null;
		String path = "index.jsp";
		try {
			mv = controller.requesetHandler(request, response);
			
			if (mv != null) {
				path = mv.getPath();
				if (mv.isRedirect())
					response.sendRedirect(path);
				else
					request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
