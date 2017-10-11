package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.ImageList;

public class ImageListDAO {
	
	private static ImageListDAO imageListDao = new ImageListDAO();
	
	public static ImageListDAO getInstance() {
		return imageListDao;
	}
	
	private ImageListDAO(){}

	//ResultSet으로부터 ImageList 값을 만들어줍니다.
	public ImageList makeImageListFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		String name = rs.getString("name");
		int exist = rs.getInt("exist");
		
		//가져온 값들을 imageList로 만들어 줍니다.
		ImageList imageList = new ImageList(name, exist);
		
		return imageList;
	}
	
	//쿼리문을 실행시켜서 id값에 따라 결과값을 가져옵니다.
	public ImageList selectByImageList(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM image_list WHERE id = ?;");

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
	        if(rs.next()) {	
	        	return makeImageListFromResultSet(rs);
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
