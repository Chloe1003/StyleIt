package web.service.face;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.dto.Banner;
import web.dto.Faq;
import web.dto.Styling;
import web.util.Paging;

public interface MainService {
	
	// 배너 정보 가져오기
	public List<HashMap> getBannerList();
	
	// 오늘의 스타일링 리스트 가져오기
	public List<HashMap> getStylingList();
	
	// 인기제품 리스트 가져오기
	public List<HashMap> getBestProduct();
	
	// FAQ리스트 가져오기
	public List<HashMap> getFaqList(HashMap<String, Object> map);

	// 게시글 본문 찾기
	public Faq fal(Faq faq);
	
	//검색 게시글 얻기
	public int getSearchCount(HashMap<String, Object> map);
	
	// 총 게시물 수 얻기
	public int getTotalCount();
	
	// FAQ 전체 리스트
	public List<HashMap> getPagingFaqList(Paging paging);
}


