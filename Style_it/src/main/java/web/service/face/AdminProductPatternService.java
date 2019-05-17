package web.service.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductPattern;
import web.util.Paging;

public interface AdminProductPatternService {
	
	// pco 전체 리스트
	public List<HashMap> getPagingProductPatternList(Paging paging);
	
	// 총 게시물 수 얻기
	public int getTotalCount();
	
	// 게시글 본문 찾기
	public ProductPattern fal(ProductPattern productPattern);
	
	// 게시글 추가
	public void insert(ProductPattern productPattern);
	
	// 게시글 수정
	public void update(ProductPattern productPattern);
	
	// 게시글 삭제
	public void delete(ProductPattern productPattern);

	// 검색 페이징 처리
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수 얻기
	public int getSearchCount(String word);
	
}
