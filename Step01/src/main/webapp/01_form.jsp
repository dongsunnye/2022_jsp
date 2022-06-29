<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송</title>
</head>
<body>
	<!-- action = '실행할 서버 페이지' -->
	<form action="data_result.jsp" method="get">
		<!-- name='보낼 데이터명' -->
		<input type="text" name="data"><button>전송</button>
	</form>
	<hr>
	<form action="data_number.jsp" method="get">
		<input type="number" name="num"><button>전송</button>
	</form>
</body>
</html>






