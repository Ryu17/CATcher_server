package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import data.ImageList;
import dataList.image.List;

public class SendImageListService {
	
	//하나씩 받은 ImageList를 JSONObject로 만들어줍니다.
	public JSONObject CreateListJSONObject(JSONObject listObj, ImageList imageList) {
		//imageList의 자료들을 하나씩 ListObj에 넣어줍니다.
		listObj.put("name", imageList.getName());
		listObj.put("exist", imageList.getExist());
				
		return listObj;
	}
		
	//ImageList를 하나씩 JSONObject로 만든 것을 JSONArray 에 넣어줍니다.
	public JSONArray ConvertListData2Json() {
		int listSize = List.getImageListSize();

		//아래의 JSONObject들을 넣어줄 JSONArray를 만들어줍니다.
		JSONArray listArray = new JSONArray();

		//List 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < listSize; i++) {
			JSONObject listObj = new JSONObject();
								
			//리스트의 정보들을 하나씩 찾습니다.
			ImageList imageList = List.findImageList(i);

			//JSONObject를 만들어줍니다.
			listObj = CreateListJSONObject(listObj, imageList);

			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
		  	listArray.add(listObj);
		}
				
		return listArray;
	}
}
