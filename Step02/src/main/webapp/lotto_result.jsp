<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		margin:0 auto;
		border-collapse: collapse;
	}
	td{
		border:1px solid black;
		padding:30px;
	}
</style>
</head>
<body>
<table>
<%
	ArrayList<HashSet<Integer>> list =(ArrayList<HashSet<Integer>>) request.getAttribute("list");
	for(int i=0;i<list.size();i++){
%>
		<tr>
<%
		HashSet<Integer> set = list.get(i);
		for(int n : set){
%>
			<td><%=n %></td>
<%			
		}
%>
		</tr>
<%
	}
%>
</table>
</body>
</html>




