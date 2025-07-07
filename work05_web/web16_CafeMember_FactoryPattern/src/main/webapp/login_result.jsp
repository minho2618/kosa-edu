<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	 <c:choose>
	 	<c:when test="${!empty member}">
	 		<h3>Login Information</h3>
		 	ID ${member.id}<br>
		 	NAME ${member.name}<br>
		 	ADDRESS ${member.address}<br>
		 	<hr>
		 	<h3><b><a href="logout.do">Log Out</a></b></h3>
		 	<h3><b><a href="index.jsp">INDEX</a></b></h3>
	 	</c:when>
	 	<c:otherwise>
		 	<h3>로그인부터 다시 진행하세요</h3>
		 	<h3><a href="index.jsp">INDEX</a></h3>
	 	</c:otherwise>
	 </c:choose>
</body>
</html>