package dataList.category;

import java.util.ArrayList;
import data.CategoryInfo;

//New(신작) 카테고리들을 저장하는 클래스입니다.
public class NewInfoList {
	static ArrayList<CategoryInfo> array_newInfoList = new ArrayList<CategoryInfo>();
	
	//신작과 관련된 CategoryInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	

	public static void addNewInfo(CategoryInfo categoryInfo)
	{
		array_newInfoList.add(categoryInfo);
	}
		 
	public static CategoryInfo findNewInfo(int category_order)
	{
		return array_newInfoList.get(category_order);
	}
	 
	public static int getNewInfoListSize()
	{
		return array_newInfoList.size();
	}
	
	public static void clearNewInfoList()
	{
		array_newInfoList.clear();
	}
 
	 
}
