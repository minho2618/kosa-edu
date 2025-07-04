<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
	function logout() {
		alert("LogOut~~!!");
	}
	</script>
</head>
<!--  
로그아웃 로직::::
1)user를 찾아와서
2)user가 있다면
3)세션을 죽인다
-->
<body onload="return logout()">
	<c:if test="${user != null}">
		<% session.invalidate();  %>
	</c:if>
	<h3><b>로그아웃 되었습니다.</b><br>
	<a href="login.html">HOME</a></h3>
</body>
</html>

















