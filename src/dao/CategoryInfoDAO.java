package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.CategoryInfo;

//DB에 접근해 쿼리문을 실행시키고 CategoryInfo 결과값을 받아오는 클래스입니다.
public class CategoryInfoDAO{
	
	private static CategoryInfoDAO categoryInfoDao = new CategoryInfoDAO();
	
	public static CategoryInfoDAO getInstance() {
		return categoryInfoDao;
	}
	
	private CategoryInfoDAO(){}

	//ResultSet으로부터 CategoryInfo 값을 만들어줍니다.
	public CategoryInfo makeCategoryInfoFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		int i_category_serial = rs.getInt("category_serial");
		int i_category_id = rs.getInt("category_id");
		int i_category_order = rs.getInt("category_order");
		int i_group_id = rs.getInt("group_id");
		String s_author = rs.getString("author");
		String s_image_id = rs.getString("img_id");
		String s_title = rs.getString("title");
		int s_view_count = rs.getInt("view_count");
		int s_like_count = rs.getInt("like_count");

		//가져온 값들을 CategoryInfo로 만들어 줍니다.
		CategoryInfo categoryInfo = new CategoryInfo(
										i_category_serial,
										i_category_id, 
										i_category_order,
										i_group_id,
										s_author,
										s_image_id,
										s_title,
										s_view_count,
										s_like_count);
		return categoryInfo;
	}
	
	//쿼리문을 실행시켜서 CategorySerial값에 따라 결과값을 가져옵니다.
	public CategoryInfo selectByCategorySerial(Connection conn, int category_serial) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT c.category_serial, c.category_id, c.category_order, c.group_id, t.author, t.img_id, t.title, t.view_count, t.like_count "
					+ "FROM category_list AS c INNER JOIN story_talk_title AS t ON c.group_id = t.group_id "
					+ "WHERE c.category_serial = ?;");

			pstmt.setInt(1, category_serial);
			rs = pstmt.executeQuery();
			
	        if(rs.next()) {	
	        	return makeCategoryInfoFromResultSet(rs);
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
