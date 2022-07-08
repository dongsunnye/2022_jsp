<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{
		text-align: center;
	}
	.container{
		text-align: center;
	
	}
	table{
		margin: 0 auto;
		border-collapse: collapse;
	}
	thead > tr{
		border-top:1px solid black;
		border-bottom:1px double black;
	}
	tbody > tr{
		border-bottom:1px solid black;
	}
	td,th{
		padding:10px 20px;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$("button").click(function() {
			var d;
			d = "kind="+ $("#kind").val();
			d += "&search="+$("#search").val();
			$.ajax({
				url : 'search.do',
				data : d,
				type:'get',
				dataType:'json',
				success:function(r){
					console.log(r);
					var tag = "";
					for(i=0;i<r.length;i++){
						tag += "<tr>";
						tag += "<td>"+r[i].bno+"</td>";
						tag += "<td>"+r[i].title+"</td>";
						tag += "<td>"+r[i].openDate+"</td>";
						tag += "<td>"+r[i].count+"</td>";
						tag += "<td>"+r[i].director+"</td>";
						tag += "</tr>";
					}
					$("tbody").html(tag);
				},
				error:function(xhr, textStaus, errorThrow){
					console.log("code : ",xhr.status);
					console.log("message : ",xhr.responseText);
					console.log("error : ",errorThrow);
					console.log("textStaus : ",textStaus);
					var tag = "<tr><td colspan='6' style='text-align:center'>"
													+xhr.responseText+"</td></tr>";
					$("tbody").html(tag);
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>영화 검색 페이지</h2>
	<div class="container">
	<select id="kind">
		<option value="title">영화 제목</option>
		<option value="director">감독</option>
		<option value="year">개봉년도</option>
	</select>
	<input type="text" id="search" placeholder="검색어 입력하세요">
	<button>검색</button>
	</div>
	<hr>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>영화명</th>
				<th>개봉일</th>
				<th>누적관객수</th>
				<th>감독</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</body>
</html>









