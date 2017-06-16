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
<%@ page import="data.CategoryInfo" %>
<%@ page import="data.TalkInfo" %>
<%@ page import="dao.UserInfoDAO" %>
<%@ page import="connection.ConnectionProvider" %>
<%@ page import="connection.JdbcUtil" %>
<%
	request.setCharacterEncoding("UTF-8");
	String param_update = request.getParameter("param_update");
	String param_user_key = request.getParameter("param_key");
	String param_order = request.getParameter("param_order");
	String param_lately = request.getParameter("param_lately");
	String param_group = request.getParameter("param_group");
	String param_msg = request.getParameter("param_msg");
	String param_free1 = request.getParameter("param_free1");
	String param_free2 = request.getParameter("param_free2");
	String param_free3 = request.getParameter("param_free3");
	String param_free4 = request.getParameter("param_free4");
	String profile_info = request.getParameter("profile_info");
	String param_stm = request.getParameter("param_stm");
	String param_m_stm = request.getParameter("param_m_stm");
	String param_wait = request.getParameter("param_wait");

	PreparedStatement pstmt = null;
	
	Connection conn = ConnectionProvider.getConnection(); 
	
	JSONObject user_update = new JSONObject();
	
	System.out.println("-----param_update-----");
	System.out.println(param_update);
	System.out.println(param_update);
	
	if(param_update.equals("lately"))
	{
		//정보 수집.
		
		pstmt = conn.prepareStatement("UPDATE textIsland.user_lately SET `lately_order`= ?, `group_id`= ?, `msg_order`= ?, `free_order`='0' WHERE `order`= ?;");
		
		pstmt.setString(1, param_lately);//
		pstmt.setString(2, param_group); //
		pstmt.setString(3, param_msg);//
		pstmt.setString(4, param_order);//
		
		int r = pstmt.executeUpdate();
		
		if(r == 1){
			System.out.println("-------------------success---------------");
		}
		else
		{
			System.out.println("---------------fail-------------------");
		}

		JdbcUtil.close(pstmt);
		JdbcUtil.close(conn);
	}
	else if(param_update.equals("free_day"))
	{
		pstmt = conn.prepareStatement("UPDATE textIsland.user SET `free_day1`= ?, `free_day2`= ?, `free_day3`= ?, `free_day4` = ? WHERE `user_key`= ?;");
		//"INSERT INTO 테이블(id, field1, field2) values (id, value1, value2) ON DUPLICATE KEY UPDATE field1=value1, field2=value2"
		
		pstmt.setString(1, param_free1);
		pstmt.setString(2, param_free2);
		pstmt.setString(3, param_free3);
		pstmt.setString(4, param_free4);
		pstmt.setString(5, param_user_key);
		
		int r = pstmt.executeUpdate();
		
		if(r == 1){
			System.out.println("-------------------success---------------");
		}
		else
		{
			System.out.println("---------------fail-------------------");
		}

		JdbcUtil.close(pstmt);
		JdbcUtil.close(conn);
	}
	else if(param_update.equals("image"))
	{
		pstmt = conn.prepareStatement("UPDATE textIsland.user SET `profile_info`= ? WHERE `user_key`= ?;");
		//"INSERT INTO 테이블(id, field1, field2) values (id, value1, value2) ON DUPLICATE KEY UPDATE field1=value1, field2=value2"
		
		pstmt.setString(1, profile_info);	
		pstmt.setString(2, param_user_key);
		
		int r = pstmt.executeUpdate();
		
		if(r == 1){
			System.out.println("-------------------success---------------");
		}
		else
		{
			System.out.println("---------------fail-------------------");
		}

		JdbcUtil.close(pstmt);
		JdbcUtil.close(conn);
	}
	else if(param_update.equals("stamina"))
	{
		pstmt = conn.prepareStatement("UPDATE textIsland.user SET `stamina`= ?, `max_stamina`= ?, `wait_time` = ? WHERE `user_key`= ?;");
		//"INSERT INTO 테이블(id, field1, field2) values (id, value1, value2) ON DUPLICATE KEY UPDATE field1=value1, field2=value2"
		
		pstmt.setString(1, param_stm);	
		pstmt.setString(2, param_m_stm);
		pstmt.setString(3, param_wait);
		pstmt.setString(4, param_user_key);
		
		int r = pstmt.executeUpdate();
		
		if(r == 1){
			System.out.println("-------------------success---------------");
		}
		else
		{
			System.out.println("---------------fail-------------------");
		}

		JdbcUtil.close(pstmt);
		JdbcUtil.close(conn);
	}
	else		
	{
		System.out.println("----- param_update == null -----");			
	}
	
%>