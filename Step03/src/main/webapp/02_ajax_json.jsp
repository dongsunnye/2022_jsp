<%@page import="org.json.JSONObject"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Calendar today = Calendar.getInstance();
	JSONObject obj = new JSONObject();
	obj.put("year", today.get(Calendar.YEAR));
	obj.put("month", today.get(Calendar.MONTH)+1);
	obj.put("date", today.get(Calendar.DATE));
	obj.put("hour", today.get(Calendar.HOUR_OF_DAY));
	obj.put("minute", today.get(Calendar.MINUTE));
	obj.put("second", today.get(Calendar.SECOND));
	
	out.write(obj.toString());
	
%>