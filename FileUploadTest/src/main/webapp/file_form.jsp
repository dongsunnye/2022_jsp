<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file form</title>
</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<p><input type="text" name="writer" placeholder="작성자"></p>
		<p><button>업로드</button></p>
		<p><input type="file" name="file1"> </p>
	</form>
</body>
</html>