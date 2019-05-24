package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductColor;
import web.util.Paging;

public interface AdminProductColorDao {
	
	// 전체 리스트 
	public List<HashMap> selectPagingList(Paging paging);
	
	// 총 게시물 
	public int selectCntProductColor();
	
	// 해당 글
	public ProductColor select(int pco_no);
	
	// 글 추가
	public void insert(ProductColor productColor);
	
	// 글 수정
	public void update(ProductColor productColor);
	
	// 글 삭제
	public void delete(ProductColor productColor);
	
	// 글 본문 찾기
	public ProductColor fal(ProductColor productColor);
	
	// 검색 페이징 처리
	public List<HashMap> selectSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수
	public int selectCntSearchProductColor(String word);

}
