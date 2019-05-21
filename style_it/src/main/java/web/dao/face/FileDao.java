package web.dao.face;

import java.util.List;

import web.dto.UploadFile;

public interface FileDao {

	//파일 업로드 기록 저장
	public void insert(UploadFile upFile);

	//파일 전체 조회
	public List selectAll();
	
	//지정된 fileno의 파일 조회
	public UploadFile selectByFileno(int fileno);
	
}





















