<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Result JSP Page</h2><br>
	<b>1. vo 정보를 EL로 출력하기</b><br>
	${vo}
	<hr>
	<b>2. vo의 각각의 정보를 EL로 출력하기</b><br>
	1) ID: ${vo.id}
	2) pass: ${vo.password}
	3) NAME: ${vo.name}
	3) ADDR: ${vo.address}
	<hr>
</body>
</html>