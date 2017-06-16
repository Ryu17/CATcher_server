package dataList.category;

import java.util.ArrayList;
import data.CategoryInfo;

//Recommend(추천) 카테고리들을 저장하는 클래스입니다.
public class RecommendInfoList {
	static ArrayList<CategoryInfo> array_recommendInfoList = new ArrayList<CategoryInfo>();
	
	//추천작과 관련된 CategoryInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addRecommendInfo(CategoryInfo categoryInfo)
	{
		array_recommendInfoList.add(categoryInfo);
	}
		 
	public static CategoryInfo findRecommendInfo(int category_order)
	{
		return array_recommendInfoList.get(category_order);
	}
	 
	public static int getRecommendInfoListSize()
	{
		return array_recommendInfoList.size();
	}
	
	public static void clearRecommendInfoList()
	{
		array_recommendInfoList.clear();
	}
}
