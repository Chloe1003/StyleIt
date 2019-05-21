package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductPattern;
import web.util.Paging;

public interface AdminProductPatternDao {
	
	// 전체 리스트 
	public List<HashMap> selectPagingList(Paging paging);
	
	// 총 게시물 
	public int selectCntProductPattern();
	
	// 해당 글
	public ProductPattern select(int pp_no);
	
	// 글 추가
	public void insert(ProductPattern productPattern);
	
	// 글 수정
	public void update(ProductPattern productPattern);
	
	// 글 삭제
	public void delete(ProductPattern productPattern);
	
	// 글 본문 찾기
	public ProductPattern fal(ProductPattern productPattern);
	
	// 검색 페이징 처리
	public List<HashMap> selectSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수
	public int selectCntSearchProductPattern(String word);

}
