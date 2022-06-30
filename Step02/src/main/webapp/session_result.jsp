<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getId() %><br>
request : <%=request.getAttribute("req") %><br>
session : <%=session.getAttribute("session") %><br>
<a href="invalid.jsp">세션 정보 초기화</a>
</body>
</html>