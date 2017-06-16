package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.SendCategoryInfoService;
import service.SendTalkInfoService;

//카테고리와 톡 정보로 만들어진 JSON을 하나로 합치는 클래스입니다.
public class SendInfoService {
	public JSONObject ConvertData2Json() {		
		
		//카테고리와 톡 JSON 을 넣어줄 JSONObject를 만들어줍니다.
		JSONObject dataListObject = new JSONObject();
		
		//SendCategoryInfoService를 통해서 만들어 놓은 CategoryJsonArray 를 가져옵니다.
		SendCategoryInfoService sendCategoryInfoService = new SendCategoryInfoService();
		JSONArray categoryJsonArray = sendCategoryInfoService.ConvertCategoryData2Json();
		
		//SendTalkInfoService를 통해서 만들어 놓은 TalkJsonArray 를 가져옵니다.
		SendTalkInfoService sendTalkInfoService = new SendTalkInfoService();
		JSONArray talkJsonArray = sendTalkInfoService.ConvertTalkData2Json();
		
		//Category JsonArray 와 Talk JsonArray 를 dataListObject 에 넣어줍니다.
		dataListObject.put("Category", categoryJsonArray);
		dataListObject.put("Talk", talkJsonArray);
		
		//최종 만들어진 dataListObject를 반환해줍니다.
		return dataListObject;
	}	
}
