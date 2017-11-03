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
<%@ page import="data.ListInfo" %>
<%@ page import="data.TalkInfo" %>
<%@ page import="service.user.UserInfoService" %>
<%@ page import="dao.UserInfoDAO" %>
<%@ page import="connection.ConnectionProvider" %>
<%@ page import="connection.JdbcUtil" %>
<%
	request.setCharacterEncoding("UTF-8");
	String param_account = request.getParameter("param_account");
	String param_device = request.getParameter("param_device");
	String param_id = request.getParameter("param_id");
	String param_pw = request.getParameter("param_pw");
	String param_name = request.getParameter("param_name");
	String param_profile = request.getParameter("param_profile");
	
	UserInfoService userInfoService = new UserInfoService();

	JSONObject nameObj = userInfoService.CheckUserNameData(param_name);
	JSONObject signInObj = new JSONObject();

	//로그인 아이디가 있을 경우.
	if (nameObj.get("login_name") == "1")
	{
		signInObj.put("login_name", "1");
		out.print(signInObj.toString());
		/*
		String ch = param_check;
		if (param_check == ch){
			signInObj.put("check","true");
			out.print(signInObj.toString());
		}
		else
		{
			signInObj.put("check", "false");
			out.print(signInObj.toString());
		}*/
	} 
	//로그인 아이디가 없을 경우.
	else if (nameObj.get("login_name") == "0")
	{
		PreparedStatement pstmt = null;
		
		Connection conn = ConnectionProvider.getConnection(); 
		 

		pstmt = conn.prepareStatement("INSERT INTO textIsland.user (`pub_id`, `account_type`, `device_type`, `login_id`, `login_pw`, `user_name`, `max_stamina`, `stamina`, `free_day1`, `free_day2`, `free_day3`, `free_day4`, `profile_info`, `wait_time`, `3day_coupon`)"
				+ " VALUES (?, ?, ?, ?, ?, ?, '1', '1', '0', '0', '0', '0', ?, '0', '0');");
		
		String m_pub_id = UUID.randomUUID().toString().replaceAll("-", "");
		
		pstmt.setString(1, m_pub_id);
		pstmt.setString(2, param_account);
		pstmt.setString(3, param_device);
		pstmt.setString(4, param_id);
		pstmt.setString(5, param_pw);
		pstmt.setString(6, param_name);
		pstmt.setString(7, param_profile);
		
		int r = pstmt.executeUpdate();
		
		if(r == 1){
			System.out.println("-------------------SIGNUP success---------------");
		}
		else
		{
			System.out.println("---------------SIGNUP fail-------------------");
		}
						
		JdbcUtil.close(pstmt);
		JdbcUtil.close(conn);
	}
%>