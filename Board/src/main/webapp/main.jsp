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
		<c:if test="${sessionScope.dto == null || sessionScope.dto.gradeNo == 1 }">
			<script type="text/javascript">
				alert('권한이 없습니다.');
				location.href = 'logout.do';
			</script>
		</c:if>
		<!-- 회원등급이 7이면 관리자이므로 홈 게시판 회원관리 메뉴를 출력   -->
		<c:if test="${sessionScope.dto.gradeNo == 7 }">
			<nav>
				<ul>
					<li><a href="main.do">홈</a></li>
					<li><a href="#">게시판 관리</a></li>
					<li><a href="#">회원관리</a></li>
				</ul>
			</nav>
		
		</c:if>
		<section>
			<table>
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>직네임</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>좋아요</th>
						<th>싫어요</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="board" items="${requestScope.board_list }">
					<tr>
						<td>${board.bno }</td>
						<td>${board.title }</td>
						<td>${board.nick }</td>
						<td>${board.bdate }</td>
						<td>${board.bcount }</td>
						<td>${board.like }</td>
						<td>${board.hate }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>		
		</section>
</body>
</html>



