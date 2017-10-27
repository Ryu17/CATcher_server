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
<%@ page import="data.CommentInfo" %>
<%@ page import="service.ReadCommentInfoService" %>
<%@ page import="service.SendCommentInfoService" %>
<%@ page import="service.SendCommentService" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	String param_index = request.getParameter("param_index");
	String param_group_id = request.getParameter("param_group_id");
	String param_imgname = request.getParameter("param_imgname");
	String param_nickname = request.getParameter("param_nickname");
	String param_comments = request.getParameter("param_comments");
	String param_date = request.getParameter("param_date");
 	
	// index가 1이면 해당 group_id의 댓글 정보를 읽어옵니다.
	if (param_index.equals("1"))
	{
		//댓글 정보 전체를 읽어옵니다.
	  	ReadCommentInfoService readCommentInfoService = 
				ReadCommentInfoService.getInstance();
		readCommentInfoService.ConvertDB2Data(param_group_id);
		
		//json형식의 정보를 출력해 보냅니다.
		SendCommentService sendCommentService = new SendCommentService();
		JSONObject jsonObj = sendCommentService.ConvertData2Json();
		out.print(jsonObj.toString());
	}
	
	// index가 2이면 해당 group_id에서 update 또는 insert를 합니다.
	else if (param_index.equals("2"))
	{
		SendCommentService sendCommentService = new SendCommentService();
		
		sendCommentService.CommentEnrollment(param_group_id, param_imgname, param_nickname,
											 param_comments, param_date);
	}
	
 %>