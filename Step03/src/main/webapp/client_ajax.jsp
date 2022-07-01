<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax client</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$("button").click(function() {
			$.ajax({
				url:"01_ajax_test.jsp",
				//data:,
				type:"get",
				//dataType:"text",
				success:function(r){
					$("#result").html(r);
				}
			});
		});
	});

</script>
</head>
<body>
	<button>ajax 요청</button>
	<div id="result"></div>
</body>
</html>