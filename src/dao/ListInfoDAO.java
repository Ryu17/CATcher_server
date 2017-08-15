package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.ListInfo;

//DB에 접근해 쿼리문을 실행시키고 ListInfo 결과값을 받아오는 클래스입니다.
public class ListInfoDAO{
	
	private static ListInfoDAO listInfoDao = new ListInfoDAO();
	
	public static ListInfoDAO getInstance() {
		return listInfoDao;
	}
	
	private ListInfoDAO(){}

	//ResultSet으로부터 ListInfo 값을 만들어줍니다.
	public ListInfo makeListInfoFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		int t_id = rs.getInt("id");
		int t_group_id = rs.getInt("group_id");
		String t_author = rs.getString("author");
		String t_image_id = rs.getString("img_id");
		String t_title = rs.getString("title");
		int t_view_count = rs.getInt("view_count");
		int t_like_count = rs.getInt("like_count");
		int t_category_id = rs.getInt("category_id");
		int t_date = rs.getInt("date");
		int t_bg_img = rs.getInt("bg_img");
		String t_cont = rs.getString("continuity");
		String t_synopsis = rs.getString("synopsis");
		int t_nologinrecommend = rs.getInt("nologinrecommend");
		System.out.println("java class test");
		//가져온 값들을 ListInfo로 만들어 줍니다.
		ListInfo listInfo = new ListInfo(
										t_id,
										t_group_id,
										t_author,
										t_image_id,
										t_title,
										t_view_count,
										t_like_count,
										t_category_id,
										t_date,
										t_bg_img,
										t_cont,
										t_synopsis,
										t_nologinrecommend);
		return listInfo;
	}
	
	//쿼리문을 실행시켜서 id값에 따라 결과값을 가져옵니다.
	public ListInfo selectByTitleList(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM story_talk_title WHERE id = ?;");

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
	        if(rs.next()) {	
	        	return makeListInfoFromResultSet(rs);
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
