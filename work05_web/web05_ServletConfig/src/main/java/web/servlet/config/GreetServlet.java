package web.servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 필드 추가
	private String name=""; // 클라이언트가 서버에 요청할때
	private String greet=""; // Ready On 시점...서블릿 생성 직후, 컨테이너 차원에 설정한 값을 받아옴
	
	public GreetServlet() {
		System.out.println("1. 서블릿 생성");
	}
	

	public void init() throws ServletException {
		System.out.println("2. ServletConfig 생성...init() 호출");
		greet = getInitParameter("GREET");
		
		System.out.println("Greet Message => " + greet);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		System.out.println("3. 클라이언트 요청할때마다 호출...doGet");
		
		PrintWriter out = response.getWriter();
		name = request.getParameter("username");
		
		out.println("<html><body>");
		out.println("<h3>" + name + ", " + greet + "</h3>");
		out.println("</body></html>");
	}


}
