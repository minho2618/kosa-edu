<%@page import="web.servlet.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Product product = (Product)request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품이 저장되었습니다.</h2>
	상품 번호 : 1<br>
	상 품 명 : <%= request.getParameter("name") %><br>
	상품 가격 : <%= request.getParameter("price")  %><br>
	상품 설명 : <%= request.getParameter("detail") %><br>
	<a href="ListServlet">상품 목록</a>
</body>
</html>