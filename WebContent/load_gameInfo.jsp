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
<%@ page import="service.GameInfoService" %>
<%
	request.setCharacterEncoding("UTF-8");
	String param_version = request.getParameter("param_version");
	
	GameInfoService gameInfoService = new GameInfoService();

	JSONObject infoObj = new JSONObject();
	
	if (param_version.equals("param_version")){
		infoObj = gameInfoService.ReadGameInfo();
		out.print(infoObj.toString());
	}
	else
	{
		System.out.println("no data");
	}
%>