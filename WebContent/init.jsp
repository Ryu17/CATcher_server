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
 	
	//카테고리 정보 전체를 읽어옵니다.
  	ReadCategoryInfoService readCategoryInfoService = 
			ReadCategoryInfoService.getInstance();
	readCategoryInfoService.ConvertDB2Data();
	
	//각각의 카테고리의 리스트 사이즈를 가져옵니다.
	int recommendSize = RecommendInfoList.getRecommendInfoListSize();
	int romanceSize = RomanceInfoList.getRomanceInfoListSize();
	int thrillerSize = ThrillerInfoList.getThrillerInfoListSize();
	int newSize = NewInfoList.getNewInfoListSize();

	//각 카테고리 정보의 개수 확인을 위해 사이즈가 0보다 크면 리스트 크기를 체크해줍니다.
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
	
	//스토리 톡 정보 전체를 읽어옵니다.
  	ReadTalkInfoService readInfoService = ReadTalkInfoService.getInstance();
	readInfoService.ConvertDB2Data(); 
	
	//각각 톡 리스트의 사이즈를 가져옵니다.
	int romanceTalkSize = RomanceTalkInfoList.getRomanceTalkInfoListSize();
	int thrillerTalkSize = ThrillerTalkInfoList.getThrillerTalkInfoListSize();
	
	//각 톡 정보의 개수 확인을 위해 사이즈가 0보다 크면 리스트 크기를 체크해줍니다.
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

	//json형식의 정보를 출력해 보냅니다.
	SendInfoService sendInfoService = new SendInfoService();
	JSONObject jsonObj = sendInfoService.ConvertData2Json();
	out.print(jsonObj.toString());
	
 %>