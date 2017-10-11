package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import data.ImageTalk;
import dataList.image.Talk;

public class SendImageTalkService {
	
	//하나씩 받은 ImageTalk를 JSONObject로 만들어줍니다.
	public JSONObject CreateTalkJSONObject(JSONObject talkObj, ImageTalk imageTalk) {
		//imageTalk의 자료들을 하나씩 TalkObj에 넣어줍니다.
		talkObj.put("name", imageTalk.getName());
		talkObj.put("exist", imageTalk.getExist());
			
		return talkObj;
	}
	
	//ImageTalk를 하나씩 JSONObject로 만든 것을 JSONArray 에 넣어줍니다.
	public JSONArray ConvertTalkData2Json() {
		int talkSize = Talk.getImageTalkSize();

		//아래의 JSONObject들을 넣어줄 JSONArray를 만들어줍니다.
		JSONArray talkArray = new JSONArray();

		//Talk 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < talkSize; i++) {
			JSONObject talkObj = new JSONObject();
							
			//리스트의 정보들을 하나씩 찾습니다.
			ImageTalk imageTalk = Talk.findImageTalk(i);

			//JSONObject를 만들어줍니다.
			talkObj = CreateTalkJSONObject(talkObj, imageTalk);

			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
	   		talkArray.add(talkObj);
		}
			
		return talkArray;
	}
}
