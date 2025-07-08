<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 수정 결과 </h2>
	<h3>${member.id}님에 대한 정보입니다.</h3> 
	<hr>
	이름 : ${member.name} <br>
	주소 : ${member.address}<br>
	<h3><a href="index.jsp">INDEX</a></h3>
</body>
</html>