<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLEncoder" %>
<%@	page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@	page import="java.lang.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="service.user.UserInfoService" %>
<%
	request.setCharacterEncoding("UTF-8");
	String param_name = request.getParameter("param_name");
	
	UserInfoService userInfoService = new UserInfoService();

	JSONObject nameObj = userInfoService.CheckUserNameData(param_name);
	JSONObject signInObj = new JSONObject();


	if (nameObj.get("login_name") == "1")
	{
		signInObj.put("login_name", "1");
		out.print(signInObj.toString());
	}
	else if (nameObj.get("login_name") == "0")
	{
		signInObj.put("login_name", "0");
		out.print(signInObj.toString());
	}
%>