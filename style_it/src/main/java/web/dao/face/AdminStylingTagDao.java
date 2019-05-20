package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.StylingTag;
import web.util.Paging;

public interface AdminStylingTagDao {
	
	//스타일링 태그 리스트
	public List<StylingTag> selectStylingTagList(Paging paging);
	
	//스타일링 태그 총게시글 수 반환
	public int selectCntStylingTag();
	
	//스타일링 태그 파일 추가
	public void fileUploadInsert(HashMap<String, Object> map);
	
	//스타일링 태그 파일넘버
	public int fileUploadNo(HashMap<String, Object> map);
	
	//스타일링 태그 추가
	public void stylingTagInsert(HashMap<String, Object> map);
	
	//스타일링 태그 수정
	public void stylingTagUpdate(HashMap<String, Object> map);
	
	//스타일링 태그 파일 수정
	public void fileUploadUpdate(HashMap<String, Object> map);
	
	//스타일링 태그 파일 수정 넘버 
	public int fileNo(HashMap<String, Object> map);
}
