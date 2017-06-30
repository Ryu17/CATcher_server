package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.user.UserInfo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.http.HttpServlet;
//import java.io.*;
//import java.util.*;
//import javax.servlet.http.HttpSession;

//DB에 접근해 쿼리문을 실행시키고 UserInfo 결과값을 받아오는 클래스입니다.
public class UserInfoDAO {

	private static UserInfoDAO userInfoDAO = new UserInfoDAO();
	
	public static UserInfoDAO getInstance() {
		return userInfoDAO;
	}
	
	private UserInfoDAO(){}
	
	//ResultSet으로부터 UserInfo를 생성합니다.
	public UserInfo makeUserInfoFromResultSet(ResultSet rs) throws SQLException { 
		//각 항목들의 값을 가져옵니다.
		String pub_id = rs.getString("pub_id");
		int account_type = rs.getInt("account_type");
		int device_type = rs.getInt("device_type");
		String login_id = rs.getString("login_id");
		String login_pw = rs.getString("login_pw");
		int user_key = rs.getInt("user_key");
		String user_name = rs.getString("user_name");
		int max_stamina = rs.getInt("max_stamina");
		int stamina = rs.getInt("stamina");
		String free_day1 = rs.getString("free_day1");
		int free_day2 = rs.getInt("free_day2");
		String free_day3 = rs.getString("free_day3");
		int free_day4 = rs.getInt("free_day4");
		String profile_info = rs.getString("profile_info");
		int wait_time = rs.getInt("wait_time");
		String like_check = rs.getString("like_check");
		
		//가져온 값들을 UserInfo로 만들어 줍니다.
		UserInfo userInfo = new UserInfo(pub_id, 
										account_type,
										device_type,
										login_id,
										login_pw,
										user_key,
										user_name,
										max_stamina,
										stamina,
										free_day1,
										free_day2,
										free_day3,
										free_day4,
										profile_info,
										wait_time,
										like_check);
		
		return userInfo;
	}
	
	//쿼리문을 실행시켜서 UserID값에 따라 결과값을 가져옵니다.
	public int searchByUserId(Connection conn, String param_user_id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement ("SELECT * FROM textIsland.user WHERE login_id = ?;");
			pstmt.setString(1, param_user_id);
			rs = pstmt.executeQuery();
			
			//존재하는 id인가.
			if(rs.next()) 
			{
				return 1;
			}
			//아닌가.
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
	
	public int searchByUserName(Connection conn, String param_user_name) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement ("SELECT * FROM textIsland.user WHERE user_name = ?;");
			pstmt.setString(1, param_user_name);
			rs = pstmt.executeQuery();
			
			//존재하는 id인가.
			if(rs.next()) 
			{
				return 1;
			}
			//아닌가.
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


	//아이디와 비번 전체를 만족하는 결과를 가져옵니다.
	public UserInfo SelectByUserIdAndPw(Connection conn, String param_user_id, String param_user_pw) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo userInfo = null;
		
		try {
			pstmt = conn.prepareStatement ("SELECT * FROM textIsland.user WHERE login_id = ? AND login_pw = ?;");
			pstmt.setString(1, param_user_id);
			pstmt.setString(2, param_user_pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				//결과값을 만듭니다.				
				return makeUserInfoFromResultSet(rs);
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
