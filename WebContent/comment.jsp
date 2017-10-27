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
 	
	// index�� 1�̸� �ش� group_id�� ��� ������ �о�ɴϴ�.
	if (param_index.equals("1"))
	{
		//��� ���� ��ü�� �о�ɴϴ�.
	  	ReadCommentInfoService readCommentInfoService = 
				ReadCommentInfoService.getInstance();
		readCommentInfoService.ConvertDB2Data(param_group_id);
		
		//json������ ������ ����� �����ϴ�.
		SendCommentService sendCommentService = new SendCommentService();
		JSONObject jsonObj = sendCommentService.ConvertData2Json();
		out.print(jsonObj.toString());
	}
	
	// index�� 2�̸� �ش� group_id���� update �Ǵ� insert�� �մϴ�.
	else if (param_index.equals("2"))
	{
		SendCommentService sendCommentService = new SendCommentService();
		
		sendCommentService.CommentEnrollment(param_group_id, param_imgname, param_nickname,
											 param_comments, param_date);
	}
	
 %>