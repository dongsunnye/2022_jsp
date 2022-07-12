<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	nav{
		width: 1200px;
		margin:0 auto;
	}
	nav > ul{
		display: flex;
		flex-direction: row;
		justify-content: center;
		list-style-type: none;
	}
	nav > ul > li{
		width: 200px;
	}
	section{
		width: 1200px;
		margin:0 auto;
	}
	section table{
		width: 90%;
		border-collapse: collapse;
	}
	section table td,section table th{
		border:1px solid black;
		text-align: center;
		padding:10px 0px;
	}
</style>
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
				<tfoot>
					<!-- 게시판 페이징 처리 -->
					<tr>
						<td colspan="7">
							<!-- 이전 페이지 그룹으로 이동 -->
							<c:if test="${requestScope.pagging.priviousPageGroup }">
								<a href="main.do?pageNo=${requestScope.pagging.startPageOfPageGroup-1}">◀</a>
							</c:if>
							<!-- 페이지 번호 출력 -->
							<c:forEach var="i" begin="${requestScope.pagging.startPageOfPageGroup}" 
							end="${requestScope.pagging.endPageOfPageGroup}">
								<c:choose>
									<c:when test="${i == requestScope.pagging.currentPageNo }">
									${i }						
									</c:when>
									<c:otherwise>
										<a href="main.do?pageNo=${i }">${i }</a>							
									</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<!-- 다음 페이지 그룹으로 이동 -->
							<c:if test="${requestScope.pagging.nextPageGroup }">
								<a href="main.do?pageNo=${requestScope.pagging.endPageOfPageGroup+1}">▶</a>
							</c:if>
						</td>
					</tr>
				</tfoot>
			</table>		
		</section>
</body>
</html>



