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
	
	// 1�̸� Ÿ��Ʋ, 2�� ��ũ ������ �о� �´�.
	String param_index = request.getParameter("param_index");
 	
	if (param_index.equals("1"))
	{
		//Ÿ��Ʋ ���� ��ü�� �о�ɴϴ�.
	  	ReadListInfoService readListInfoService = 
				ReadListInfoService.getInstance();
		readListInfoService.ConvertDB2Data();
		System.out.println("test log");
	}
	else if (param_index.equals("2"))
	{
		String param_group_id = request.getParameter("param_group_id");
		
		//���丮 �� ���� ��ü�� �о�ɴϴ�.
	  	ReadTalkInfoService readInfoService = ReadTalkInfoService.getInstance();
		readInfoService.ConvertDB2Data(param_group_id); 
	}
	
	//json������ ������ ����� �����ϴ�.
	SendInfoService sendInfoService = new SendInfoService();
	JSONObject jsonObj = sendInfoService.ConvertData2Json(param_index);
	out.print(jsonObj.toString());
	
 %>