package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.JdbcUtil;
import data.GameInfo;

//DB에 접근해 쿼리문을 실행시키고 GameInfo 결과값을 받아오는 클래스입니다.
public class GameInfoDAO{
	
	private static GameInfoDAO gameInfoDao = new GameInfoDAO();
	
	public static GameInfoDAO getInstance() {
		return gameInfoDao;
	}
	
	private GameInfoDAO(){}

	//ResultSet으로부터 GameInfo 값을 만들어줍니다.
	public GameInfo makeListInfoFromResultSet(ResultSet rs) throws SQLException {
		//각 항목들의 값을 가져옵니다.
		int i_version = rs.getInt("latest_version");
		System.out.println(i_version);

		//가져온 값들을 gameInfo로 만들어 줍니다.
		GameInfo gameInfo = new GameInfo(i_version);
		
		return gameInfo;
	}
	
	//쿼리문을 실행시켜서 결과값을 가져옵니다.
	public GameInfo SelectByGameInfo(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement ("SELECT * FROM info;");

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
