package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import data.ImageSpeaker;
import dataList.image.Speaker;

public class SendImageSpeakerService {
	
	//하나씩 받은 ImageSpeaker를 JSONObject로 만들어줍니다.
	public JSONObject CreateSpeakerJSONObject(JSONObject speakerObj, ImageSpeaker imageSpeaker) {
		//imageSpeaker의 자료들을 하나씩 SpeakerObj에 넣어줍니다.
		speakerObj.put("name", imageSpeaker.getName());
		speakerObj.put("exist", imageSpeaker.getExist());
			
		return speakerObj;
	}
	
	//ImageSpeaker를 하나씩 JSONObject로 만든 것을 JSONArray 에 넣어줍니다.
	public JSONArray ConvertSpeakerData2Json() {
		int speakerSize = Speaker.getImageSpeakerSize();

		//아래의 JSONObject들을 넣어줄 JSONArray를 만들어줍니다.
		JSONArray speakerArray = new JSONArray();

		//Speaker 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < speakerSize; i++) {
			JSONObject speakerObj = new JSONObject();
							
			//리스트의 정보들을 하나씩 찾습니다.
			ImageSpeaker imageSpeaker = Speaker.findImageSpeaker(i);

			//JSONObject를 만들어줍니다.
			speakerObj = CreateSpeakerJSONObject(speakerObj, imageSpeaker);

			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
	   		speakerArray.add(speakerObj);
		}
			
		return speakerArray;
	}

}
