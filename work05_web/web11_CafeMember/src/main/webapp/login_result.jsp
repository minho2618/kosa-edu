<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
<!-- 
1. 세션에서 바인딩된 vo 찾아와서
2. 정보를 출력
 -->
 <%
 Member member = (Member)session.getAttribute("member");
if (member != null) {
 %>
 	<h3>Login Information</h3>
 	ID <%= member.getId() %><br>
 	NAME <%= member.getName() %><br>
 	ADDRESS <%= member.getAddress()%><br>
 	<hr>
 	<h3><b><a href="logout.jsp">Log Out</a></b></h3>
 	<h3><b><a href="index.html">INDEX</a></b></h3>
 <%
} else {
 %>
 	<h3>로그인부터 다시 진행하세요</h3>
 	<h3><a href="index.html">INDEX</a></h3>
 <%
}
 %>
</body>
</html>