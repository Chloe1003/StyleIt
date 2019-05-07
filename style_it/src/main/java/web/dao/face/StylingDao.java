package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Styling;
import web.dto.StylingComment;
import web.dto.StylingLike;
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
	
	
//	콜렉션 추가
	void CollectionInsert(int cs_no);
//	콜렉션 제거
	void CollectionDelete(int cs_no);
//	스타일링 코맨트 등록
	void CommentInsert(int s_no);
//	스타일링 코멘트 제거
	void CommentDelete(int s_no);
//	스타일링 코맨트 리스트 
	void getStylingCommentList(StylingComment sComment);

	//스타일링 태그 리스트
	public List<StylingTag> selectStylingTagList();
	
	//스타일링 태그 파일 추가
	public void fileUploadInsert(HashMap<String, Object> map);
	
	//스타일링 태그 파일넘버
	public int fileUploadNo(HashMap<String, Object> map);
	
	//스타일링 태그 추가
	public void stylingTagInsert(HashMap<String, Object> map);
	




}
