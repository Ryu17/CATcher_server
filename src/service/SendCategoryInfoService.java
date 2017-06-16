package service;

import java.lang.System;

import dataList.category.RecommendInfoList;
import dataList.category.ThrillerInfoList;
import dataList.category.RomanceInfoList;
import dataList.category.NewInfoList;
import data.CategoryInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//카테고리 정보들을 JSON형태로 만드는 클래스입니다.
public class SendCategoryInfoService {
	
	//CategoryInfo를 하나씩 받아서 JSONObject를 생성합니다.
	public JSONObject CreateCategoryJSONObject(JSONObject categoryObj, CategoryInfo categoryInfo) {
		categoryObj.put("category_id", categoryInfo.getCategory_id());
		categoryObj.put("category_order", categoryInfo.getCategory_order());
		categoryObj.put("group_id", categoryInfo.getGroup_id());
		categoryObj.put("author", categoryInfo.getAuthor());
		categoryObj.put("img_id", categoryInfo.getImg_id());
		categoryObj.put("title", categoryInfo.getTitle());
		categoryObj.put("view_count", categoryInfo.getView_count());
		categoryObj.put("like_count", categoryInfo.getLike_count());
		
		return categoryObj;
	}
	
	//CategoryInfo를 하나씩 JSONObject로 만든 것을 JSONArray 에 넣어줍니다.
	public JSONArray ConvertCategoryData2Json() {
		int recommendCategorySize = RecommendInfoList.getRecommendInfoListSize();
		int romanceCategorySize = RomanceInfoList.getRomanceInfoListSize();
		int thrillerCategorySize = ThrillerInfoList.getThrillerInfoListSize();
		int newCategorySize = NewInfoList.getNewInfoListSize();

		//아래의 JSONObject들을 넣어줄 JSONArray를 만들어줍니다.
		JSONArray categoryArray = new JSONArray();

		//테스트 출력.
		//System.out.println("start printing recommend category size");

		//recommendCategory 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < recommendCategorySize; i++) {
			JSONObject categoryObj = new JSONObject();
			
			//Recommend 카테고리의 정보들을 하나씩 찾습니다.
			CategoryInfo categoryInfo = RecommendInfoList.findRecommendInfo(i);
			
			//JSONObject를 만들어줍니다.
			categoryObj = CreateCategoryJSONObject(categoryObj, categoryInfo);
			
			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
    		categoryArray.add(categoryObj);
		}
		
		//테스트 출력.
		//System.out.println("start printing romance category size");

		//romanceCategory 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < romanceCategorySize; i++) {
			JSONObject categoryObj = new JSONObject();

			//Romance 카테고리의 정보들을 하나씩 찾습니다.
			CategoryInfo categoryInfo = RomanceInfoList.findRomanceInfo(i);
			
			//JSONObject를 만들어줍니다.
			categoryObj = CreateCategoryJSONObject(categoryObj, categoryInfo);

			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
    		categoryArray.add(categoryObj);
		}
		
		//테스트 출력.
		//System.out.println("start printing thriller category size");

		//thrillerCategory 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < thrillerCategorySize; i++) {
			JSONObject categoryObj = new JSONObject();

			//Thriller 카테고리의 정보들을 하나씩 찾습니다.
			CategoryInfo categoryInfo = ThrillerInfoList.findThrillerInfo(i);
			
			//JSONObject를 만들어줍니다.
			categoryObj = CreateCategoryJSONObject(categoryObj, categoryInfo);
    		
			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
    		categoryArray.add(categoryObj);
		}
		
		//테스트 출력.
		//System.out.println("start printing new category size");

		//newCategory 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < newCategorySize; i++) {
			JSONObject categoryObj = new JSONObject();
			
			//New 카테고리의 정보들을 하나씩 찾습니다.
			CategoryInfo categoryInfo = NewInfoList.findNewInfo(i);

			//JSONObject를 만들어줍니다.
			categoryObj = CreateCategoryJSONObject(categoryObj, categoryInfo);

			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
    		categoryArray.add(categoryObj);
		}
		return categoryArray;
	}
}
