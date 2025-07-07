<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	  <script type="text/javascript">
	  	$(function() {
	  		$('#serverSend').on('click', function() {
	  			//$('tbody').html('');
	  			
	  			$.ajax({
	  				type: 'get',
	  				url: 'http://localhost:8888/weather.xml',
	  				datatype: 'xml',
	  				
	  				success: function(result) {
	  					let str = '';
	  					$(result).find('list').each(function(index, item) {
	  						let region = $(this).find('region').text();
	  						let wind = $(this).find('wind').text();
	  						let temp = $(this).find('temp').text();
	  						let rain = $(this).find('rain').text();
	  						
	  						str += '<tr>';
	  						str += `<td>\${region}</td>`;
	  						str += `<td>\${wind}</td>`;
	  						str += `<td>\${temp}</td>`;
	  						str += `<td>\${rain}</td>`;
	  						str += `</tr>`;
	  						
	  						
	  					});
	  					$('tbody > tr > *').remove();
	  					$('tbody').append(str);
	  				} // callback
	  				
	  			});
	  		});
	  	});
	  </script>
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center">
			<h2>===== Open API Weather 데이터 가져오기 =====</h2>
		</div>
		<p><a href="#" id="serverSend">XML 데이터 요청하기</a></p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>region</th>
					<th>wind</th>
					<th>temp</th>
					<th>rain</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</div>
	</div>
</body>
</html>