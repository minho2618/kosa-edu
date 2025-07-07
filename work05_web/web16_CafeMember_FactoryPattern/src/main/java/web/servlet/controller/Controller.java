package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	ModelAndView requesetHandler(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
