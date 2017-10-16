package service;

import java.sql.Connection;
import java.sql.SQLException;
import org.json.simple.JSONObject;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.LikeInfoDAO;

//좋아요 정보를 JSON형태로 만드는 클래스입니다.
public class LikeInfoService {
	
	public JSONObject CheckLikeData(String param_user_key, String param_group_id) {
		
		Connection conn = null;
		
		// 있으면 1, 없으면 0
		int likeCheck = 0;
		
		JSONObject likeObject = new JSONObject();
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			LikeInfoDAO likeInfoDAO = LikeInfoDAO.getInstance();

			//입력받은 id값이 찾아지는지 검사합니다.
			likeCheck = likeInfoDAO.SelectByLikeInfo(conn, param_user_key, param_group_id);
					
			//좋아요를 눌렀었다면. 아래와 같이 jsonobject를 만들어줍니다.
			if (likeCheck == 1)
			{
				likeObject.put("like_check", "1");
			}
			//좋아요를 안눌렀다면.
			else if(likeCheck == 0)
			{
				likeObject.put("like_check", "0");
			}
			
		} catch (SQLException e){
			System.out.println("SQL ERROR");
			System.out.println(e);
		} finally {
			//연결이 안되었을 경우.
			if(conn == null) 
			{
				System.out.println("conn is null!");
			} 
			//연결이 되었을 경우.
			else 
			{
				System.out.println("conn is successful");
				JdbcUtil.close(conn);
			}			
		}
		return likeObject;		
	}
	
	public void SumLikeData(String param_user_key, String param_group_id) {
		
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();
			
			LikeInfoDAO likeInfoDAO = LikeInfoDAO.getInstance();

			//입력받은 user_key와 group_id로 USER_LIKE_DATA에 데이터 추가 (마지막 parameter 는 1)
			likeInfoDAO.UpdateByLikeInfo(conn, param_user_key, param_group_id, 1);
			//입력받은 group_id로 STORY_TALK_TITLE_DATA에 like_count ++ (마지막 parameter 는 1)
			likeInfoDAO.UpdateByLikeCount(conn, param_group_id, 1);
			
		} catch (SQLException e){
			System.out.println("SQL ERROR");
			System.out.println(e);
		} finally {
			//연결이 안되었을 경우.
			if(conn == null) 
			{
				System.out.println("conn is null!");
			} 
			//연결이 되었을 경우.
			else 
			{
				System.out.println("conn is successful");
				JdbcUtil.close(conn);
			}			
		}
	}
	
	public void SumUnLikeData(String param_user_key, String param_group_id) {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();
			
			LikeInfoDAO likeInfoDAO = LikeInfoDAO.getInstance();

			//입력받은 user_key와 group_id로 USER_LIKE_DATA에 데이터 추가 (마지막 parameter 는 0)
			likeInfoDAO.UpdateByLikeInfo(conn, param_user_key, param_group_id, 0);
			//입력받은 group_id로 STORY_TALK_TITLE_DATA에 unlike_count ++ (마지막 parameter 는 0)
			likeInfoDAO.UpdateByLikeCount(conn, param_group_id, 0);
						
		} catch (SQLException e){
			System.out.println("SQL ERROR");
			System.out.println(e);
		} finally {
			//연결이 안되었을 경우.
			if(conn == null) 
			{
				System.out.println("conn is null!");
			} 
			//연결이 되었을 경우.
			else 
			{
				System.out.println("conn is successful");
				JdbcUtil.close(conn);
			}			
		}
	}
	
	public void AddViewCount(String param_group_id) {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();
			
			LikeInfoDAO likeInfoDAO = LikeInfoDAO.getInstance();

			//입력받은 group_id로 STORY_TALK_TITLE_DATA에 view_count ++
			likeInfoDAO.UpdateByViewCount(conn, param_group_id);
						
		} catch (SQLException e){
			System.out.println("SQL ERROR");
			System.out.println(e);
		} finally {
			//연결이 안되었을 경우.
			if(conn == null) 
			{
				System.out.println("conn is null!");
			} 
			//연결이 되었을 경우.
			else 
			{
				System.out.println("conn is successful");
				JdbcUtil.close(conn);
			}			
		}
	}
}
