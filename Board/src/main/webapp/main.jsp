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
	<!-- 회원등급이 1인지 확인을 한 후에 1이면 '권한이 없습니다' 경고창을 띄운후 이전페이지로 이동   -->
	<c:choose>
		<c:when test="${sessionScope.dto == null || sessionScope.dto.gradeNo == 1 }">
			<script type="text/javascript">
				alert('권한이 없습니다.');
				location.href = 'logout.do';
			</script>
		</c:when>
		<c:otherwise>
			<c:forEach var="board" items="${requestScope.board_list }">
				${board.bno } ${board.title } ${board.nick } ${board.bdate } ${board.bcount } ${board.like } ${board.hate }<br>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>



