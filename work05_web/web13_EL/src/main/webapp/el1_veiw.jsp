<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Result JSP Page</h2>
	<b>1. JSP에서 원래 사용했던 방식으로 데이터 받아서 출력</b>
	<br>
	Request에 바인딩한 값 <%= request.getAttribute("RESULT1") %><br>
	Session에 바인딩한 값 <%= session.getAttribute("RESULT2") %><br>
	<hr>
	<b>2. EL 방식으로 데이터 받아서 출력</b>
	<br>
	1) ${RESULT1} <br>
	2) ${RESULT2} <br>
	3) ${RESULT1 + 111} <br>
	<hr>
	
</body>
</html>