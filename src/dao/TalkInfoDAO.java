package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.TalkInfo;

//DB에 접근해 쿼리문을 실행시키고 TalkInfo 결과값을 받아오는 클래스입니다.
public class TalkInfoDAO {	
	private static TalkInfoDAO talkInfoDao = new TalkInfoDAO();
	
	public static TalkInfoDAO getInstance() {
		return talkInfoDao;
	}
	
	private TalkInfoDAO(){}
	
	//ResultSet으로부터 TalkInfo 값을 만들어줍니다.
	public TalkInfo makeTalkInfoFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		
		int i_group_id = rs.getInt("group_id");
		int i_id = rs.getInt("id");
		int i_msg_order = rs.getInt("msg_order");
		float f_delay = rs.getFloat("delay");
		String s_speaker = rs.getString("speaker");
		String s_msg_view_point = rs.getString("msg_view_point");
		String s_msg_type = rs.getString("msg_type");
		String s_msg_data = rs.getString("msg_data");
		int i_stm_check = rs.getInt("stm_check");
		String s_profile_img = rs.getString("profile_img");

		//가져온 값들을 TalkInfo로 만들어 줍니다.
		TalkInfo talkInfo = new TalkInfo(
								i_group_id,
								i_id, 
								i_msg_order,
								f_delay,
								s_speaker,
								s_msg_view_point,
								s_msg_type,
								s_msg_data,
								i_stm_check,
								s_profile_img
								);

		return talkInfo;
	}
	
	//쿼리문을 실행시켜서 TalkID값에 따라 결과값을 가져옵니다.
	public TalkInfo selectByTalkId(Connection conn, String group_id, int param_order) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM story_talk WHERE group_id = ? and msg_order = ?;");	
			
			pstmt.setString(1, group_id);
			pstmt.setInt(2, param_order);
			rs = pstmt.executeQuery();

			if(rs.next()) {	
	        	return makeTalkInfoFromResultSet(rs);
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
