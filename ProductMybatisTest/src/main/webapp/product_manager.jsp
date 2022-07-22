<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#frm").submit(function(e) {
			e.preventDefault();
			var d = $(this).serialize();
			$.ajax({
				url:"insertProduct.do",
				data : d,
				type:"get",
				dataType:"json",
				success:function(r){
					var tag = "<table>";
					for(i=0;i<r.length;i++){
						tag+="<tr>";
						tag+="<td>"+r[i].productNo+"</td>";
						tag+="<td>"+r[i].productName+"</td>";
						tag+="<td>"+r[i].maker+"</td>";
						tag+="<td>"+r[i].ea+"</td>";
						tag+="<td>"+r[i].price+"</td>";
						tag+="</tr>";
					}
					tag+="</table>";
					$(".container").html(tag);
				},
				error:function(xhr,text,error){
					alert(xhr.responseText);
				}
			});
		});
	});
</script>
</head>
<body>
	<form id="frm">
		<input type="text" name="product_no" placeholder="제품번호">
		<input type="text" name="product_name" placeholder="제품명">
		<input type="text" name="maker" placeholder="제조사">
		<input type="text" name="ea" placeholder="재고">
		<input type="text" name="price" placeholder="금액">
		<button>등록</button>
	</form>
	<hr>
	<div class="container"></div>
</body>
</html>







