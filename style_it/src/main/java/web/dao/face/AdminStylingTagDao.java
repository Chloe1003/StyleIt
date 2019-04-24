package web.dao.face;

import java.util.List;

import web.dto.StylingTag;
import web.util.Paging;

public interface AdminStylingTagDao {
	
	// 전체 리스트
	public List<StylingTag> selectTagList(Paging paging);
	
	// 총 게시물 
	public int selectCntTag();
		
	// 태그 추가
	public void insert(StylingTag stylingTag);
			
	// 태그 수정
	public void update(StylingTag stylingTag);
			
	// 태그 삭제
	public void delete(StylingTag stylingTag); 

}
