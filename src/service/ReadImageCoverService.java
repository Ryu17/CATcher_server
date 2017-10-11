package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.ImageCoverDAO;
import data.ImageCover;
import dataList.image.Cover;

//리스트 정보들을 DB에서 불러오는 클래스입니다.
public class ReadImageCoverService {
	
	private static ReadImageCoverService readImageCoverService = new ReadImageCoverService();
	
	public static ReadImageCoverService getInstance () {
		return readImageCoverService;
	}
	
	private ReadImageCoverService() {}

	//DB에서 접근해서 가져온 값들을 ImageCover List에 저장합니다.
	public void ConvertDB2Data() {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			ImageCoverDAO imageCoverDAO = ImageCoverDAO.getInstance();
			
			ImageCover imageCover = null;
			int id = 1;
						
			//카테고리 시리얼 넘버에 따라서 쿼리 결과값을 ImageCover형태로 가져옵니다.
			imageCover = imageCoverDAO.selectByImageCover(conn, id);
			
			//ImageCover들을 다 지워줍니다.
			Cover.clearImageCover();
			
			while(imageCover != null)
			{
				Cover.addImageCover(imageCover);

				//imageCover가 null일 때까지 반복.
				id = id + 1;
				imageCover = imageCoverDAO.selectByImageCover(conn, id);
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
