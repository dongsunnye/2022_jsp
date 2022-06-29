<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	//post일 경우 패킷에 포함되서 오기때문에 한글 문자 코드가 깨짐, UTF-8로 변환
	request.setCharacterEncoding("utf-8");
	String hak = request.getParameter("hak");
	String name = request.getParameter("name");
	String major = request.getParameter("major");
%>
<%= hak %><br>
<%= name %><br>
<%= major %><br>
</body>
</html>