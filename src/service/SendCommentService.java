package service;

import java.sql.Connection;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.SendCommentInfoService;
import dao.CommentInfoDAO;
import connection.ConnectionProvider;
import connection.JdbcUtil;

//댓글 정보로 만들어진 JSON을 하나로 합치는 클래스입니다.
public class SendCommentService {
	public JSONObject ConvertData2Json() {
		
		//댓글 JSON 을 넣어줄 JSONObject를 만들어줍니다.
		JSONObject commentListObject = new JSONObject();
		
		SendCommentInfoService sendCommentInfoService = new SendCommentInfoService();
		JSONArray listJsonArray = sendCommentInfoService.ConvertListData2Json();
		
		commentListObject.put("Comment", listJsonArray);
		
		return commentListObject;
	}
	
	// group_id와 nickname으로 등록된 댓글을 찾아,
	// 1) 있으면 지우고 등록, 2) 없으면 바로 등록을 해줍니다.
	public void CommentEnrollment(String group_id, String imgname, String nickname,
								  String comments, String date)
	{
		Connection conn = null;
		
		// 있으면 1, 없으면 0
		int commentcheck = 0;
		
		try {	
			conn = ConnectionProvider.getConnection();
			
			CommentInfoDAO commentInfoDAO = CommentInfoDAO.getInstance();

			//입력받은 댓글이 찾아지는지 검사합니다.
			commentcheck = commentInfoDAO.CheckComment(conn, group_id, nickname);
			
			//댓글을 입력했었다면 기존 것을 지우고 다시 등록
			if (commentcheck == 1)
			{
				System.out.println("COMMENT EXIST");
				
				commentInfoDAO.DeleteComment(conn, group_id, nickname);
				commentInfoDAO.InsertComment(conn, group_id, imgname, nickname, comments, date);
			}
			//입력안했었다면 바로 등록
			else if(commentcheck == 0)
			{
				System.out.println("COMMENT NOT EXIST");
				
				commentInfoDAO.InsertComment(conn, group_id, imgname, nickname, comments, date);
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
	}
}
