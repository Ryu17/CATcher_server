package service;

import java.lang.System;

import data.CommentInfo;
import dataList.comment.CommentInfoList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//리스트 정보들을 JSON형태로 만드는 클래스입니다.
public class SendCommentInfoService {
	
	//commentInfo를 하나씩 받아서 JSONObject를 생성합니다.
	public JSONObject CreateListJSONObject(JSONObject commentObj, CommentInfo commentInfo) {
		commentObj.put("group_id", commentInfo.getGroup_id());
		commentObj.put("imgname", commentInfo.getImgname());
		commentObj.put("nickname", commentInfo.getNickname());
		commentObj.put("comments", commentInfo.getComments());
		commentObj.put("date", commentInfo.getDate());
		
		return commentObj;
	}
	
	//CommentInfo를 하나씩 JSONObject로 만든 것을 JSONArray 에 넣어줍니다.
	public JSONArray ConvertListData2Json() {
		int commentListSize = CommentInfoList.getCommentInfoListSize();

		//아래의 JSONObject들을 넣어줄 JSONArray를 만들어줍니다.
		JSONArray commentArray = new JSONArray();

		//titleList 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < commentListSize; i++) {
			JSONObject commentObj = new JSONObject();
							
			//리스트의 정보들을 하나씩 찾습니다.
			CommentInfo listInfo = CommentInfoList.findCommentInfo(i);

			//JSONObject를 만들어줍니다.
			commentObj = CreateListJSONObject(commentObj, listInfo);

			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
	    	commentArray.add(commentObj);
		}
			
		return commentArray;
	}
}
