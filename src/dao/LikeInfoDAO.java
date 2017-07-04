package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;

public class LikeInfoDAO{
	
	private static LikeInfoDAO likeInfoDao = new LikeInfoDAO();
	
	public static LikeInfoDAO getInstance() {
		return likeInfoDao;
	}
	
	private LikeInfoDAO(){}
	
	//쿼리문을 실행시켜서 결과값을 가져옵니다.
	public int SelectByLikeInfo(Connection conn, String param_user_key, String param_group_id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM textIsland.user_like WHERE user_key = ? AND group_id = ?;");
			
			pstmt.setString(1, param_user_key);
			pstmt.setString(2, param_group_id);
			rs = pstmt.executeQuery();
			
			// 좋아요 카운트를 누른적이 있는가?
	        if(rs.next()) {
	        	return 1;
			}
	        // 없는가?
	        else
	        {
	        	return 0;
	        }

		} 
		finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
	}
	
	// USER_LIKE_DATA 에서 좋아요 읽은 만큼 추가 & 삭제
	public void UpdateByLikeInfo(Connection conn, String param_user_key, String param_group_id, int index) throws SQLException {
		PreparedStatement pstmt = null;

		System.out.println(param_user_key);
		System.out.println(param_group_id);
		try {
			// 추가
			if(index == 1){
				pstmt = conn.prepareStatement ("INSERT INTO textIsland.user_like VALUES (?, ?);");
			}
			
			// 삭제
			else if(index == 0){
				pstmt = conn.prepareStatement ("DELETE FROM textIsland.user_like WHERE user_key = ? AND group_id = ?;");
			}
			
			pstmt.setString(1, param_user_key);
			pstmt.setString(2, param_group_id);
			
			System.out.println(pstmt);
			
			pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	// STORY_TALK_TITLE_DATA 에서 좋아요 카운트 증가 & 감소
	public void UpdateByLikeCount(Connection conn, String param_group_id, int index) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			// like_count ++
			if(index == 1){
				pstmt = conn.prepareStatement ("UPDATE textIsland.story_talk_title SET like_count = like_count + 1 WHERE group_id = ?;");
			}
			// like_count --
			else if(index == 0) {
				pstmt = conn.prepareStatement ("UPDATE textIsland.story_talk_title SET like_count = like_count - 1 WHERE group_id = ?;");
			}
			pstmt.setString(1, param_group_id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	// STORY_TALK_TITLE_DATA 에서 조회 수 증가
	public void UpdateByViewCount(Connection conn, String param_group_id) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			
			pstmt = conn.prepareStatement ("UPDATE textIsland.story_talk_title SET view_count = view_count + 1 WHERE group_id = ?;");

			pstmt.setString(1, param_group_id);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(pstmt);
		}
	}
}
