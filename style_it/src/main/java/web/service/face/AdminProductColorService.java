package web.service.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductColor;
import web.util.Paging;

public interface AdminProductColorService {
	
	// pco 전체 리스트
	public List<HashMap> getPagingProductColorList(Paging paging);
	
	// 총 게시물 수 얻기
	public int getTotalCount();
	
	// 게시글 본문 찾기
	public ProductColor fal(ProductColor productColor);
	
	// 게시글 추가
	public void insert(ProductColor productColor);
	
	// 게시글 수정
	public void update(ProductColor productColor);
	
	// 게시글 삭제
	public void delete(ProductColor productColor);

	// 검색 페이징 처리
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수 얻기
	public int getSearchCount(String word);
	
	// 활성 여부 ajax
	public void disable(ProductColor pc);
	
	// 활성 여부 ajax
	public void able(ProductColor pc);
	
}
