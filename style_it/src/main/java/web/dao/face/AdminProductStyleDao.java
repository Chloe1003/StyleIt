package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductStyle;
import web.util.Paging;

public interface AdminProductStyleDao {
	
	// 전체 리스트 
	public List<HashMap> selectPagingList(Paging paging);
	
	// 총 게시물 
	public int selectCntProductStyle();
	
	// 해당 글
	public ProductStyle select(int ps_no);
	
	// 글 추가
	public void insert(ProductStyle productStyle);
	
	// 글 수정
	public void update(ProductStyle productStyle);
	
	// 글 삭제
	public void delete(ProductStyle productStyle);
	
	// 글 본문 찾기
	public ProductStyle fal(ProductStyle productStyle);
	
	// 검색 페이징 처리
	public List<HashMap> selectSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수
	public int selectCntSearchProductStyle(String word);

}
