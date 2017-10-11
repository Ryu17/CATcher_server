package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.ImageTalk;

public class ImageTalkDAO {
	
	private static ImageTalkDAO imageTalkDao = new ImageTalkDAO();
	
	public static ImageTalkDAO getInstance() {
		return imageTalkDao;
	}
	
	private ImageTalkDAO(){}

	//ResultSet으로부터 ImageTalk 값을 만들어줍니다.
	public ImageTalk makeImageTalkFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		String name = rs.getString("name");
		int exist = rs.getInt("exist");
		
		//가져온 값들을 imageTalk로 만들어 줍니다.
		ImageTalk imageTalk = new ImageTalk(name, exist);
		
		return imageTalk;
	}
	
	//쿼리문을 실행시켜서 id값에 따라 결과값을 가져옵니다.
	public ImageTalk selectByImageTalk(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM image_talk WHERE id = ?;");

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
	        if(rs.next()) {	
	        	return makeImageTalkFromResultSet(rs);
			}
	        else
	        {
	        	return null;
	        }

		} 
		finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
	}
}
