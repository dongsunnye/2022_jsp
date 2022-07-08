<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
</head>
<body>
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
		<tbody>
			<!-- list에 저장된 내용을 출력 -->
			<c:forEach var="m" items="${requestScope.list }">
				<tr>
					<td>${m.bno }</td>
					<td>${m.title }</td>
					<td>${m.openDate }</td>
					<td>${m.count }</td>
					<td>${m.director }</td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
</body>
</html>








