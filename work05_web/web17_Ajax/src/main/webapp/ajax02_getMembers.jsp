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
		$("#AjaxBtn").on('click', function() {
			
			let id = $("#userId").val();
			
			$.ajax({
				// 요청	
				type: 'post',
				url: "./members.json",
				data: { "id": id },
			
				// 응답
				success: function(result) {
					let members = result.members;
					$.each(members, function(index, item) {
						$('#resultView')//.append('<h3><font color=crimson>' + item.id + '</font></h3>');
						.append(`<h3><font color=crimson>\${item.id}</font></h3>`);
					});
				}
			});
		});		
	});
	</script>
</head>
<body>
	<h3>Form에 입력된 값을 서버로 보내고 서버에서 보낸 데이터를 가지고 페이지 부분갱신</h3>
	ID <input type="text" name="userId" id="userId">
	<input type="button" value="AjaxBtn" id="AjaxBtn">
	<div id="resultView">
	
	</div>
</body>
</html>