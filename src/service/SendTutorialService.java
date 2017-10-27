package service;

import java.sql.Connection;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import data.TutoInfo;
import dataList.tutorial.TutoInfoList;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.TutorialDAO;

public class SendTutorialService {
	
	//하나씩 받은 TutoInfo를 JSONObject로 만들어줍니다.
	public JSONObject CreateTutoJSONObject(JSONObject tutoObj, TutoInfo tutoInfo) {
		//tutoInfo의 자료들을 하나씩 TutoObj에 넣어줍니다.
		tutoObj.put("id", tutoInfo.getId());
		tutoObj.put("group_id", tutoInfo.getGroup_id());
		tutoObj.put("message1", tutoInfo.getMessage1());
		tutoObj.put("message2", tutoInfo.getMessage2());
		
		return tutoObj;
	}
	
	//TutoInfo를 하나씩 JSONObject로 만든 것을 JSONArray 에 넣어줍니다.
	public JSONArray ConvertTutoData2Json() {
		int tutoSize = TutoInfoList.getTutoInfoSize();

		//아래의 JSONObject들을 넣어줄 JSONArray를 만들어줍니다.
		JSONArray tutoArray = new JSONArray();

		//TutoInfoList 의 크기만큼 JSONObject 들을 만들어줍니다.
		for (int i = 0; i < tutoSize; i++) {
			JSONObject tutoObj = new JSONObject();
								
			//리스트의 정보들을 하나씩 찾습니다.
			TutoInfo tutoInfo = TutoInfoList.findTutoInfo(i);

			//JSONObject를 만들어줍니다.
			tutoObj = CreateTutoJSONObject(tutoObj, tutoInfo);
		
			//JSONArray에, 만들어진 JSONObject를 추가해줍니다.
	   		tutoArray.add(tutoObj);
		}
				
		return tutoArray;
	}
	
	public void SumLikeTutorial(String param_branch) {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			TutorialDAO tutorialDAO = TutorialDAO.getInstance();

			//입력받은 branch로 TUTORIAL_LIKE에서 id값에 해당하는 like_count++
			tutorialDAO.UpdateTutorialLike(conn, param_branch);
			
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
