<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");

	if(id == null){
%>
	<form action="login_session_process.jsp" method="post">
	 	아이디 : <input type="text" name="id"><br>
	 	비밀번호 : <input type="password" name="pass"><br> 
		<button>로그인</button>	 	
	</form>
<%
	}else{
%>
	<%=id %>님이 로그인 하셨습니다.<br>
	<a href="logout.jsp">로그아웃</a>
<%
	}
%>
</body>
</html>



