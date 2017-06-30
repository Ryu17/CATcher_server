package dataList.talk;

import java.util.ArrayList;

import data.TalkInfo;

//전체 톡들을 저장하는 클래스입니다. 
public class TalkInfoList {
	static ArrayList<TalkInfo> array_TalkInfoList = new ArrayList<TalkInfo>();

	// TalkInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addTalkInfo(TalkInfo talkInfo)
	{
		array_TalkInfoList.add(talkInfo);
	}
	 
	public static TalkInfo findTalkInfo(int ti_id)
	{
		return array_TalkInfoList.get(ti_id);
	}
	 
	public static int getTalkInfoListSize()
	{
		return array_TalkInfoList.size();
	}
	 
	public static void clearTalkInfoList() {
		array_TalkInfoList.clear();
	}
}
