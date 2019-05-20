package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Product;
import web.dto.ProductCategory;
import web.dto.Styling;
import web.dto.StylingComment;
import web.dto.StylingTag;

public interface StylingDao {

//	스타일링 태그 가져오기
	List<StylingTag> selectStylingTag();
	
//	로그인 시 스타일링 리스트 얻어오기
	public List<Styling> selectStylingList(HashMap<String, Integer> map);
	
//	비 로그인 시 스타일링 리스트 얻어오기
	List<Styling> selectStylingListNoLogin(int st_no);
	
//	좋아요 여부 확인
	public int slikeCheck(HashMap<String, Object> like);
	
//	스타일링 좋아요 
	public void slikeInsert(HashMap<String, Object> like);
	
//	스타일링 좋아요 삭제
	public void slikeDelete(HashMap<String, Object> like);
	
//	해당 스타일링의 좋아요 수 반환
	public int slikeCnt(int s_no);
	
	
//	로그인시 스타일링 상세보기
	public Styling getStylingView(HashMap<String, Integer> map);
	
//	비 로그인시 스타일링 상세보기
	public Styling getStylingViewNoLogin(int s_no);
	
//	로그인시 스타일링별 제품 정보 가져오기
	public List<Product> selectProductByStyling(HashMap<String, Integer> map);

//	비로그인시 스타일링별 제품 정보 가져오기
	public List<Product> selectProductByStylingNoLogin(int s_no);
	
	
	// 스타일링 제품 카테고리 리스트
	public List<ProductCategory> selectProductCategory();
	
	// 스타일링 제품 리스트
	public List<HashMap> selectProduct(HashMap<String, Object> map);
	
	// 스타일링 제품 수
	public int selectSearchCount(HashMap<String, Object> map);
	
	// 스타일링 이미지 저장
	public void fileUploadInsert(HashMap<String, Object> map);
	
	// 파일 번호 구하기
	public int fileUploadNo(HashMap<String, Object> map);
	
	public void selectStylingInsert(HashMap<String, Object> map);

	// 코멘트 목록 가져오기
	public List<StylingComment> selectComments(int s_no);

	// 코멘트 삽입하기
	void insertComment(HashMap<String, Object> map);

	// 코멘트 삭제하기
	void deleteComment(int co_no);

	
}
