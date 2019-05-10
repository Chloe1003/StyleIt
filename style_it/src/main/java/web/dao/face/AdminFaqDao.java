package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Faq;
import web.util.Paging;

public interface AdminFaqDao {
	
	// 전체 리스트 
	public List<HashMap> selectPagingList(Paging paging);
	
	// 총 게시물 
	public int selectCntFaq();
	
	// 해당 글
	public Faq select(int faq_no);
	
	// 글 추가
	public void insert(Faq faq);
	
	// 글 수정
	public void update(Faq faq);
	
	// 글 삭제
	public void delete(Faq faq);
	
	// 글 본문 찾기
	public Faq fal(Faq faq);
	
	// 검색 페이징 처리
	public List<HashMap> selectSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수
	public int selectCntSearchFaq(String word);

}
