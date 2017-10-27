package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.CommentInfoDAO;

//댓글 정보들을 DB에서 불러오는 클래스입니다.
public class ReadCommentInfoService {
	
	private static ReadCommentInfoService readCommentInfoService = new ReadCommentInfoService();
	
	public static ReadCommentInfoService getInstance() {
		return readCommentInfoService;
	}
	
	private ReadCommentInfoService() {}
	
	//DB에서 접근해서 가져온 값들을 CommentInfoList에 저장합니다.
	public void ConvertDB2Data(String group_id) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
			
			CommentInfoDAO commentInfoDAO = CommentInfoDAO.getInstance();
			
			//해당 group_id에서 찾은 값을 commentInfo로 가져옵니다.
			commentInfoDAO.selectByGroupId(conn, group_id);
			
		} catch (SQLException e) {
		
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
