<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
<%
	String n = request.getParameter("num");
	int end = Integer.parseInt(n);
	for(int i=1;i<=end;i++){
%>
		<p><%=i %></p>
<%
	}
%>
</body>
</html>






