package dataList.talk_title;

import java.util.ArrayList;
import data.ListInfo;

// 전체 타이틀 목록을 저장하는 클래스입니다.
public class TalkTitleList {
	static ArrayList<ListInfo> array_titleList = new ArrayList<ListInfo>();
	
	public static void addListInfo(ListInfo listInfo)
	{
		array_titleList.add(listInfo);
	}
		 
	public static ListInfo findListInfo(int id)
	{
		return array_titleList.get(id);
	}
	 
	public static int getListInfoSize()
	{
		return array_titleList.size();
	}
	
	public static void clearListInfo()
	{
		array_titleList.clear();
	}
 
	 
}
