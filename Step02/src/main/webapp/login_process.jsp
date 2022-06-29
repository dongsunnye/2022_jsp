<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if(id.equals("admin") && pass.equals("1234")){
		out.write("<script>location.href='login_success.jsp'</script>");
	}else{
		out.write("<script>location.href='login_fail.jsp'</script>");
	}
%>