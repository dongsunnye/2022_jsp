<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$("button").click(function() {
			$.ajax({
				url:"02_ajax_json.jsp",
				//data:,
				type:"get",
				dataType:"text",
				success:function(r){
					$("#result").html(r);
				}
			});
		});
	});

</script>
</head>
<body>
	<button>현재 날짜 시간 요청</button>
	<div id="result"></div>
</body>
</html>

