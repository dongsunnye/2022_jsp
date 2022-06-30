<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("data");
	request.setAttribute("result", "request_"+param);
	//sendRedirect로 페이지 이동시 request 영역이 전부 초기화
	response.sendRedirect("redirect_result.jsp");
%>