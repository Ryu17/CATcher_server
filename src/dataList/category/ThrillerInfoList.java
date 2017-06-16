package dataList.category;

import java.util.ArrayList;
import data.CategoryInfo;

//Thriller(스릴러) 카테고리들을 저장하는 클래스입니다. 
public class ThrillerInfoList {
	static ArrayList<CategoryInfo> array_thrillerInfoList = new ArrayList<CategoryInfo>();
	
	//스릴러와 관련된 CategoryInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addThrillerInfo(CategoryInfo categoryInfo)
	{
		array_thrillerInfoList.add(categoryInfo);
	}
		 
	public static CategoryInfo findThrillerInfo(int category_order)
	{
		return array_thrillerInfoList.get(category_order);
	}
	 
	public static int getThrillerInfoListSize()
	{
		return array_thrillerInfoList.size();
	}
	
	public static void clearThrillerInfoList()
	{
		array_thrillerInfoList.clear();
	}
 
	 
}