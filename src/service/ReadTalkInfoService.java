package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.TalkInfoDAO;
import data.TalkInfo;
import dataList.talk.RecommendTalkInfoList;
import dataList.talk.RomanceTalkInfoList;
import dataList.talk.ThrillerTalkInfoList;
import dataList.category.NewInfoList;
import dataList.category.RecommendInfoList;
import dataList.talk.NewTalkInfoList;

//톡 정보들을 DB에서 불러오는 클래스입니다.
public class ReadTalkInfoService {
	
	private static ReadTalkInfoService readTalkInfoService = new ReadTalkInfoService();
	
	public static ReadTalkInfoService getInstance () {
		return readTalkInfoService;
	}
	
	private ReadTalkInfoService() {}
		
	//DB에서 접근해서 가져온 값들을 카테고리별로 TalkInfoList에 저장합니다.
	public void ConvertDB2Data() {
		Connection conn = null;
				
		try {
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			TalkInfoDAO talkInfoDAO = TalkInfoDAO.getInstance();
			
			TalkInfo talkInfo = null;
			int param_id = 1;
			
			//param_id값마다 찾은 값을 talkInfo로 가져옵니다.
			talkInfo = talkInfoDAO.selectByTalkId(conn, param_id);			
			
			//TalkInfoList들을 다 지워줍니다.
			RecommendTalkInfoList.clearRecommendTalkInfoList();
			RomanceTalkInfoList.clearRomanceTalkInfoList();
			ThrillerTalkInfoList.clearThrillerTalkInfoList();
			NewTalkInfoList.clearNewTalkInfoList();
			
			//만약 talkInfo 가 null이 아니라면 
			while(talkInfo != null)
			{
				//테스트 출력 
				//System.out.println("talk category : " + talkInfo.getCategory_id() + " and data is : " + talkInfo.getMsg_data());
				
				//talkInfo의 category_id 에 따라서 카테고리에 넣어주는 TalkInfoList가 달라집니다.
				switch(talkInfo.getCategory_id()){
				//ROMANCE 1 THRILLER 2
				//category_id가 1이면 RomanceTalkInfoList 에 talkInfo 를 추가해줍니다.
				//category_id가 2이면 ThrillerTalkInfoList 에 talkInfo 를 추가해줍니다.
				case 0 	:RecommendTalkInfoList.addRecommendTalkInfo(talkInfo); break;
				case 1	:RomanceTalkInfoList.addRomanceTalkInfo(talkInfo); break;
				case 2	:ThrillerTalkInfoList.addThrillerTalkInfo(talkInfo); break;
				case 3	:NewTalkInfoList.addNewTalkInfo(talkInfo);break;
				default	:break;
				}				
				//talkInfo가 null일 때까지 반복.
				param_id = param_id + 1;
				talkInfo = talkInfoDAO.selectByTalkId(conn, param_id);
			}
			
		} catch (SQLException e){
			
		} finally {
			if(conn == null) {
				System.out.println("conn is null!");
			} else 
			{
				System.out.println("conn is successful");
				JdbcUtil.close(conn);
			}			
		}
	}
}
