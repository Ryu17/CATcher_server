package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.TalkInfoDAO;
import data.TalkInfo;
import dataList.talk.TalkInfoList;

//톡 정보들을 DB에서 불러오는 클래스입니다.
public class ReadTalkInfoService {
	
	private static ReadTalkInfoService readTalkInfoService = new ReadTalkInfoService();
	
	public static ReadTalkInfoService getInstance () {
		return readTalkInfoService;
	}
	
	private ReadTalkInfoService() {}
		
	//DB에서 접근해서 가져온 값들을 TalkInfoList에 저장합니다.
	public void ConvertDB2Data(String group_id) {
		Connection conn = null;
				
		try {
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			TalkInfoDAO talkInfoDAO = TalkInfoDAO.getInstance();
			
			TalkInfo talkInfo = null;
			int param_order = 1;
			
			//param_id값마다 찾은 값을 talkInfo로 가져옵니다.
			talkInfo = talkInfoDAO.selectByTalkId(conn, group_id, param_order);			
			
			//TalkInfoList들을 다 지워줍니다.
			TalkInfoList.clearTalkInfoList();
			
			//만약 talkInfo 가 null이 아니라면 
			while(talkInfo != null)
			{
				TalkInfoList.addTalkInfo(talkInfo);
				
				//talkInfo가 null일 때까지 반복.
				param_order = param_order + 1;
				talkInfo = talkInfoDAO.selectByTalkId(conn, group_id, param_order);
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
