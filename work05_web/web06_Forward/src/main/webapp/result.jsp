<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/* 자바코드를 사용할 때는 이 안에서 해야한다. */
Member member = (Member)request.getAttribute("member");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Result Page</h2>
ID : <%= member.getId() %><br>
PASS : <%= member.getPassword() %><br>
NAME : <%= member.getName() %><br>
</body>
</html>