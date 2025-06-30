package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LifeCycleServlet"}, loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleServlet() {
        
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("1. init() 호출됨");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2. doGet() 호출됨");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2>안녕하세요, LifeCycleServlet 입니다</h2>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2. doPost() 호출됨");
	}

	@Override
	public void destroy() {
		System.out.println("3. destroy() 호출됨");
	}
}
