package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.StylingTag;
import web.util.Paging;

public interface AdminStylingTagService {
	
	// 전체 리스트
	public List<StylingTag> getTagList(Paging paging);
	
	// 현재 페이지 수
	public int getCurPage(HttpServletRequest req);
	
	// 전체 게시글 수
	public int getTotalCount();
	
	// 태그 추가
	public void insert(StylingTag stylingTag);
		
	// 태그 수정
	public void update(StylingTag stylingTag);
		
	// 태그 삭제
	public void delete(StylingTag stylingTag); 
	

}
