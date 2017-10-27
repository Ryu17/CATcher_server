package dataList.tutorial;

import java.util.ArrayList;
import data.TutoInfo;

public class TutoInfoList {
	static ArrayList<TutoInfo> array_tutoInfo = new ArrayList<TutoInfo>();
	
	public static void addTutoInfo(TutoInfo tutoInfo)
	{
		array_tutoInfo.add(tutoInfo);
	}
	
	public static TutoInfo findTutoInfo(int id)
	{
		return array_tutoInfo.get(id);
	}
	
	public static int getTutoInfoSize()
	{
		return array_tutoInfo.size();
	}
	
	public static void clearTutoInfo()
	{
		array_tutoInfo.clear();
	}
}
