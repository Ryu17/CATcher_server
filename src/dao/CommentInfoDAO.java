package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.CommentInfo;
import dataList.comment.CommentInfoList;

//DB에 접근해 쿼리문을 실행시키고 CommentInfo 결과값을 받아오는 클래스입니다.
public class CommentInfoDAO {
	
	private static CommentInfoDAO commentInfoDao = new CommentInfoDAO();
	
	public static CommentInfoDAO getInstance() {
		return commentInfoDao;
	}
	
	private CommentInfoDAO(){}
	
	//ResultSet으로부터 CommentInfo 값을 만들어줍니다.
	public CommentInfo makeCommentInfoFromResultSet(ResultSet rs) throws SQLException {
		
		//각 항목의 값을 가져옵니다.
		String group_id = rs.getString("group_id");
		String imgname = rs.getString("imgname");
		String nickname = rs.getString("nickname");
		String comments = rs.getString("comments");
		String date = rs.getString("date");
		
		CommentInfo commentInfo = new CommentInfo(group_id, imgname, nickname, comments, date);
		
		return commentInfo;
	}
	
	//쿼리문을 실행시켜서 group_id값에 따라 결과값을 가져옵니다.
	public void selectByGroupId(Connection conn, String group_id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CommentInfo commentInfo = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM textIsland.comment WHERE `group_id` = ?;");

			pstmt.setString(1, group_id);
			rs = pstmt.executeQuery();
			
			CommentInfoList.clearCommentInfoList();

			//CommentInfo가 null일 때까지 반복.
			while(rs.next()) {
		        commentInfo = makeCommentInfoFromResultSet(rs);
		        
		        CommentInfoList.addCommentInfo(commentInfo);
			}
		} 
		finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	//댓글을 등록하기 전에 이미 댓글을 썼었는지 확인을 합니다.
	public int CheckComment(Connection conn, String group_id, String nickname) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement ("SELECT * FROM textIsland.comment WHERE `group_id` = ? AND `nickname` = ?;");
			
			pstmt.setString(1, group_id);
			pstmt.setString(2, nickname);
			rs = pstmt.executeQuery();
			
			System.out.println(pstmt);
			
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
	
	//이미 등록된 댓글을 지웁니다.
	public void DeleteComment(Connection conn, String group_id, String nickname) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement ("DELETE FROM textIsland.comment WHERE group_id = ? AND nickname = ?;");
			
			pstmt.setString(1, group_id);
			pstmt.setString(2, nickname);
			
			pstmt.executeUpdate();
			
			System.out.println(pstmt);
			
		} catch(Exception e) {
			System.out.println("SQL ERROR");
			System.out.println(e);
			e.printStackTrace();
		}
		
		finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	//댓글을 등록합니다.
	public void InsertComment(Connection conn, String group_id, String imgname, String nickname,
							  String comments, String date) throws SQLException {
		
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement ("INSERT INTO textIsland.comment VALUES (?, ?, ?, ?, ?);");
			
			pstmt.setString(1, group_id);
			pstmt.setString(2, imgname);
			pstmt.setString(3, nickname);
			pstmt.setString(4, comments);
			pstmt.setString(5, date);

			pstmt.executeUpdate();
			
			System.out.println(pstmt);

		} catch(Exception e) {
			System.out.println("SQL ERROR");
			System.out.println(e);
			e.printStackTrace();
		}
		
		finally {
			JdbcUtil.close(pstmt);
		}
	}
}
