<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function() {
			//var d = $("form").serialize();//num=?
			var d = "num=" + $("input[name=num]").val();
			console.log(d);
			$.ajax({
				data : d,
				url : "divisor_ajax.jsp",
				type:"get",
				dataType:"json",
				success:function(r){
					var tag = "";
					for(i=0;i<r.length;i++)
						tag += "<span>"+r[i]+"</span> ";
					
					$("#result").html(tag);
				}
				
			});
		});
	});
</script>
</head>
<body>
	<form>
		<input type="number" name="num"><button type="button">전송</button>
	</form>
	<div id="result"></div>
</body>
</html>