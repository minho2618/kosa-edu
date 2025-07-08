package web.servlet.controller;

// 이전의 ControllerFactory 이름으로 만들었던 클래스!!
// Component를 생성하는 공장의 역할
// 싱글톤 패턴으로 생성...
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	
	private HandlerMapping() {
		
	}
	
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	// Component를 생성하는 기능
	public Controller createController(String command) {
		Controller controller = null;
		
		if (command.equals("find.do")) {
			controller = new FindController();
			System.out.println("FindController 생성...");
		} else if (command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("LoginController 생성...");
		} else if (command.equals("register.do")) {
			controller = new RegisterController();
			System.out.println("RegisterController 생성...");
		} else if (command.equals("allMember.do")) {
			controller = new AllMemberController();
			System.out.println("AllMemberController 생성...");
		} else if (command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LogoutController 생성...");
		} else if (command.equals("update.do")) {
			controller = new UpdateController();
			System.out.println("UpdateController 생성...");
		} else if (command.equals("idExist.do")) {
			controller = new IdExistController();
			System.out.println("IdExistController 생성...");
		}
		
		return controller;
	}
}
