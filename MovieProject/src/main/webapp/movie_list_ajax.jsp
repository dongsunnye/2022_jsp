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
				},
				error:function(xhr, textStaus, errorThrow){
					
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>영화 검색 페이지</h2>
	<select id="kind">
		<option value="title">영화 제목</option>
		<option value="director">감독</option>
		<option value="year">개봉년도</option>
	</select>
	<input type="text" id="search" placeholder="검색어 입력하세요">
	<button>검색</button>
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









