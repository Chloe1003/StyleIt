package web.dao.face;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.dto.Banner;
import web.dto.Faq;
import web.dto.Styling;
import web.util.Paging;

public interface MainDao {
	
	//배너 정보 가져오기
	public List<HashMap> selectBanner();
	
	//오늘의 스타일링 리스트 가져오기
	public List<HashMap> selectStyling();

	//인기 제품 리스트 가져오기
	public List<HashMap> selectBestProduct();
	
	//FAQ 리스트 가져오기
	public List<HashMap> selectFaqList(HashMap<String, Object> map);
	
	// 글 본문 찾기
	public Faq fal(Faq faq);
	
	//검색 게시글 얻기
	public int selectSearchCount(HashMap<String, Object> map);
	
	// 총 게시물 
	public int selectCntFaq();
	
	// 전체 리스트 
	public List<HashMap> selectPagingList(Paging paging);
}
