package web.service.face;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.dto.Banner;
import web.dto.Styling;

public interface MainService {
	
	// 배너 정보 가져오기
	public List<HashMap> getBannerList();
	
	// 오늘의 스타일링 리스트 가져오기
	public List<HashMap> getStylingList();
	
	// 인기제품 리스트 가져오기
	public List<HashMap> getBestProduct();

//	// 배너 추가하기
//	public void bannerWrite(HttpServletRequest req);
//
//	// bannerno 가져오기
//	public int getBannerNo();
//
//	// 배너 정보 가져오기
//	public MainBanner getBanner(int bannerno);
//
//	// 배너 정보 수정하기
//	public void updateBanner(HttpServletRequest req);
//
//	// 배너 정보 삭제하기
//	public void del(int parseInt);

}
