<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
	<style>
        h1 {
            text-align: center;
        }
        form {
            text-align: right;
            margin-right: 438px;
        }
        table {
            width: 800px;
            margin: 20px auto;
        }
        tr {
            height: 43px;
        }
        th{
            background: #ddd;
        }
        .center{
        	margin-left: 740px;
        	padding-top: 30px;
        }
        
        .bookDetail {
        	text-align: center;
        	color: crimson;
        }
    </style>
    
    <script>
    $(function() {
    	$('.subject').mouseover(function() {
    		let isbn = $(this).attr('id'); // id에 연결된 isbn을 가져옴
    			
    		$.ajax({
    			// 요청
    	   		type: "get",
    	   		url: "front.do?command=findBook&isbn=" + isbn,
    	   		
    	   		// 응답
    	   		success: function(result) {
    	   			let arr = result.split("\n");
    	   			$('.bookDetail').html("Book 상세정보 출력 - 제목: " + arr[0].trim() 
    	   					+ ", 출판사: " + arr[1].trim() + ", 저자: " + arr[2]);
    	   		} // callback
    	   	});	    	
    	
    	});
    });
    </script>
</head>
<body>
	<h1>도서 목록 화면</h1>
    <form action="${pageContext.request.contextPath}/front.do">
    	<input type="hidden" name="command" value="search">
        <select name="searchSelect">
            <option disabled selected>전체</option>
            <option value="title">도서명</option>
            <option value="catalogue">도서분류</option>
            <option value="author">저자</option>
        </select>
        <input type="text" name="searchText">
        <input type="submit" value="검색">
    </form>
    
    <c:choose>
    	<c:when test="${list.size() == 0}">
    		<h4 style="text-align: center;">입력된 책이 존재하지 않습니다.</h4>
    	</c:when>
    	<c:otherwise>
    		<table border="1" id="bookList">
		        <tr>
		            <th>도서번호</th>
		            <th>도서명</th>
		            <th>도서분류</th>
		            <th>저자</th>
		        </tr>
		        
		        <c:forEach items="${list}" var="book">
					<tr>
						<td>${book.isbn}</td>
						<td><span id="${book.isbn}" class="subject">${book.title}</span></td>
						<td>${book.catalogue}</td>
						<td>${book.author}</td>
					</tr>
				</c:forEach>
		    </table>
    	</c:otherwise>
    </c:choose>
    
    
    <div class="bookDetail">
	    
	</div>
    <div class="center">
	    <a href="./book/Book.html">도서 등록</a>
	    <a href="${pageContext.request.contextPath}/front.do?command=bookList">도서 목록</a>
	</div>
</body>
</html>