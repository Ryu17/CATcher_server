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
<%@ page import="connection.ConnectionProvider" %>
<%@ page import="connection.JdbcUtil" %>
<%
	request.setCharacterEncoding("UTF-8");
	String param_cs = request.getParameter("param_cs");
	String param_id = request.getParameter("param_id");
	String param_email = request.getParameter("param_email");
	String param_subject = request.getParameter("param_subject");
	String param_contents = request.getParameter("param_contents");
	String param_date = request.getParameter("param_date");

	PreparedStatement pstmt = null;
	
	Connection conn = ConnectionProvider.getConnection(); 
	
	JSONObject user_update = new JSONObject();
		
	if(param_cs.equals("cs"))
	{
		//정보 수집.
		
		pstmt = conn.prepareStatement("INSERT INTO textIsland.cs VALUES (?, ?, ?, ?, ?);");
		
		pstmt.setString(1, param_email);
		pstmt.setString(2, param_id);
		pstmt.setString(3, param_subject);
		pstmt.setString(4, param_contents);
		pstmt.setString(5, param_date);
		
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
	
%>