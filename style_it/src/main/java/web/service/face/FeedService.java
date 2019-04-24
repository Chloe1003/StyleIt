package web.service.face;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import web.dto.Feed;

public interface FeedService {

	// feed 좋아요순 리스트 반환
	public List<Feed> getFeedList();
	
	// feed 팔로우한 사용자 리스트 반환
	public List<Feed> getFollowList(int m_no);
	
	// 제품 좋아요 추가
	public void addProductLike(HashMap<String, Integer> map);
	
	// 스타일링 좋아요 추가
	public void addStylingLike(HashMap<String, Integer> map);
	
	// 컬렉션 좋아요 추가
	public void addCollectionLike(HashMap<String, Integer> map);
	
	// 제품 좋아요 취소
	public void deleteProductLike(int plike_no);
	
	// 스타일링 좋아요 취소
	public void deleteStylingLike(int slike_no);
	
	// 컬렉션 좋아요 취소
	public void deleteCollectionLike(int clike_no);
	
	// 컬렉션에 추가
	public void addToCollection(HashMap<String, Integer> map);
}
