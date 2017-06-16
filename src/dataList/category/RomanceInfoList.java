package dataList.category;

import java.util.ArrayList;
import data.CategoryInfo;

//Romance(로맨스) 카테고리들을 저장하는 클래스입니다. 
public class RomanceInfoList {
	static ArrayList<CategoryInfo> array_romanceInfoList = new ArrayList<CategoryInfo>();
	
	//로맨스와 관련된 CategoryInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addRomanceInfo(CategoryInfo categoryInfo)
	{
		array_romanceInfoList.add(categoryInfo);
	}
		 
	public static CategoryInfo findRomanceInfo(int category_order)
	{
		return array_romanceInfoList.get(category_order);
	}
	 
	public static int getRomanceInfoListSize()
	{
		return array_romanceInfoList.size();
	}
	
	public static void clearRomanceInfoList()
	{
		array_romanceInfoList.clear();
	}
 
	 
}
