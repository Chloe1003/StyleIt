package web.service.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductOccasion;
import web.util.Paging;

public interface AdminProductOccasionService {
	
	// pco 전체 리스트
	public List<HashMap> getPagingProductOccasionList(Paging paging);
	
	// 총 게시물 수 얻기
	public int getTotalCount();
	
	// 게시글 본문 찾기
	public ProductOccasion fal(ProductOccasion productOccasion);
	
	// 게시글 추가
	public void insert(ProductOccasion productOccasion);
	
	// 게시글 수정
	public void update(ProductOccasion productOccasion);
	
	// 게시글 삭제
	public void delete(ProductOccasion productOccasion);

	// 검색 페이징 처리
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수 얻기
	public int getSearchCount(String word);
	
}
