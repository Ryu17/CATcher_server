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
<%@ page import="org.json.simple.*"%>


<%
	request.setCharacterEncoding("UTF-8");
	PreparedStatement pstmt = null;
	Connection conn = ConnectionProvider.getConnection(); 
	
	//JSONObject latelyInObj = new JSONObject();
	
	JSONArray arrayLately = new JSONArray();
	
	String user_key = request.getParameter("param_key");
	if (user_key == null){
		//pstmt = conn.prepareStatement("SELECT * FROM textIsland.user_lately WHERE `user_key` = 1");
	}
	else
	{
		pstmt = conn.prepareStatement("SELECT * FROM textIsland.user_lately WHERE `user_key` = ?");
		pstmt.setString(1, user_key);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			JSONObject obj = new JSONObject();
			obj.put("order", rs.getInt("order"));
			obj.put("user_key", rs.getInt("user_key"));
			obj.put("lately_order", rs.getInt("lately_order"));
			obj.put("group_id", rs.getInt("group_id"));
			obj.put("msg_order", rs.getInt("msg_order"));
			obj.put("free_order", rs.getInt("free_order"));
			
			if(obj != null)
				arrayLately.add(obj);
			
			System.out.println("---user_lately_info----");
		}
	}
	
	//SendInfoService sendInfoService = new SendInfoService();
	//JSONObject jsonObj = sendInfoService.ConvertData2Json();
	//out.print(jsonObj.toString());
	
	//JSONObject jsonObj = arrayLately;
	out.print(arrayLately.toString());
	
	JdbcUtil.close(pstmt);
	JdbcUtil.close(conn);
%>