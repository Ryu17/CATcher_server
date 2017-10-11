package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.ImageListDAO;
import data.ImageList;
import dataList.image.List;

//리스트 정보들을 DB에서 불러오는 클래스입니다.
public class ReadImageListService {
	
	private static ReadImageListService readImageListService = new ReadImageListService();
	
	public static ReadImageListService getInstance () {
		return readImageListService;
	}
	
	private ReadImageListService() {}

	//DB에서 접근해서 가져온 값들을 ImageList List에 저장합니다.
	public void ConvertDB2Data() {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			ImageListDAO imageListDAO = ImageListDAO.getInstance();
			
			ImageList imageList = null;
			int id = 1;
						
			//카테고리 시리얼 넘버에 따라서 쿼리 결과값을 ImageList형태로 가져옵니다.
			imageList = imageListDAO.selectByImageList(conn, id);
			
			//ImageList들을 다 지워줍니다.
			List.clearImageList();
			
			while(imageList != null)
			{
				List.addImageList(imageList);

				//imageList가 null일 때까지 반복.
				id = id + 1;
				imageList = imageListDAO.selectByImageList(conn, id);
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
