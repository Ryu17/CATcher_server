package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import data.ImageCover;
import dataList.image.Cover;

public class SendImageCoverService {
	
	//하나씩 받은 ImageCover를 JSONObject로 만들어줍니다.
	public JSONObject CreateCoverJSONObject(JSONObject coverObj, ImageCover imageCover) {
		//imageCover의 자료들을 하나씩 coverObj에 넣어줍니다.
		coverObj.put("name", imageCover.getName());
		coverObj.put("exist", imageCover.getExist());
			
		return coverObj;
	}
	
	//ImageCover를 하나씩 JSONObject로 만든 것을 JSONArray 에 넣어줍니다.
	public JSONArray ConvertCoverData2Json() {
		int coverSize = Cover.getImageCoverSize();

		//아래의 JSONObject들을 넣어줄 JSONArray를 만들어줍니다.
		JSONArray coverArray = new JSONArray();

		//cover 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < coverSize; i++) {
			JSONObject coverObj = new JSONObject();
							
			//리스트의 정보들을 하나씩 찾습니다.
			ImageCover imageCover = Cover.findImageCover(i);

			//JSONObject를 만들어줍니다.
			coverObj = CreateCoverJSONObject(coverObj, imageCover);

			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
	   		coverArray.add(coverObj);
		}
			
		return coverArray;
	}
}
