package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Product;
import web.dto.Styling;

public interface ShopDao {

	public List<Product> getList();

	public Product view(int p_no);


//	로그인시 제품 리스트 얻어오기
	public List<Product> selectProductList(int m_no);
	
//	비로그인시 제품 리스트 얻어오기
	public List<Product> selectProductListNoLogin();

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
