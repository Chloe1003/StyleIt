package web.service.face;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.StylingTag;
import web.util.Paging;

public interface AdminStylingTagService {
	
	// 전체 리스트
	public List<StylingTag> getPagingTagList(Paging paging);
	
	// 전체 게시글 수
	public int getTotalCount();
	
	//스타일링 태그 추가
	public void stylingTagInsert(HashMap<String, Object> map);
	
	//스타일링 태그 수정
	public void stylingTagUpdate(HashMap<String, Object> map);
	

}
