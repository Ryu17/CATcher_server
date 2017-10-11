package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.ImageCover;

public class ImageCoverDAO {
	
	private static ImageCoverDAO imageCoverDao = new ImageCoverDAO();
	
	public static ImageCoverDAO getInstance() {
		return imageCoverDao;
	}
	
	private ImageCoverDAO(){}

	//ResultSet으로부터 ImageCover 값을 만들어줍니다.
	public ImageCover makeImageCoverFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		String name = rs.getString("name");
		int exist = rs.getInt("exist");
		
		//가져온 값들을 imageCover로 만들어 줍니다.
		ImageCover imageCover = new ImageCover(name, exist);
		
		return imageCover;
	}
	
	//쿼리문을 실행시켜서 id값에 따라 결과값을 가져옵니다.
	public ImageCover selectByImageCover(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM image_cover WHERE id = ?;");

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
	        if(rs.next()) {	
	        	return makeImageCoverFromResultSet(rs);
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
