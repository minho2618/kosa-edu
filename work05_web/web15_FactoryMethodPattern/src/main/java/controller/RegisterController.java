package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * MVC...Servlet...
		 * FrontController...register() {}
		 * 1. 폼 값 받아서
		 * 2. DAO 반환받아서 비지니스 로직 호출
		 * 3. 데이터바인딩
		 * 4. 내비게이션
		 */
		System.out.println("RegisterController...DAO...registerMember call...");
		
		return "register_result.jsp";
	}

}
