package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.ImageSpeaker;

public class ImageSpeakerDAO {
	
	private static ImageSpeakerDAO imageSpeakerDao = new ImageSpeakerDAO();
	
	public static ImageSpeakerDAO getInstance() {
		return imageSpeakerDao;
	}
	
	private ImageSpeakerDAO(){}

	//ResultSet으로부터 ImageSpeaker 값을 만들어줍니다.
	public ImageSpeaker makeImageSpeakerFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		String name = rs.getString("name");
		int exist = rs.getInt("exist");
		
		//가져온 값들을 imageSpeaker로 만들어 줍니다.
		ImageSpeaker imageSpeaker = new ImageSpeaker(name, exist);
		
		return imageSpeaker;
	}
	
	//쿼리문을 실행시켜서 id값에 따라 결과값을 가져옵니다.
	public ImageSpeaker selectByImageSpeaker(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM image_speaker WHERE id = ?;");

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
	        if(rs.next()) {	
	        	return makeImageSpeakerFromResultSet(rs);
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
