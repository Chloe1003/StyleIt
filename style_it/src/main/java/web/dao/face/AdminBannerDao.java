package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Banner;
import web.util.Paging;

public interface AdminBannerDao {

	// 전체 리스트 
	public List<Banner> selectBannerList(Paging paging);
	
	
	// 해당 배너글
	public Banner select(int b_no);
	
	// 배너 추가
	public void add(Banner banner);
	
	// 배너 수정
	public void update(Banner banner);
	
	// 배너 삭제
	public void delete(Banner banner);


	public void fileUploadInsert(HashMap<String, Object> map);


	public int fileUploadNo(HashMap<String, Object> map);


	public void bannerInsert(HashMap<String, Object> map);


	public void bannerUpdate(HashMap<String, Object> map);


}
