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
	String param_check = request.getParameter("param_check");
	String param_id = request.getParameter("param_id");
	String param_pw = request.getParameter("param_pw");
	String param_name = request.getParameter("param_name");
	String param_account_type = request.getParameter("param_account_type");
	
	UserInfoService userInfoService = new UserInfoService();

	JSONObject idObj = userInfoService.CheckUserIdData(param_id);
	JSONObject nameObj = userInfoService.CheckUserNameData(param_name);
	JSONObject signInObj = new JSONObject();
	
	if (param_check.equals("id_check")){
		//�α��� ���̵� ���� ���.
		if (idObj.get("login_id") == "1")
		{
			signInObj = userInfoService.CheckUserIdAndPwData(param_id, param_pw);
			
			//��й�ȣ�� ���� ���.
			if(signInObj.get("password") == "0")
			{
				signInObj.put("login_id", "1");
				signInObj.put("password", "0");
				out.print(signInObj.toString());
			}
			//��й�ȣ�� ���� ���.
			else
			{
				out.print(signInObj.toString());
			}
		} 
		//�α��� ���̵� ���� ���.
		if (idObj.get("login_id") == "0")
		{
			signInObj.put("login_id", "0");
			signInObj.put("password", "0");
			out.print(signInObj.toString());
		}
	}
	
	else if (param_check.equals("nick_check")){
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
	}
	
	// facebook �α��� ���� �κ�
	else if (param_check.equals("facebook_check")) {

		// �α��� ���̵� ���� ���.
		if (idObj.get("login_id") == "0")
		{
			signInObj.put("login_id", "0");
			out.print(signInObj.toString());
		}
		
		// �α��� ���̵� ���� ���
		else if (idObj.get("login_id") == "1")
		{
			signInObj = userInfoService.CheckUserIdAndPwData(param_id, "nil");
			out.print(signInObj.toString());
		} 
	}
%>