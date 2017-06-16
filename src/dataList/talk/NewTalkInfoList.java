package dataList.talk;

import java.util.ArrayList;

import data.TalkInfo;

//New(신작) 톡들을 저장하는 클래스입니다. 
public class NewTalkInfoList {
	static ArrayList<TalkInfo> array_NewTalkInfoList = new ArrayList<TalkInfo>();

	//신작 관련된 TalkInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addNewTalkInfo(TalkInfo talkInfo)
	{
		array_NewTalkInfoList.add(talkInfo);
	}
	 
	public static TalkInfo findNewTalkInfo(int ti_id)
	{
		return array_NewTalkInfoList.get(ti_id);
	}
	 
	public static int getNewTalkInfoListSize()
	{
		return array_NewTalkInfoList.size();
	}
	 
	public static void clearNewTalkInfoList() {
		array_NewTalkInfoList.clear();
	}
}
