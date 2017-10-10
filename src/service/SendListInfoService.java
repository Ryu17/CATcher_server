package service;

import java.lang.System;

import data.ListInfo;
import dataList.talk_title.TalkTitleList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//리스트 정보들을 JSON형태로 만드는 클래스입니다.
public class SendListInfoService {
	
	//listInfo를 하나씩 받아서 JSONObject를 생성합니다.
	public JSONObject CreateListJSONObject(JSONObject listObj, ListInfo listInfo) {
		listObj.put("id", listInfo.getId());
		listObj.put("group_id", listInfo.getGroup_id());
		listObj.put("author", listInfo.getAuthor());
		listObj.put("title", listInfo.getTitle());
		listObj.put("view_count", listInfo.getView_count());
		listObj.put("like_count", listInfo.getLike_count());
		listObj.put("unlike_count", listInfo.getUnlike_count());
		listObj.put("category_id", listInfo.getCategory_id());
		listObj.put("date", listInfo.getDate());
		listObj.put("continuity", listInfo.getCont());
		listObj.put("synopsis", listInfo.getSynopsis());
		listObj.put("nologinrecommend",listInfo.getNologinrecommend());
		listObj.put("hashtag1",listInfo.getHashtag1());
		listObj.put("hashtag2",listInfo.getHashtag2());
		listObj.put("hashtag3",listInfo.getHashtag3());
		listObj.put("hashtag4",listInfo.getHashtag4());
		listObj.put("hashtag5",listInfo.getHashtag5());
		
		return listObj;
	}
	
	//ListInfo를 하나씩 JSONObject로 만든 것을 JSONArray 에 넣어줍니다.
	public JSONArray ConvertListData2Json() {
		int titleListSize = TalkTitleList.getListInfoSize();

		//아래의 JSONObject들을 넣어줄 JSONArray를 만들어줍니다.
		JSONArray listArray = new JSONArray();

		//titleList 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < titleListSize; i++) {
			JSONObject listObj = new JSONObject();
						
			//리스트의 정보들을 하나씩 찾습니다.
			ListInfo listInfo = TalkTitleList.findListInfo(i);

			//JSONObject를 만들어줍니다.
			listObj = CreateListJSONObject(listObj, listInfo);

			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
    		listArray.add(listObj);
		}
		
		return listArray;
	}
}
