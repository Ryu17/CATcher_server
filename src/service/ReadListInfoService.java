package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.ListInfoDAO;
import data.ListInfo;
import dataList.talk_title.TalkTitleList;

//리스트 정보들을 DB에서 불러오는 클래스입니다.
public class ReadListInfoService {
	
	private static ReadListInfoService readListInfoService = new ReadListInfoService();
	
	public static ReadListInfoService getInstance () {
		return readListInfoService;
	}
	
	private ReadListInfoService() {}

	//DB에서 접근해서 가져온 값들을 ListInfo List에 저장합니다.
	public void ConvertDB2Data() {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			ListInfoDAO listInfoDAO = ListInfoDAO.getInstance();
			
			ListInfo listInfo = null;
			int id = 1;
						
			//카테고리 시리얼 넘버에 따라서 쿼리 결과값을 categoryInfo형태로 가져옵니다.
			listInfo = listInfoDAO.selectByTitleList(conn, id);
			
			//TalkInfoList들을 다 지워줍니다.
			TalkTitleList.clearListInfo();
			
			while(listInfo != null)
			{
				TalkTitleList.addListInfo(listInfo);

				//listInfo가 null일 때까지 반복.
				id = id + 1;
				listInfo = listInfoDAO.selectByTitleList(conn, id);
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
