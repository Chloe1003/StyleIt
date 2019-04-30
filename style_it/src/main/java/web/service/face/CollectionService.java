package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Collection;
import web.util.Paging;

public interface CollectionService {
	
	// 컬렉션 리스트
	public List<Collection> getCollectionList(Paging paging);
	
	// 현재 페이지 얻기
	public int getCurPage(HttpServletRequest req);
	
	// 총 게시물 수 얻기
	public int getTotalCount();
	
	// 상세보기
	public Collection view(int cf_no);
	
	// 추가
	public void insert(Collection collection);
		
	// 수정
	public void update(Collection collection);
		
	// 삭제
	public void delete(Collection collection);
}
