package service;

import java.sql.Connection;
import java.sql.SQLException;
import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.CategoryInfoDAO;
import data.CategoryInfo;
import dataList.category.NewInfoList;
import dataList.category.RecommendInfoList;
import dataList.category.RomanceInfoList;
import dataList.category.ThrillerInfoList;

//카테고리 정보들을 DB에서 불러오는 클래스입니다.
public class ReadCategoryInfoService {
	
	private static ReadCategoryInfoService readCategoryInfoService = new ReadCategoryInfoService();
	
	public static ReadCategoryInfoService getInstance () {
		return readCategoryInfoService;
	}
	
	private ReadCategoryInfoService() {}

	//DB에서 접근해서 가져온 값들을 CategoryInfoList에 저장합니다.
	public void ConvertDB2Data() {
		Connection conn = null;
		
		try {	
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false);
			
			CategoryInfoDAO categoryInfoDAO = CategoryInfoDAO.getInstance();
			
			CategoryInfo categoryInfo = null;
			int category_serial = 1;
			
			//카테고리별 리스트를 지워줍니다.
			RecommendInfoList.clearRecommendInfoList();
			RomanceInfoList.clearRomanceInfoList();
			ThrillerInfoList.clearThrillerInfoList();
			NewInfoList.clearNewInfoList();
			
			//카테고리 시리얼 넘버에 따라서 쿼리 결과값을 categoryInfo형태로 가져옵니다.
			categoryInfo = categoryInfoDAO.selectByCategorySerial(conn, category_serial);
			
			while(categoryInfo != null)
			{				
				//테스트 출력.
				//System.out.println("category id :" + categoryInfo.getCategory_id() + " and title : " + categoryInfo.getTitle());
				
				//category_id값에 따라-
				switch(categoryInfo.getCategory_id()) {
				//RECOMMEND 0 ROMANCE 1 THRILLER 2 NEW 3
				//category_id값이 0이면 RecommendInfoList에 categoryInfo를 저장해줍니다.
				//category_id값이 1이면 RomanceInfoList에 categoryInfo를 저장해줍니다.
				//category_id값이 2이면 ThrillerInfoList에 categoryInfo를 저장해줍니다.
				//category_id값이 3이면 NewInfoList에 categoryInfo를 저장해줍니다.
				case 0 	: RecommendInfoList.addRecommendInfo(categoryInfo); break;
				case 1	: RomanceInfoList.addRomanceInfo(categoryInfo);break;
				case 2	: ThrillerInfoList.addThrillerInfo(categoryInfo);break;
				case 3	: NewInfoList.addNewInfo(categoryInfo);break;
				default	: break;
				}
				//categoryInfo가 null일 때까지 반복.
				category_serial = category_serial + 1;
				categoryInfo = categoryInfoDAO.selectByCategorySerial(conn, category_serial);
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
