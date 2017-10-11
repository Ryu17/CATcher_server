package service;

import java.sql.Connection;
import java.sql.SQLException;
import org.json.simple.JSONObject;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.GameInfoDAO;
import data.GameInfo;

//게임 정보들을 JSON형태로 만드는 클래스입니다.
public class GameInfoService {
	
	//JSONObject를 만듭니다.
	public JSONObject CreateGameJSONObject(GameInfo gameInfo) {
		JSONObject gameObj = new JSONObject();

		gameObj.put("latest_version", gameInfo.getVersion());
		gameObj.put("image_download", gameInfo.getImageDownload());
		
		return gameObj;		
	}
	
	//DB에서 가져온 값들을 UserInfo에 넣어줍니다.
	public GameInfo ConvertDB2Data() {

		Connection conn = null;
		GameInfo gameInfo = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			GameInfoDAO gameInfoDAO = GameInfoDAO.getInstance();

			//아이디와 비밀번호 정보로 전체 유저 정보를 가져옵니다.
			gameInfo = gameInfoDAO.SelectByGameInfo(conn);
		
		} catch (SQLException e){
			
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
		return gameInfo;
	}
	
	//gameInfo값들을 Json형태로 만들어줍니다.
	public JSONObject ReadGameInfo() {
		JSONObject gameObj = new JSONObject();
		GameInfo gameInfo = null;
		
		gameInfo = ConvertDB2Data();
		
		if (gameInfo != null) 
		{
			gameObj = CreateGameJSONObject(gameInfo);
		}
		else 
		{
			System.out.println("---------- gameObj null ----------");
			//System.out.println(userInfo);
		}
		return gameObj;
	}
}
