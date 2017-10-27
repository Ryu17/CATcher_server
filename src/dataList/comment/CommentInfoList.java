package dataList.comment;

import java.util.ArrayList;
import data.CommentInfo;

//전체 톡들을 저장하는 클래스입니다. 
public class CommentInfoList {
	static ArrayList<CommentInfo> array_CommentInfoList = new ArrayList<CommentInfo>();

	// CommentInfo를 넣고, 찾고, 사이즈를 구하고, 비우는 역할들을 합니다.	
	
	public static void addCommentInfo(CommentInfo commentInfo)
	{
		array_CommentInfoList.add(commentInfo);
	}
	 
	public static CommentInfo findCommentInfo(int group_id)
	{
		return array_CommentInfoList.get(group_id);
	}
	 
	public static int getCommentInfoListSize()
	{
		return array_CommentInfoList.size();
	}
	 
	public static void clearCommentInfoList() {
		array_CommentInfoList.clear();
	}
}
