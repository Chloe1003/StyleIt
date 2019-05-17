package web.service.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Banner;
import web.util.Paging;

public interface AdminBannerService {
	


	
	// 전체 게시글 수
	public int getTotalCount();
	
	//스타일링 태그 추가
	public void bannerInsert(HashMap<String, Object> map);
	
	//스타일링 태그 수정
	public void bannerUpdate(HashMap<String, Object> map);

	// 전체 리스트
	public List<Banner> getPagingBannerList(Paging paging);


	

}
