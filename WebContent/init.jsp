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
<%@ page import="data.CategoryInfo" %>
<%@ page import="data.TalkInfo" %>
<%@ page import="dataList.category.RecommendInfoList"%>
<%@ page import="dataList.category.RomanceInfoList"%>
<%@ page import="dataList.category.ThrillerInfoList"%>
<%@ page import="dataList.category.NewInfoList"%>
<%@ page import="dataList.talk.RecommendTalkInfoList"%>
<%@ page import="dataList.talk.RomanceTalkInfoList"%>
<%@ page import="dataList.talk.ThrillerTalkInfoList"%>
<%@ page import="dataList.talk.NewTalkInfoList"%>
<%@ page import="service.ReadTalkInfoService" %>
<%@ page import="service.ReadCategoryInfoService" %>
<%@ page import="service.SendCategoryInfoService" %>
<%@ page import="service.SendInfoService" %>

<%
	request.setCharacterEncoding("UTF-8");
 	
	//ī�װ� ���� ��ü�� �о�ɴϴ�.
  	ReadCategoryInfoService readCategoryInfoService = 
			ReadCategoryInfoService.getInstance();
	readCategoryInfoService.ConvertDB2Data();
	
	//������ ī�װ��� ����Ʈ ����� �����ɴϴ�.
	int recommendSize = RecommendInfoList.getRecommendInfoListSize();
	int romanceSize = RomanceInfoList.getRomanceInfoListSize();
	int thrillerSize = ThrillerInfoList.getThrillerInfoListSize();
	int newSize = NewInfoList.getNewInfoListSize();

	//�� ī�װ� ������ ���� Ȯ���� ���� ����� 0���� ũ�� ����Ʈ ũ�⸦ üũ���ݴϴ�.
	if (recommendSize > 0)  
	{
		System.out.println("----------------------------------");
		System.out.println("recommendSize : " + recommendSize);
	}
	else if(recommendSize == 0)
	{
		System.out.println("- recommendSize = 0 -");
	}
	else
	{
		System.out.println("- recommendSize = null? -");
	}
	if (romanceSize > 0)  
	{
		System.out.println("----------------------------------");
		System.out.println("romanceSize : " + romanceSize);
	}
	else if(romanceSize == 0)
	{
		System.out.println("- romanceSize = 0 -");
	}
	else
	{
		System.out.println("- romanceSize = null? -");
	}
	
	if (thrillerSize > 0)  
	{
		System.out.println("----------------------------------");
		System.out.println("thrillerSize : " + thrillerSize);
	}
	else if(thrillerSize == 0)
	{
		System.out.println("- thrillerSize = 0 -");
	}
	else
	{
		System.out.println("- thrillerSize = null? -");
	}
	
	if (newSize > 0)  
	{
		System.out.println("----------------------------------");
		System.out.println("newSize : " + newSize);
	}
	else if(newSize == 0)
	{
		System.out.println("- newSize = 0 -");
	}
	else
	{
		System.out.println("- newSize = null? -");
	}
	
	//���丮 �� ���� ��ü�� �о�ɴϴ�.
  	ReadTalkInfoService readInfoService = ReadTalkInfoService.getInstance();
	readInfoService.ConvertDB2Data(); 
	
	//���� �� ����Ʈ�� ����� �����ɴϴ�.
	int romanceTalkSize = RomanceTalkInfoList.getRomanceTalkInfoListSize();
	int thrillerTalkSize = ThrillerTalkInfoList.getThrillerTalkInfoListSize();
	
	//�� �� ������ ���� Ȯ���� ���� ����� 0���� ũ�� ����Ʈ ũ�⸦ üũ���ݴϴ�.
	if (romanceTalkSize > 0) 
	{
		System.out.println("----------------------------------");
		System.out.println("RomanceTalkSize : " + romanceTalkSize);
	}
	else if(romanceTalkSize == 0)
	{
		System.out.println("- romanceTalkSize = 0 -");
	}
	else
	{
		System.out.println("- romanceTalkSize = null? -");
	}
	if (thrillerTalkSize > 0) 
	{
		System.out.println("----------------------------------");
		System.out.println("ThrillerTalkSize : " + thrillerTalkSize);
	}
	else if(thrillerTalkSize == 0)
	{
		System.out.println("- ThrillerTalkSize = 0 -");
	}
	else
	{
		System.out.println("- ThrillerTalkSize = null? -");
	}

	//json������ ������ ����� �����ϴ�.
	SendInfoService sendInfoService = new SendInfoService();
	JSONObject jsonObj = sendInfoService.ConvertData2Json();
	out.print(jsonObj.toString());
	
 %>