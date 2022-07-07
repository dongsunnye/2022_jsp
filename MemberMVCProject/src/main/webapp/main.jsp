<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	.container{
		width: 1200px;
		display: flex;
		flex-direction: column;
		margin: 50px auto;
	}
	header{
		text-align: right;
	}
	.profile{
		display: inline-block;
		text-align: left;
	}
	nav{
		border-bottom: 1px solid black;
		padding: 20px 0px;
	}
	nav ul{
		list-style-type: none;
		display: flex;
		flex-direction: row;
		justify-content: space-around;
	}
	nav ul li{
		width: 200px;
	}
	nav ul li a:link,nav ul li a:visited {
		display: inline-block;
		font-size: 20px;
		font-weight: bold;
		text-align: center;
		width: 100%;
		padding:10px 0px;
		color:black;
		text-decoration: none;
	}
	section table{
		margin:30px auto;
		border-collapse: collapse;
	}
	
	th, td{
		width:150px;
		text-align:center;
		padding:10px;
		font-size: 20px;
		border:1px solid black;
	}
	
</style>
</head>
<body>
<c:if test="${sessionScope.dto == null}">
	<c:redirect url="index.jsp"/>
</c:if>
	<div class="container">
		<header>
			<div class="profile">
				${sessionScope.dto.name }님 로그인 하셨습니다.<br>
				<a href="logout.do">로그아웃</a> | <a href="update_view.jsp">회원정보 수정</a>
			</div>
		</header>		
		<nav>
			<ul>
				<li><a href="main.jsp">홈</a></li>
				<li><a href="memberList.do">회원목록</a></li>
				<li><a href="register.jsp">회원추가</a></li>
			</ul>
		</nav>
		<section>
			<table>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>나이</th>
					<th>성별</th>
					<th>주소</th>
				</tr>
				<!-- session 영역에 저장된 list를 출력 -->	
				<c:forEach var="m" items="${sessionScope.list }">
					<tr>
						<td>${m.id }</td>
						<td>${m.name }</td>
						<td>${m.age }</td>
						<td>${m.gender }</td>
						<td>${m.address }</td>
					</tr>
				</c:forEach>		
			</table>
		</section>
	</div>
</body>
</html>





