package web.service.face;

import java.util.HashMap;
import java.util.List;
import web.dto.ProductCategory;
import web.dto.Product;
import web.dto.Styling;
import web.dto.StylingComment;
import web.dto.StylingTag;

public interface StylingService {
	
//	스타일링 태그 얻어오기
	public List<StylingTag> getStylingTag();
	
//	로그인 시 태그에 해당하는 스타일링 리스트 얻어오기
	public List<Styling> getStylingList(HashMap<String, Integer> map);
	
//	비 로그인시 태그에 해당하는 스타일링 리스트 얻어오기
	public List<Styling> getStylingListNoLogin(int st_no);
	
//	로그인시 스타일링 상세보기
	public Styling getStylingView(HashMap<String, Integer> map);
	
//	비 로그인시 스타일링 상세보기
	public Styling getStylingViewNoLogin(int s_no);

//	스타일링 좋아요  업데이트
	public void sLikeUpdate(HashMap<String, Object> like);
	
//	스타일링별 좋아요 개수 반환
	public int slikeCnt(int s_no);

//	좋아요 여부 확인
	public int slikeCheck(HashMap<String, Object> like);
	
//	로그인시 스타일링별 제품 정보 얻어오기
	public List<Product> getProductByStyling(HashMap<String, Integer> map);

//	비로그인시 스타일링별 제품 정보 얻어오기
	public List<Product> getProductByStylingNoLogin(int s_no);

	//	콜렉션 추가
	public void CollectionInsert(int cs_no);
//	콜렉션 제거
	public void CollectionDelete(int cs_no);
//	스타일링 코맨트 등록
	public void CommentInsert(int s_no);
//	스타일링 코멘트 제거
	public void CommentDelete(int s_no);
//	스타일링 코맨트 리스트 
	public void getStylingCommentList(StylingComment sComment);

	// 스타일링 제품 카테고리 리스트
	public List<ProductCategory> getProductCategory();
	
	// 스타일링 제품 리스트
	public List<HashMap> getProduct(HashMap<String, Object> map);
	
	// 스타일링 제품 수
	public int getSearchCount(HashMap<String, Object> map);
	
	// 스타일링 저장
	public void stylingInsert(HashMap<String, Object> map);
	
	
	
}


