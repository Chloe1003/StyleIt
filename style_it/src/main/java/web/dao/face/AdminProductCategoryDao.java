package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductCategory;
import web.util.Paging;

public interface AdminProductCategoryDao {
	
	// 전체 리스트 
	public List<HashMap> selectPagingList(Paging paging);
	
	// 총 게시물 
	public int selectCntProductCategory();
	
	// 해당 글
	public ProductCategory select(int pco_no);
	
	// 글 추가
	public void insert(ProductCategory productCategory);
	
	// 글 수정
	public void update(ProductCategory productCategory);
	
	// 글 삭제
	public void delete(ProductCategory productCategory);
	
	// 글 본문 찾기
	public ProductCategory fal(ProductCategory productCategory);
	
	// 검색 페이징 처리
	public List<HashMap> selectSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수
	public int selectCntSearchProductCategory(String word);

}
