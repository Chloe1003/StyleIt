package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Product;
import web.util.Paging;

public interface AdminProductDao {
	
	// 페이징 처리된 제품 리스트 반환
	public List<Product> selectProductList(Paging paging);
	
	// 페이징 처리된 제품 카테고리, 브랜드 필터링 리스트 반환
	public List<Product> selectFilteredList(HashMap<String, Integer> map);
	
	// 페이징 처리된 검색 제품 리스트 반환
	public List<Product> selectSearchedList(HashMap<String, Object> map);
	
	// 제품 상세 정보 반환
	public Product selectProduct(int p_no);
	
	// 제품 추가
	public void insertProduct(Product p);
	
	// 제품 정보 수정
	public void updateProduct(Product p);
	
	// 제품 삭제
	public void deleteProduct(int p_no);
	
	// 페이징 처리된 선택 제품 속성 리스트 반환
	public List selectProductAttributeList(HashMap<String, Object> map);
		
	// 페이징 처리된 선택 제품 속성 검색	
	public List selectSearchedProductAttribute(HashMap<String, String> map);
	
	// 선택 제품 속성 추가
	public void insertProductAttribute(HashMap<String, String> map);
	
	// 선택 제품 속성 수정
	public void updateProductAttribute(HashMap<String, String> map);
	
	// 선택 제품 속성 삭제
	public void deleteProductAttribute(HashMap<String, Object> map);
	
	// 검색된 선택 제품 속성 갯수 반환
	public int cntProductByProductAttribute(HashMap<String, String> map);
}
