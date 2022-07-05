<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		height: 3000px;
	}
</style>
</head>
<body>
	<h2>el 태그 테스트</h2>
	<p>request에 저장된 내용은 requestScope를 사용해서 뽑음</p>
	<p>age : ${requestScope.age},${requestScope.age+10}</p>
	<p>session에 저장된 내용은 sessionScope를 사용해서 뽑음</p>
	<p>msg : ${sessionScope.msg }</p>
	<p>session에 저장된 객체 dto를 뽑음</p>
	<p>${sessionScope.dto.id },${sessionScope.dto.name },
	${sessionScope.dto.grade },${sessionScope.dto.grade == "VVIP"}</p>
	<p>${sessionScope.dto.toString() }</p>
	<h2>jstl 테스트</h2>
	<!-- set : 변수 만들어서 데이터 초기화 -->
	<c:set var="tnum" value="10000" />
	<!-- out : 해당 데이터 출력 -->
	<p><c:out value="${tnum }" />, ${tnum } </p>
	<!-- if문 test가 조건식, 단 else, else if는 없음 -->
	<p>if문</p>
	<c:if test="${requestScope.age < 20}">
		<p>미성년자 입니다.</p>
	</c:if>
	<c:if test="${requestScope.age >= 20}">
		<p>성인 입니다.</p>
	</c:if>
	<p>여러개 조건문</p>
	<c:choose>
		<c:when test="${requestScope.age >= 20 && requestScope.age < 30 }">
			<p>20대 입니다</p>
		</c:when>
		<c:when test="${requestScope.age >= 30 && requestScope.age < 40 }">
			<p>30대 입니다</p>
		</c:when>
		<c:otherwise>
			<p>40대 이상입니다.</p>
		</c:otherwise>
	</c:choose>
	<p>반복문 - 시작값, 종료값, 증감값 설정해서 반복</p>
	<ul>
		<c:forEach var="i" begin="1" end="10">
			<li>${i }</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="i" begin="1" end="10" step="2">
			<li>${i }</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="m" items="${requestScope.list }">
			<li>${m.toString() }</li>
		</c:forEach>
	</ul>
</body>
</html>











