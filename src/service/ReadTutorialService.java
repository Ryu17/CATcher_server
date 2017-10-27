package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.TutorialDAO;
import data.TutoInfo;
import dataList.tutorial.TutoInfoList;

//리스트 정보들을 DB에서 불러오는 클래스입니다.
public class ReadTutorialService {
	
	private static ReadTutorialService readTutorialService = new ReadTutorialService();
	
	public static ReadTutorialService getInstance () {
		return readTutorialService;
	}
	
	private ReadTutorialService() {}
	
	//DB에서 접근해서 가져온 값들을 ImageTalk List에 저장합니다.
		public void ConvertDB2Data() {
			Connection conn = null;
			
			try {	
				conn = ConnectionProvider.getConnection();

				conn.setAutoCommit(false);
				
				TutorialDAO tutorialDAO = TutorialDAO.getInstance();
				
				TutoInfo tutoInfo = null;
				int id = 1;
							
				//카테고리 시리얼 넘버에 따라서 쿼리 결과값을 TutoInfo형태로 가져옵니다.
				tutoInfo = tutorialDAO.SelectByTutoInfo(conn, id);
				
				//ImageTalk들을 다 지워줍니다.
				TutoInfoList.clearTutoInfo();
				
				while(tutoInfo != null)
				{
					TutoInfoList.addTutoInfo(tutoInfo);

					//imageTalk가 null일 때까지 반복.
					id = id + 1;
					tutoInfo = tutorialDAO.SelectByTutoInfo(conn, id);
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
