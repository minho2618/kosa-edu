<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL로 폼값 받아오기</h2>
	<b>1. 이전 방식으로 폼값 받아서 출력하기</b><br>
	ID <%= request.getParameter("myId") %><br>
	MENU <br>
	<% 
	String[] menus = request.getParameterValues("menu"); 
	for (String menu : menus) {
	%>
	
	<%= menu %><br>
	
	<%
	}
	%>
	<b>2. EL 방식으로 폼값 받아서 출력하기</b><br>
	1) ID ${param.myId}<br>
	2) MENU<br>
	${paramValues.menu[0]}<br>
	${paramValues.menu[1]}<br>
	${paramValues.menu[2]}<br>
	${paramValues.menu[3]}<br>
</body>
</html>