package dataList.talk;

import java.util.ArrayList;
import data.TalkInfo;

//Thriller(스릴러) 톡들을 저장하는 클래스입니다.
public class ThrillerTalkInfoList {
	static ArrayList<TalkInfo> array_thrillerTalkInfoList = new ArrayList<TalkInfo>();

	//스릴러와 관련된 TalkInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addThrillerTalkInfo(TalkInfo talkInfo)
	{
		array_thrillerTalkInfoList.add(talkInfo);
	}
	 
	public static TalkInfo findThrillerTalkInfo(int ti_id)
	{
		return array_thrillerTalkInfoList.get(ti_id);
	}
	 
	public static int getThrillerTalkInfoListSize()
	{
		return array_thrillerTalkInfoList.size();
	}
	 
	public static void clearThrillerTalkInfoList()
	{
		array_thrillerTalkInfoList.clear();
	}
	
}
