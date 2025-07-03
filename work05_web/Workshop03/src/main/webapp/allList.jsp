<%@page import="java.util.ArrayList"%>
<%@page import="web.servlet.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	
	<style>
	body {
		border: 5px solid black;
		width: 800px;
		margin: 10px;
		padding: 10px;
	}
	</style>
</head>
<body>
	<div class="jumbortorn text-center">
		<h2>Product List</h2>
	</div>
	
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">상품번호</th>
	      <th scope="col">상품명</th>
	      <th scope="col">상품가격</th>
	      <th scope="col">상세설명</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<%
		for (Product p : productList) {
		%>
		<tr>
	      <th scope="row"><%= p.getNum() %></th>
	      <td><%= p.getName() %></td>
	      <td><%= p.getPrice() %></td>
	      <td><%= p.getDetail() %></td>
	    </tr>
		<%
		}
		%>
	  </tbody>
	</table>
	
	
	<h2><a href="index.html">INDEX</a></h2>
</body>
</html>