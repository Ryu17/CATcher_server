package service.user;

import java.sql.Connection;
import java.sql.SQLException;
import org.json.simple.JSONObject;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.UserInfoDAO;
import data.user.UserInfo;

//유저 정보를 JSON형태로 만드는 클래스입니다.
public class UserInfoService {
	
	//JSONObject를 만듭니다.
	public JSONObject CreateUserJSONObject(UserInfo userInfo) {
		JSONObject userObj = new JSONObject();

		userObj.put("pub_id", userInfo.getPub_id());
		userObj.put("account_type", userInfo.getAccount_type());
		userObj.put("device_type", userInfo.getDevice_type());
		userObj.put("login_id", userInfo.getLogin_id());
		userObj.put("login_pw", userInfo.getLogin_pw());
		userObj.put("user_key", userInfo.getUser_key());
		userObj.put("user_name", userInfo.getUser_name());
		userObj.put("max_stamina", userInfo.getMax_stamina());
		userObj.put("stamina", userInfo.getStamina());
		userObj.put("free_day1", userInfo.getFree_day1());
		userObj.put("free_day2", userInfo.getFree_day2());
		userObj.put("free_day3", userInfo.getFree_day3());
		userObj.put("free_day4", userInfo.getFree_day4());
		userObj.put("profile_info", userInfo.getProfile_info());
		userObj.put("wait_time", userInfo.getWait_time());

		return userObj;		
	}
	
	public JSONObject CheckUserIdData(String param_id) {
		
		Connection conn = null;
		int idCheck = 0;
		JSONObject idObject = new JSONObject();
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			UserInfoDAO userInfoDAO = UserInfoDAO.getInstance();

			//입력받은 id값이 찾아지는지 검사합니다.
			idCheck = userInfoDAO.searchByUserId(conn, param_id);
					
			//아이디가 있다면. 아래와 같이 jsonobject를 만들어줍니다.
			if (idCheck == 1)
			{
				idObject.put("login_id", "1");
			}
			//아이디가 없다면.
			else if(idCheck == 0)
			{
				idObject.put("login_id", "0");
			}
			
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
		return idObject;		
	}
	
	public JSONObject CheckUserNameData(String param_name) {
		
		Connection conn = null;
		int nameCheck = 0;
		JSONObject idObject = new JSONObject();
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			UserInfoDAO userInfoDAO = UserInfoDAO.getInstance();

			//입력받은 id값이 찾아지는지 검사합니다.
			nameCheck = userInfoDAO.searchByUserName(conn, param_name);
					
			//아이디가 있다면. 아래와 같이 jsonobject를 만들어줍니다.
			if (nameCheck == 1)
			{
				idObject.put("login_name", "1");
			}
			//아이디가 없다면.
			else if(nameCheck == 0)
			{
				idObject.put("login_name", "0");
			}
			
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
		return idObject;		
	}
	
	
	//DB에서 가져온 값들을 UserInfo에 넣어줍니다.
	public UserInfo ConvertDB2Data(String param_id, String param_pw) {

		Connection conn = null;
		UserInfo userInfo = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			UserInfoDAO userInfoDAO = UserInfoDAO.getInstance();

			//아이디와 비밀번호 정보로 전체 유저 정보를 가져옵니다.
			userInfo = userInfoDAO.SelectByUserIdAndPw(conn, param_id, param_pw);
			System.out.println("----- getProfile_info -----");
			//System.out.println(userInfo.getProfile_info());
		
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
		return userInfo;
	}
	
	//UserInfo값들을 Json형태로 만들어줍니다.
	public JSONObject CheckUserIdAndPwData(String param_id, String param_pw) {
		JSONObject userObj = new JSONObject();
		UserInfo userInfo = null;
		
		//ConvertDB2Data 로 UserInfo를 생성합니다.
		userInfo = ConvertDB2Data(param_id, param_pw);
		//System.out.println(userInfo);
		//유저 정보가 없다면.
		if (userInfo != null) 
		{
			System.out.println("---------- userObj not null ----------");
			//System.out.println(userInfo);
			//jsonobject를 만들어줍니다.
			userObj = CreateUserJSONObject(userInfo);
		}
		else 
		{
			System.out.println("---------- userObj null ----------");
			//System.out.println(userInfo);
			userObj.put("password", "0");
		}
		return userObj;
	}
}
