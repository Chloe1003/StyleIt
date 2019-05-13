package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Product;
import web.dto.ProductCategory;
import web.util.Paging;

public interface AdminProductDao {
	
	// 페이징 처리된 제품 리스트 반환
	public List<HashMap> selectProductList(Paging paging);
	
	// 페이징 처리된 제품 카테고리, 브랜드 필터링 리스트 반환
	public List<HashMap> selectFilteredList(HashMap<String, Integer> map);
	
	// 페이징 처리된 검색 제품 리스트 반환
	public List<HashMap> selectSearchedList(HashMap<String, Object> map);
	
	// 제품 상세 정보 반환
	public Product selectProduct(int p_no);
	
	//스타일링 태그 파일 추가
	public void fileUploadInsert(HashMap<String, Object> map);
	
	//스타일링 태그 파일넘버
	public int fileUploadNo(HashMap<String, Object> map);
	
	// 제품 추가
	public void insertProduct(HashMap<String, Object> map);
	
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
	
	// 검색된 제품 수
	public int selectSearchCount(HashMap<String, Object> map);
	
	// 총 제품 수
	public int selectProductCnt();
	
	// 제품 카테고리
	public List<HashMap> selectpcaList();
	
	// 제품 브랜드
	public List<HashMap> selectpbList();
	
	// 제품 색
	public List<HashMap> selectpcList();
	
	// 제품 태그
	public List<HashMap> selectpoList();
	public List<HashMap> selectppList();
	public List<HashMap> selectpsList();
	
}
