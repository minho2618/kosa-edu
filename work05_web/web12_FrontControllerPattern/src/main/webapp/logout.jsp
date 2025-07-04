<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Logout</title>
	<script>
		function logout() {
			alert("LogOut~~!!");
		}
	</script>
</head>
<!-- 
로그아웃 로직::: 
1)user를 찾아와서 
2)user가 있다면 
3)세션을 죽인다. 
-->
<body onload="return logout()">
	<%
	Member member = (Member)session.getAttribute("member");
	if (member != null) { // 로그인이 되어져 있다면
		session.invalidate(); // 세션을 죽임
	%>
	
	<%
	}
	%>
	
	<h3><b>로그아웃되었습니다.</b></h3><br>
	<a href="login.jsp">HOME</a>
</body>
</html>