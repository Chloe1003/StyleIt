package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductOccasion;
import web.util.Paging;

public interface AdminProductOccasionDao {
	
	// 전체 리스트 
	public List<HashMap> selectPagingList(Paging paging);
	
	// 총 게시물 
	public int selectCntProductOccasion();
	
	// 해당 글
	public ProductOccasion select(int po_no);
	
	// 글 추가
	public void insert(ProductOccasion productOccasion);
	
	// 글 수정
	public void update(ProductOccasion productOccasion);
	
	// 글 삭제
	public void delete(ProductOccasion productOccasion);
	
	// 글 본문 찾기
	public ProductOccasion fal(ProductOccasion productOccasion);
	
	// 검색 페이징 처리
	public List<HashMap> selectSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수
	public int selectCntSearchProductOccasion(String word);

}
