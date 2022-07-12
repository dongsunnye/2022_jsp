<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<section>
		<form action="boardWrite.do" method="post">
			<input type="hidden" name="writer" value="${sessionScope.dto.id }">
			<input type="text" name="title" placeholder="제목을 입력하세요">
			<textarea name="content" placeholder="내용을 입력하세요"></textarea>
			<button>글쓰기</button><button type="button">뒤로가기</button>
		</form>
	</section>
</body>
</html>