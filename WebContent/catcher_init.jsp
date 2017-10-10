	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLEncoder" %>
<%@	page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@	page import="java.lang.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.google.gson.*" %>
<%@ page import="org.json.simple.*" %>
<%@ page import="connection.ConnectionProvider" %>
<%@ page import="connection.JdbcUtil" %>
<%
	request.setCharacterEncoding("UTF-8");
	// test log
	PreparedStatement pstmt = null;
	Statement stmt = null;
	Connection conn = ConnectionProvider.getConnection();
	
	pstmt = conn.prepareStatement("SELECT DATE_FORMAT(now(), '%Y-%m-%d');");
	stmt = conn.createStatement();
	
	ResultSet rs = pstmt.executeQuery();
	
	Calendar date = Calendar.getInstance();
	String strTime = date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String now = dateFormat.format(date.getTime());
	long millis = date.getTimeInMillis();
	
	JSONObject timeInObj = new JSONObject();
	System.out.println("------------------- SELECT 1 DATE -------------------");
	System.out.println(strTime);
	
	System.out.println("------------------- SELECT 2 DATE -------------------");
	System.out.println(now);
	
	System.out.println("------------------- SELECT 2 DATE -------------------");
	System.out.println(millis);
	
	while(rs.next()){
	//	key = rs.getInt("user_key");
		System.out.println("------------------- WHILE user_key -------------------");
	//	System.out.println(key);
	}
	timeInObj.put("time_now", now);
	timeInObj.put("time_millis", millis);
	//timeInObj.put("month", "0");
	//timeInObj.put("day", "0");
	
	out.print(timeInObj.toString());
%>