<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#id').keyup(function () {
			let id = $(this).val();
			
			
		}); // keyup(), keydown(), keyPress()
	});
	</script>
</head>
<body>
	<h2>Key Event</h2>
	ID <input type="text" id="id">
</body>
</html>