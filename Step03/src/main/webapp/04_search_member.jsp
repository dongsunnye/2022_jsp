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
				
	});
</script>
</head>
<body>
	<form>
		<select name="kind">
			<option value="id">아이디</option>
			<option value="name">이름</option>
			<option value="gender">성별</option>
		</select>
		<input type="text" name="search" placeholder="검색어를 입력하세요"> 
		<button type="button">검색</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>암호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
		<!-- ajax 결과가 추가될 영역	 -->
		</tbody>
	</table>
</body>
</html>











