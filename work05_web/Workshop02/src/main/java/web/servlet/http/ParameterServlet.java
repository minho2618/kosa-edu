package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet(urlPatterns = {"/params"}, loadOnStartup = 1)
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h3>job : " + request.getParameter("job") + "</h3>");
		out.println("<h3>pageNo : " + request.getParameter("pageNo") + "</h3>");
		out.println("<h3>searchWorld : " + request.getParameter("searchWord") + "</h3>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String[] hobbyArr = request.getParameterValues("hobby");
		
		out.println("<html><body>");
		out.println("<h3>name : " + request.getParameter("name") + "</h3>");
		out.println("<h3>email : " + request.getParameter("email") + "</h3>");
		out.println("<h3>gender: " + request.getParameter("gender") + "</h3>");
		out.print("<h3>hobby : " );
		for (int i = 0; i < hobbyArr.length;) {
			out.print(hobbyArr[i]);
		    if (++i < hobbyArr.length) {
		    	out.print(", ");
		    }
		}
		out.println("</h3>");
		out.println("<h3>favorite : " + request.getParameter("favorite") + "</h3>");
		out.println("<h3>desc : " + request.getParameter("desc") + "</h3>");
		out.println("</body></html>");
	}

}
