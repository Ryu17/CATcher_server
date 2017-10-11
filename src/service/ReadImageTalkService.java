package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.ImageTalkDAO;
import data.ImageTalk;
import dataList.image.Talk;

//리스트 정보들을 DB에서 불러오는 클래스입니다.
public class ReadImageTalkService {

	private static ReadImageTalkService readImageTalkService = new ReadImageTalkService();
	
	public static ReadImageTalkService getInstance () {
		return readImageTalkService;
	}
	
	private ReadImageTalkService() {}

	//DB에서 접근해서 가져온 값들을 ImageTalk List에 저장합니다.
	public void ConvertDB2Data() {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			ImageTalkDAO imageTalkDAO = ImageTalkDAO.getInstance();
			
			ImageTalk imageTalk = null;
			int id = 1;
						
			//카테고리 시리얼 넘버에 따라서 쿼리 결과값을 ImageTalk형태로 가져옵니다.
			imageTalk = imageTalkDAO.selectByImageTalk(conn, id);
			
			//ImageTalk들을 다 지워줍니다.
			Talk.clearImageTalk();
			
			while(imageTalk != null)
			{
				Talk.addImageTalk(imageTalk);

				//imageTalk가 null일 때까지 반복.
				id = id + 1;
				imageTalk = imageTalkDAO.selectByImageTalk(conn, id);
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
