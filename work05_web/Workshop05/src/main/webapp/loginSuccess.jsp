<%@page import="servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	body {
		text-align: center;
	}
	</style>
</head>
<body>
	<h2><%= user.getName() %> 님이 로그인 되었습니다</h2>
	<br>
	<a href="./book/Book.html">도서 등록</a><br>
	<a href="login.html">로그아웃</a>
</body>
</html>