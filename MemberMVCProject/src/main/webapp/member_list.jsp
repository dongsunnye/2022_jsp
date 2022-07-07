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
				<a href="logout.do?command=logout">로그아웃</a> | <a href="update_view.jsp">회원정보 수정</a>
			</div>
		</header>		
		<nav>
			<ul>
				<li><a href="main.jsp">홈</a></li>
				<li><a href="memberList.do?command=search">회원목록</a></li>
				<li><a href="register.jsp">회원추가</a></li>
			</ul>
		</nav>
		<section>
			<table>
				<caption>
					<form action="memberList.do" method="get">
						<input type="hidden" name="command" value="search">
						<select name="kind">
							<option value="id"
								<c:if test="${param.kind == 'id' }">
									selected
								</c:if>
							>아이디</option>
							<option value="name"
								<c:if test="${param.kind == 'name' }">
									selected
								</c:if>
							>이름</option>
							<option value="gender"
								<c:if test="${param.kind == 'gender' }">
									selected
								</c:if>
							>성별</option>
							<option value="address"
								<c:if test="${param.kind == 'address' }">
									selected
								</c:if>
							>주소</option>
						</select>
						<input type="text" name="search" value="${param.search }">
						<button>검색</button>
					</form>
				</caption>
				<tr>
					<th>아이디</th>
					<th>암호</th>
					<th>이름</th>
					<th>나이</th>
					<th>성별</th>
					<th>주소</th>
					<th>비고</th>
				</tr>
				<c:forEach var="m" items="${requestScope.list }">
					<tr>
						<td><a href="updateView.do?id=${m.id }">${m.id }</a></td>
						<td>${m.pass }</td>
						<td>${m.name }</td>
						<td>${m.age }</td>
						<td>${m.gender }</td>
						<td>${m.address }</td>
						<td><a href="memberDelete.do?id=${m.id }">삭제</a></td>
					</tr>
				</c:forEach>		
			</table>
		</section>
	</div>
</body>
</html>





