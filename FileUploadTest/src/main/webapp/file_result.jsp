<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${requestScope.writer } 가 보낸 파일 목록</h2>
	<c:forEach var="file" items="${requestScope.fileList }">
		<c:choose>
			<c:when test="${file.type =='image' }">
				<p><img src="fileDown.do?file=${file.fileName }"></p>
			</c:when>
			<c:otherwise>
				<p><a href="fileDown.do?file=${file.fileName }">${file.fileName } 다운로드</a></p>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>






