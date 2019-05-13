package web.service.face;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Product;
import web.dto.ProductCategory;
import web.util.Paging;

public interface AdminProductService{
	
	// 페이징 처리된 제품 리스트 반환
	public List<HashMap> getProductList(Paging paging);
	
	// 현재페이지 반환
	public int getCurPage(HttpServletRequest req);
	
	// 총 제품 수 얻기
	public int getTotalCount();
	
	// 페이징 처리된 제품 카테고리, 브랜드 필터링 리스트 반환
	public List<HashMap> getFilteredList(HashMap<String, Integer> map);
	
	// 페이징 처리된 검색 제품 리스트 반환
	public List<HashMap> getSearchedList(HashMap<String, Object> map);
	
	// 제품 상세 정보 반환
	public Product getProduct(int p_no);
	
	// 제품 추가
	public void addProduct(HashMap<String, Object> map);
	
	// 제품 정보 수정
	public void updateProduct(Product p);
	
	// 제품 삭제
	public void deleteProduct(int p_no);
	
	// 페이징 처리된 선택 제품 속성 리스트 반환
	public List getProductAttributeList(HashMap<String, Object> map);
	
	// 선택 제품 속성 추가
	public void addProductAttribute(HashMap<String, String> map);
	
	// 선택 제품 속성 수정
	public void updateProductAttribute(HashMap<String, String> map);
	
	// 선택 제품 속성 삭제
	public void deleteProductAttribute(HashMap<String, Object> map);
	
	// 페이징 처리된 선택 제품 속성 검색	
	public List getSearchedProductAttribute(HashMap<String, String> map);
	
	// 검색된 선택 제품 속성 갯수 반환
	public int cntProductByProductAttribute(HashMap<String, String> map);
	
	// 검색된 제품 수 반환
	public int getSearchCount(HashMap<String, Object> map);
	
	// 제품 카테고리 검색
	public List<HashMap> getpcaList();
	
	// 제품 브랜드 검색
	public List<HashMap> getpbList();
	
	// 제품 색 리스트
	public List<HashMap> getpcList();
	
	//제품 태그 리스트
	public List<HashMap> getpoList();
	public List<HashMap> getppList();
	public List<HashMap> getpsList();

}
	

