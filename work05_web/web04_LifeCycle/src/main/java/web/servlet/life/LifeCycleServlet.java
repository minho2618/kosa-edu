/*
 * Lazy Loading
 * Ready On 상태 작업들이(서블릿 인스턴스 생성, 서블릿 초기화...)
 * 최초에 클라이언트가 서버에 서비스를 요청하기 전에 이미 서버에서 진행된다.
 * 
 * Pre Loading
 * Ready On 상태 작업들이(서블릿 인스턴스 생성, 서블릿 초기화...)
 * 클라이언트가 서비스를 요청하기 전에 이미 완료된 상태로 서비스를 맞게된다.
 * 이렇게 작업이 미리 되어있기 위해서는 중요한 옵션을 Annotation에 지정
 * <load-on-start> 1 </load-on-start>
 */

package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1) // PreLoading 옵션
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 필드 추가
	private int count = 0;
	
    public LifeCycleServlet() {
    	System.out.println("1. 서블릿 인스턴스가 생성된다...LifeCycleServlet() 호출...by Container");
    }
    
	public void init() throws ServletException {
		System.out.println("2. init() 호출...by Container");
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. doGet() 호출...by Container");
		
		// 클라이언트 쪽으로 응답
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>Test</h3>");
		out.println("<b>Count :: "+ ++count + "</b>");
		out.println("</body></html>");
		
		out.close();
	}

	public void destroy() {
		System.out.println("4. destroy() 호출...by Container");
	}
}
