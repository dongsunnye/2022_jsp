<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("data");
	request.setAttribute("result", "request_"+param);
	response.sendRedirect("redirect_result.jsp");
%>