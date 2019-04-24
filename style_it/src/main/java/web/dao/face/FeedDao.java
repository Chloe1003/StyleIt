package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Feed;

public interface FeedDao {

	// feed 좋아요순 리스트 반환
	public List<Feed> selectAll();
	
	// feed 팔로우한 사용자 리스트 반환
	public List<Feed> selectFollow(int m_no);
	
	// 제품 좋아요 추가
	public void insertProductLike(HashMap<String, Integer> map);
	
	// 스타일링 좋아요 추가
	public void insertStylingLike(HashMap<String, Integer> map);
	
	// 컬렉션 좋아요 추가
	public void insertCollectionLike(HashMap<String, Integer> map);
	
	// 제품 좋아요 취소
	public void deleteProductLike(int plike_no);
	
	// 스타일링 좋아요 취소
	public void deleteStylingLike(int slike_no);
	
	// 컬렉션 좋아요 취소
	public void deleteCollectionLike(int clike_no);
	
	// 컬렉션에 추가
	public void insertToCollection(HashMap<String, Integer> map);
	
}
