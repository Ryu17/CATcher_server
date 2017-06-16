package dataList.talk;

import java.util.ArrayList;

import data.TalkInfo;

//Recommend(추천) 톡들을 저장하는 클래스입니다. 
public class RecommendTalkInfoList {
	static ArrayList<TalkInfo> array_RecommendTalkInfoList = new ArrayList<TalkInfo>();

	//추천과 관련된 TalkInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addRecommendTalkInfo(TalkInfo talkInfo)
	{
		array_RecommendTalkInfoList.add(talkInfo);
	}
	 
	public static TalkInfo findRecommendTalkInfo(int ti_id)
	{
		return array_RecommendTalkInfoList.get(ti_id);
	}
	 
	public static int getRecommendTalkInfoListSize()
	{
		return array_RecommendTalkInfoList.size();
	}
	 
	public static void clearRecommendTalkInfoList()
	{
		array_RecommendTalkInfoList.clear();
	}

}
