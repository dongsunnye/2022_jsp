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
	a:link, a:visited {
		color:black;
		text-decoration: none;
	}
	.current{
		color:red;
		font-weight: bold;
	}
	tfoot td{
		text-align: center;
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
		<tfoot>
			<tr>
				<td colspan="5">
					<!-- 이전 페이지 그룹이 있으면 ◁ 이전그룹 마지막 페이지로 링크 -->
					<c:if test="${requestScope.pagging.priviousPageGroup }">
						<a href="list.do?pageNo=${requestScope.pagging.startPageOfPageGroup-1}">◁</a>
					</c:if>
					<!-- pagging을 이용하여 페이지 번호 -->
					<c:forEach var="i" begin="${requestScope.pagging.startPageOfPageGroup }" 
					end="${requestScope.pagging.endPageOfPageGroup }">
					<!-- 현재 페이지 번호는 제외하고 링크를 적용 -->
					<c:choose>
						<c:when test="${i == requestScope.pagging.currentPageNo }">
							<span class="current">${i }</span> 					
						</c:when>
						<c:otherwise>
							<a href="list.do?pageNo=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
					</c:forEach>
					
					<!-- 다음 페이지 그룹이 있으면 ▷ 다음 그룹 첫번째 페이지로 링크 -->
					<c:if test="${requestScope.pagging.nextPageGroup }">
						<a href="list.do?pageNo=${requestScope.pagging.endPageOfPageGroup+1}">▷</a>
					</c:if>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>








