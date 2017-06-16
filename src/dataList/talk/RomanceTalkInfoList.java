package dataList.talk;

import java.util.ArrayList;

import data.TalkInfo;

//Romance(로맨스) 톡들을 저장하는 클래스입니다.
public class RomanceTalkInfoList {
	static ArrayList<TalkInfo> array_romanceTalkInfoList = new ArrayList<TalkInfo>();

	//로맨스와 관련된 TalkInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addRomanceTalkInfo(TalkInfo talkInfo)
	{
		array_romanceTalkInfoList.add(talkInfo);
	}
	 
	public static TalkInfo findRomanceTalkInfo(int ti_id)
	{
		return array_romanceTalkInfoList.get(ti_id);
	}
	 
	public static int getRomanceTalkInfoListSize()
	{
		return array_romanceTalkInfoList.size();
	}
	 
	public static void clearRomanceTalkInfoList()
	{
		array_romanceTalkInfoList.clear();
	}
}
