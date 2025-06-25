<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Result Page~~</h2>
	<ul>
		<li>당신의 아이디: ${param.id}</li>
		<li>당신의 이름: ${param.name}</li>
	</ul>
	<h3>선택한 취미</h3>
	${paramValues.hobby[0]}<br />
	${paramValues.hobby[1]}<br />
	${paramValues.hobby[2]}<br />
	${paramValues.hobby[3]}<br />
</body>
</html>