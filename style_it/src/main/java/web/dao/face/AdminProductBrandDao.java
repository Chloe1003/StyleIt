package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.ProductBrand;
import web.util.Paging;

public interface AdminProductBrandDao {
	
	// 전체 리스트 
	public List<HashMap> selectPagingList(Paging paging);
	
	// 총 게시물 
	public int selectCntProductBrand();
	
	// 해당 글
	public ProductBrand select(int pb_no);
	
	// 글 추가
	public void insert(ProductBrand productBrand);
	
	// 글 수정
	public void update(ProductBrand productBrand);
	
	// 글 삭제
	public void delete(ProductBrand productBrand);
	
	// 글 본문 찾기
	public ProductBrand fal(ProductBrand productBrand);
	
	// 검색 페이징 처리
	public List<HashMap> selectSearchPagingList(HashMap<String, Object> map);
	
	// 검색 게시물 수
	public int selectCntSearchProductBrand(String word);

}
