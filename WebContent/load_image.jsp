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
<%@ page import="data.ImageCover" %>
<%@ page import="data.ImageList" %>
<%@ page import="data.ImageSpeaker" %>
<%@ page import="data.ImageTalk" %>
<%@ page import="service.ReadImageCoverService" %>
<%@ page import="service.ReadImageListService" %>
<%@ page import="service.ReadImageSpeakerService" %>
<%@ page import="service.ReadImageTalkService" %>
<%@ page import="service.SendImageCoverService" %>
<%@ page import="service.SendImageListService" %>
<%@ page import="service.SendImageSpeakerService" %>
<%@ page import="service.SendImageTalkService" %>
<%@ page import="service.SendImageService" %>


<%
	request.setCharacterEncoding("UTF-8");
	
	// 1: image_cover, 2: image_list, 3: image_speaker, 4: image_talk
	String param_index = request.getParameter("param_index");
 	
	if (param_index.equals("1"))
	{
		// cover���� ���̴� �̹��� ���� ��ü�� �о�ɴϴ�.
	  	ReadImageCoverService readImageCoverService = 
				ReadImageCoverService.getInstance();
		readImageCoverService.ConvertDB2Data();
	}
	else if (param_index.equals("2"))
	{
		// list���� ���̴� �̹��� ���� ��ü�� �о�ɴϴ�.
	  	ReadImageListService readImageListService = 
				ReadImageListService.getInstance();
		readImageListService.ConvertDB2Data();
	}
	else if (param_index.equals("3"))
	{
		// talk���� ���̴� speaker �̹��� ���� ��ü�� �о�ɴϴ�.
	  	ReadImageSpeakerService readImageSpeakerService = 
				ReadImageSpeakerService.getInstance();
		readImageSpeakerService.ConvertDB2Data();
	}
	else if (param_index.equals("4"))
	{
		// talk���� ���̴� background �̹��� ���� ��ü�� �о�ɴϴ�.
	  	ReadImageTalkService readImageTalkService = 
				ReadImageTalkService.getInstance();
		readImageTalkService.ConvertDB2Data();
	}
	else
	{
		System.out.println("IMAGE LOAD INDEX ERROR");
	}

	//json������ ������ ����� �����ϴ�.
	SendImageService sendImageService = new SendImageService();
	JSONObject jsonObj = sendImageService.ConvertData2Json(param_index);
	out.print(jsonObj.toString());


 %>