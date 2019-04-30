package web.dao.face;

import java.util.List;

import web.dto.Collection;
import web.util.Paging;

public interface CollectionDao {
	
	// 전체 리스트
	public List<Collection> selectAll(Paging paging);

	// 총 게시물 
	public int selectCntCollection();
	
	// 해당 폴더
	public Collection select(int cf_no);
	
	// 추가
	public void insert(Collection collection);
		
	// 수정
	public void update(Collection collection);
		
	// 삭제
	public void delete(Collection collection);
		
}
