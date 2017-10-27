package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.TutoInfo;

//DB에 접근해 쿼리문을 실행시키고 Tutorial 결과값을 받아오는 클래스입니다.
public class TutorialDAO {
	
	private static TutorialDAO tutorialDao = new TutorialDAO();
	
	public static TutorialDAO getInstance() {
		return tutorialDao;
	}
	
	private TutorialDAO(){}
	
	//ResultSet으로부터 GameInfo 값을 만들어줍니다.
	public TutoInfo makeTutoInfoFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		int id = rs.getInt("id");
		int group_id = rs.getInt("group_id");
		String message1 = rs.getString("message1");
		String message2 = rs.getString("message2");
		
		//가져온 값들을 tutoInfo로 만들어 줍니다.
		TutoInfo tutoInfo = new TutoInfo(id, group_id, message1, message2);
			
		return tutoInfo;
	}
		
	//쿼리문을 실행시켜서 결과값을 가져옵니다.
	public TutoInfo SelectByTutoInfo(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM tutorial WHERE id = ?;");
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
				
		    if(rs.next()) {	
		        return makeTutoInfoFromResultSet(rs);
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
	
	public void UpdateTutorialLike(Connection conn, String param_branch) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			// 좋아요 ++
			pstmt = conn.prepareStatement ("UPDATE textIsland.tutorial_like SET like_count = like_count + 1 WHERE id = ?;");
						
			pstmt.setString(1, param_branch);
						
			pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			JdbcUtil.close(pstmt);
		}
	}
}
