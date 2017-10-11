<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLEncoder" %>
<%@	page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@	page import="java.lang.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="data.ListInfo" %>
<%@ page import="data.TalkInfo" %>
<%@ page import="service.ReadTalkInfoService" %>
<%@ page import="service.ReadListInfoService" %>
<%@ page import="service.SendTalkInfoService" %>
<%@ page import="service.SendListInfoService" %>
<%@ page import="service.SendInfoService" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	// 1이면 타이틀, 2면 토크 정보를 읽어 온다.
	String param_index = request.getParameter("param_index");
 	
	if (param_index.equals("1"))
	{
		//타이틀 정보 전체를 읽어옵니다.
	  	ReadListInfoService readListInfoService = 
				ReadListInfoService.getInstance();
		readListInfoService.ConvertDB2Data();
		System.out.println("test log");
	}
	else if (param_index.equals("2"))
	{
		String param_group_id = request.getParameter("param_group_id");
		
		//스토리 톡 정보 전체를 읽어옵니다.
	  	ReadTalkInfoService readInfoService = ReadTalkInfoService.getInstance();
		readInfoService.ConvertDB2Data(param_group_id); 
	}
	
	//json형식의 정보를 출력해 보냅니다.
	SendInfoService sendInfoService = new SendInfoService();
	JSONObject jsonObj = sendInfoService.ConvertData2Json(param_index);
	out.print(jsonObj.toString());
	
 %>