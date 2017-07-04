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
<%@ page import="data.LikeInfo" %>
<%@ page import="dao.LikeInfoDAO" %>
<%@ page import="service.LikeInfoService" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	// 1�̸� �α��� �� user_key�� �ش� ���丮 group_id�� ���ƿ並 �������� ��ȸ
	// 2�̸� �α��� �� user_key�� �ش� ���丮 group_id�� ���ƿ� ������ like_count++
	// 3�̸� �α��� �� user_key�� �ش� ���丮 group_id�� ���ƿ� ����ϰ� like_count--
	// 4�̸� �ش� ���丮 group_id�� ���� Ƚ�� view_count++
	String param_index = request.getParameter("param_index");
	
	LikeInfoService likeInfoService = new LikeInfoService();
	
	if (param_index.equals("1"))
	{
		String param_user_key = request.getParameter("param_user_key");
		String param_group_id = request.getParameter("param_group_id");

		JSONObject likeObj = new JSONObject();
		
		likeObj = likeInfoService.CheckLikeData(param_user_key, param_group_id);
		
		out.print(likeObj.toString());
	}
	
	else if (param_index.equals("2"))
	{
		String param_user_key = request.getParameter("param_user_key");
		String param_group_id = request.getParameter("param_group_id");
		
		likeInfoService.SumLikeData(param_user_key, param_group_id);
	}
	
	else if (param_index.equals("3"))
	{
		String param_user_key = request.getParameter("param_user_key");
		String param_group_id = request.getParameter("param_group_id");
		
		likeInfoService.DifLikeData(param_user_key, param_group_id);
	}
	
	else if (param_index.equals("4"))
	{
		String param_group_id = request.getParameter("param_group_id");
		
		likeInfoService.AddViewCount(param_group_id);
	}
		
 %>