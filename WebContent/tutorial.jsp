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
<%@ page import="service.ReadTutorialService" %>
<%@ page import="service.SendTutorialService" %>

<%
	request.setCharacterEncoding("UTF-8");
	String param_tuto = request.getParameter("param_tuto");
	String param_branch = request.getParameter("param_branch");
		
	if (param_tuto.equals("param_tuto")){
		ReadTutorialService readTutorialService =
				ReadTutorialService.getInstance();
		readTutorialService.ConvertDB2Data();
		
		//json형식의 정보를 출력해 보냅니다.
		JSONObject tutoObj = new JSONObject();
		
		SendTutorialService sendTutorialService = new SendTutorialService();
		JSONArray tutoArray = sendTutorialService.ConvertTutoData2Json();
		
		tutoObj.put("Tutorial", tutoArray);
		
		out.print(tutoObj.toString());
	}
	else if(param_tuto.equals("param_tuto_like")) {

		SendTutorialService sendTutorialService = new SendTutorialService();
		
		sendTutorialService.SumLikeTutorial(param_branch);
	}
	else
	{
		System.out.println("PARAMETER ERROR");
	}
%>