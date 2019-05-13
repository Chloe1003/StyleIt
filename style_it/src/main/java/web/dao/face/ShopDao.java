package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Product;
import web.dto.ProductOccasion;
import web.dto.ProductStyle;
import web.dto.Styling;
import web.util.imgPaging;

public interface ShopDao {

	public List<Product> getList();
	
//	제품번호로 제품 정보 가져오기
	public Product selectProduct(int p_no);

//	로그인시 제품 리스트 얻어오기
	public List<Product> selectProductList(HashMap<String, Object> map);
	
//	좋아요 여부 확인
	public int plikeCheck(HashMap<String, Object> like);

//	제품 좋아요  삭제
	public void plikeDelete(HashMap<String, Object> like);

//	제품 좋아요 
	public void plikeInsert(HashMap<String, Object> like);

//	해당 제품의 좋아요 수 반환
	public int plikeCnt(int p_no);

//	로그인시 제품 상세보기	
	public Product selectProductView(HashMap<String, Integer> map);
	
//	비로그인시 제품 상세보기	
	public Product selectProductViewNoLogin(int p_no);

//	로그인시 제품별 스타일링 정보 얻어오기
	public List<Styling> selectStylingByProduct(HashMap<String, Integer> map);

//	비로그인시 제품별 스타일링 정보 얻어오기
	public List<Styling> selectStylingByProductNoLogin(int p_no);
	
//	로그인시 유사한 제품 정보 얻어오기(5개)
	public List<Product> selectSimilarProduct(HashMap<String, Object> map);

//	비로그인시 유사한 제품 정보 얻어오기(5개)
	public List<Product> selectSimilarProductNoLogin(Product p);

//	총 제품 수 반환
	public int totalCnt();
	
//	제품 상황 카테고리 얻어오기
	public List<ProductOccasion> selectProductOccasion();
	
//	제품 스타일 카테고리 얻어오기
	public List<ProductStyle> selectProductStyle();

//	//페이지 조회
//	public List<Product> getSearchList();
//	
//	//추천 추가
//	public int recommendInsert();
//	
//	//추천 삭제
//	public int recommendDelete();
//	
//	//콜렉션추가
//	public String collectionInsert();
//	
//	//콜렉션 삭제
//	public String collectionDelete();
	
	//상세페이지 조회
//	public List<Styling> getStylingList();
	
}
