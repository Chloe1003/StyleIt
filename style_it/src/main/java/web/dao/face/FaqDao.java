package web.dao.face;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.dto.Banner;
import web.dto.Styling;

public interface FaqDao {
	
	//배너 정보 가져오기
	public List<HashMap> selectBanner();
	
	//오늘의 스타일링 리스트 가져오기
	public List<HashMap> selectStyling();

	//인기 제품 리스트 가져오기
	public List<HashMap> selectBestProduct();
}
