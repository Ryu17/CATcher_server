package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.SendListInfoService;
import service.SendTalkInfoService;

//리스트와 톡 정보로 만들어진 JSON을 하나로 합치는 클래스입니다.
public class SendInfoService {
	public JSONObject ConvertData2Json(String param_index) {		

		//리스트와 톡 JSON 을 넣어줄 JSONObject를 만들어줍니다.
		JSONObject dataListObject = new JSONObject();
		
		if (param_index.equals("1"))
		{
			//SendListInfoService를 통해서 만들어 놓은 ListJsonArray 를 가져옵니다.
			SendListInfoService sendListInfoService = new SendListInfoService();
			JSONArray listJsonArray = sendListInfoService.ConvertListData2Json();
			
			//Title list JsonArray 를 dataListObject 에 넣어줍니다.
			dataListObject.put("Title", listJsonArray);
		}
		else if (param_index.equals("2"))
		{
			//SendTalkInfoService를 통해서 만들어 놓은 TalkJsonArray 를 가져옵니다.
			SendTalkInfoService sendTalkInfoService = new SendTalkInfoService();
			JSONArray talkJsonArray = sendTalkInfoService.ConvertTalkData2Json();
			
			//Talk JsonArray 를 dataListObject 에 넣어줍니다.
			dataListObject.put("Talk", talkJsonArray);
		}
		
		//최종 만들어진 dataListObject를 반환해줍니다.
		return dataListObject;
	}	
}
