package service;

import dataList.talk.RecommendTalkInfoList;
import dataList.talk.RomanceTalkInfoList;
import dataList.talk.ThrillerTalkInfoList;
import dataList.talk.NewTalkInfoList;
import java.lang.System;

import data.CategoryInfo;
import data.TalkInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//톡 정보들을 JSON형태로 만드는 클래스입니다.
public class SendTalkInfoService {
	
	//하나씩 받은 talkInfo를 JSONObject로 만들어줍니다.
	public JSONObject CreateTalkJSONObject(JSONObject talkObj, TalkInfo talkInfo) {
		//talkInfo의 자료들을 하나씩 talkObj에 넣어줍니다.
		talkObj.put("category_id", talkInfo.getCategory_id());
		talkObj.put("group_id", talkInfo.getGroup_id());
		talkObj.put("id", talkInfo.getId());
		talkObj.put("msg_order", talkInfo.getMsg_order());
		talkObj.put("delay", talkInfo.getDelay());
		talkObj.put("speaker", talkInfo.getSpeaker());
		talkObj.put("msg_view_point", talkInfo.getMsg_view_point());
		talkObj.put("msg_type", talkInfo.getMsg_type());
		talkObj.put("msg_data", talkInfo.getMsg_data());
		talkObj.put("stm_check", talkInfo.getStm_check());
		talkObj.put("profile_img", talkInfo.getProfile_img());
		
		return talkObj;
	}
	
	//저장해놓은 TalkInfo들을 Json형태로 만들어줍니다.
	public JSONArray ConvertTalkData2Json() {
		int recommendTalkSize = RecommendTalkInfoList.getRecommendTalkInfoListSize();
		int romanceTalkSize = RomanceTalkInfoList.getRomanceTalkInfoListSize();
		int thrillerTalkSize = ThrillerTalkInfoList.getThrillerTalkInfoListSize();
		int newTalkSize = NewTalkInfoList.getNewTalkInfoListSize();

		//JSONObject들을 넣어줄 JSONArray 를 만듭니다.
		JSONArray talkArray = new JSONArray();

		//테스트 출력.
		//System.out.println("start printing recommend talk size");	

		//recommendTalkList의 크기만큼 반복합니다.
		for (int i = 0; i < recommendTalkSize; i++) {
			JSONObject talkObj = new JSONObject();
			
			//하나씩 recommendTalkInfo를 찾습니다.
			TalkInfo talkInfo = RecommendTalkInfoList.findRecommendTalkInfo(i);
			
			//(JSONObject만들어줌.)
			talkObj = CreateTalkJSONObject(talkObj, talkInfo);
    		
			//JSONArray에 talkObj를 넣어줍니다.
			talkArray.add(talkObj);
		}
		
		//테스트 출력.
		//System.out.println("start printing romance talk size");

		//romanceTalkList의 크기만큼 반복합니다.
		for (int i = 0; i < romanceTalkSize; i++) {
			JSONObject talkObj = new JSONObject();

			//하나씩 romanceTalkInfo를 찾습니다.
			TalkInfo talkInfo = RomanceTalkInfoList.findRomanceTalkInfo(i);
			
			//(JSONObject만들어줌.)
			talkObj = CreateTalkJSONObject(talkObj, talkInfo);
			
			//JSONArray에 talkObj를 넣어줍니다.
			talkArray.add(talkObj);
		}
		
		//테스트 출력.
		//System.out.println("start printing thriller category size");

		//thrillerTalkList의 크기만큼 반복합니다.
		for (int i = 0; i < thrillerTalkSize; i++) {
			JSONObject talkObj = new JSONObject();

			//하나씩 thrillerTalkInfo를 찾습니다.
			TalkInfo talkInfo = ThrillerTalkInfoList.findThrillerTalkInfo(i);
			
			//(JSONObject만들어줌.)
			talkObj = CreateTalkJSONObject(talkObj, talkInfo);
			
			//JSONArray에 talkObj를 넣어줍니다.
			talkArray.add(talkObj);
		}
		
		//테스트 출력.
		//System.out.println("start printing new category size");

		//newTalkList의 크기만큼 반복합니다.
		for (int i = 0; i < newTalkSize; i++) {
			JSONObject talkObj = new JSONObject();
			
			//하나씩 newTalkInfo를 찾습니다.
			TalkInfo talkInfo = NewTalkInfoList.findNewTalkInfo(i);
			
			//(JSONObject만들어줌.)
			talkObj = CreateTalkJSONObject(talkObj, talkInfo);
    		
			//JSONArray에 talkObj를 넣어줍니다.
			talkArray.add(talkObj);
		}
		return talkArray;
	}
}