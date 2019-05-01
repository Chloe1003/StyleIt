package web.service.face;

import java.util.List;

import web.dto.StylingComment;
import web.dto.StylingLike;
import web.dto.StylingTag;

public interface StylingService {
	
//	스타일링 태그 얻어오기
	public List<StylingTag> getStylingTag();
	
//	스타일링 리스트 얻어오기
	public List getStylingList();
//	스타일링 상세보기
	public void getStylingView(int s_no);
//	스타일링 좋아요 
	public void StylingLikeInsert(StylingLike sLike);
//	스타일링 좋아요 삭제
	public void StylingLikeDelete(StylingLike sLike);
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
	
	
}
