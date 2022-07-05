<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el 태그 테스트</h2>
	<p>request에 저장된 내용은 requestScope를 사용해서 뽑음</p>
	<p>age : ${requestScope.age},${requestScope.age+10}</p>
	<p>session에 저장된 내용은 sessionScope를 사용해서 뽑음</p>
	<p>msg : ${sessionScope.msg }</p>
	<p>session에 저장된 객체 dto를 뽑음</p>
	<p>${sessionScope.dto.id }</p>
</body>
</html>