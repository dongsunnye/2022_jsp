<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.container {
	width: 1200px;
	display: flex;
	flex-direction: column;
	margin: 50px auto;
}

header {
	text-align: right;
}

.profile {
	display: inline-block;
	text-align: left;
}

nav {
	border-bottom: 1px solid black;
	padding: 20px 0px;
}

nav ul {
	list-style-type: none;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}

nav ul li {
	width: 200px;
}

nav ul li a:link, nav ul li a:visited {
	display: inline-block;
	font-size: 20px;
	font-weight: bold;
	text-align: center;
	width: 100%;
	padding: 10px 0px;
	color: black;
	text-decoration: none;
}

section h2{
	margin-top:40px;
	text-align: center;
}
section ul{
	margin:0 auto;
	list-style-type: none;
	display: flex;
	width: 300px;
	flex-direction: column;
}
section li {
	margin-top: 10px;
}
li > input{
	width: 100%;
	height: 30px;
	border-radius: 5px;
	border:1px solid gray;
}
li > button{
	width: 50%;
	height: 40px;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<c:if test="${sessionScope.dto == null}">
		<c:redirect url="index.jsp" />
	</c:if>
	<div class="container">
		<header>
			<div class="profile">
				${sessionScope.dto.name }님 로그인 하셨습니다.<br> <a href="logout.do?command=logout">로그아웃</a>
				| <a href="">회원정보 수정</a>
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
			<h2>회원 정보 수정</h2>
			<form action="update.do" method="post">
				<input type="hidden" name="type" value="member">
				<ul>
					<li>
						<input type="text" name="id" placeholder="아이디를 입력하세요" value="${requestScope.dto.id }" readonly>
					</li>
					<li>
						<input type="password" name="passwd" placeholder="암호를 입력하세요" value="${requestScope.dto.pass }">
					</li>
					<li>
						<input type="text" name="name" placeholder="이름을 입력하세요" value="${requestScope.dto.name }">
					</li>
					<li>
						<input type="number" name="age" placeholder="나이를 입력하세요" value="${requestScope.dto.age }">
					</li>
					<li>
						<div>
							<c:set var="m" value="M"/>
							<c:set var="f" value="F"/>
							<input type="radio" name="gender" id="g1" value="M"	
								<c:if test="${requestScope.dto.gender == m}">checked</c:if>
							> 
							<label for="g1">남</label>
							<input type="radio" name="gender" id="g2" value="F" 
								<c:if test="${requestScope.dto.gender==f}">checked</c:if>
							> 
							<label for="g2">여</label>
						</div>
					</li>
					<li>
						<input type="text" name="address" placeholder="주소를 입력하세요" value="${requestScope.dto.address }">
					</li>
					<li>
						<button>정보수정</button><button type="button" onclick="history.back();">취소</button>
					</li>
				</ul>
			</form>
		</section>
	</div>
</body>
</html>





