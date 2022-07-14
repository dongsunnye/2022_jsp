<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td>
			<td>${requestScope.board.bno }</td>
		</tr>
		<tr>
			<td>제목 : </td>
			<td>${requestScope.board.title}</td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td>${requestScope.board.nick}</td>
		</tr>
		<tr>
			<td>조회수 : </td>
			<td>${requestScope.board.bcount}</td>
		</tr>
		<tr>
			<td colspan="2"> 
				${requestScope.board.content}
			</td>
		</tr>
		<tr>
			<td colspan="2"> 
				<a href="#">좋아요 ${requestScope.board.like}</a>
				<a href="#">싫어요 ${requestScope.board.hate}</a>
			</td>
		</tr>
		<c:if test="${requestScope.board.writer == sessionScope.dto.id }">
		<tr>
			<td colspan="2"> 
				<button id="btn_update">수정</button>
				<button id="btn_delete">삭제</button>
			</td>
		</tr>		
		</c:if>
	</table>
</body>
</html>







