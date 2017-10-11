package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.ImageSpeakerDAO;
import data.ImageSpeaker;
import dataList.image.Speaker;

//리스트 정보들을 DB에서 불러오는 클래스입니다.
public class ReadImageSpeakerService {

	private static ReadImageSpeakerService readImageSpeakerService = new ReadImageSpeakerService();
	
	public static ReadImageSpeakerService getInstance () {
		return readImageSpeakerService;
	}
	
	private ReadImageSpeakerService() {}

	//DB에서 접근해서 가져온 값들을 ImageSpeaker List에 저장합니다.
	public void ConvertDB2Data() {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			ImageSpeakerDAO imageSpeakerDAO = ImageSpeakerDAO.getInstance();
			
			ImageSpeaker imageSpeaker = null;
			int id = 1;
						
			//카테고리 시리얼 넘버에 따라서 쿼리 결과값을 ImageSpeaker형태로 가져옵니다.
			imageSpeaker = imageSpeakerDAO.selectByImageSpeaker(conn, id);
			
			//ImageSpeaker들을 다 지워줍니다.
			Speaker.clearImageSpeaker();
			
			while(imageSpeaker != null)
			{
				Speaker.addImageSpeaker(imageSpeaker);

				//imageSpeaker가 null일 때까지 반복.
				id = id + 1;
				imageSpeaker = imageSpeakerDAO.selectByImageSpeaker(conn, id);
			}
			
		} catch (SQLException e){
			
		} finally {
			if(conn == null) {
				System.out.println("conn is null!");
			} else 
			{
				System.out.println("conn is successful");
				JdbcUtil.close(conn);
			}			
		}
	}
}
