package web.dao.face;

import java.util.List;

import web.dto.StylingComment;
import web.dto.StylingLike;

public interface StylingDao {
//	스타일링 리스트 얻어오기
	List getStylingList();
//	스타일링 상세보기
	void getStylingView(int s_no);
//	스타일링 좋아요 
	void StylingLikeInsert(StylingLike sLike);
//	스타일링 좋아요 삭제
	void StylingLikeDelete(StylingLike sLike);
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

}
