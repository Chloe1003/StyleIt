package web.dao.face;

import java.util.List;

import web.dto.Banner;

public interface MainDao {
	
	//배너 정보 가져오기
	public List<Banner> selectBanner();

}
