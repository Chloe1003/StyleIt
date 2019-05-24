package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminBannerDao;
import web.dto.Banner;
import web.service.face.AdminBannerService;
import web.util.Paging;

@Service
public class AdminBannerServiceImpl implements AdminBannerService {
	private static final Logger logger = LoggerFactory.getLogger(AdminBannerServiceImpl.class);
	@Autowired AdminBannerDao astd;

	@Override
	public List<Banner> getPagingBannerList(Paging paging) {
		return astd.selectBannerList(paging);
	}

	@Override
	public void bannerInsert(HashMap<String, Object> map) {
		logger.info("map : " + map);
		logger.info("map.get : "+ map.get("b_name"));
		logger.info("map.get : "+ map.get("stored_name"));
		astd.fileUploadInsert(map);
		int no = astd.fileUploadNo(map);
		map.put("no", no);
		logger.info("map2 : " + map);
		astd.bannerInsert(map);
		
	}

	@Override
	public void bannerUpdate(HashMap<String, Object> map) {
		logger.info("map : " + map);
		logger.info("map.get : "+ map.get("b_name"));
		logger.info("map.get : "+ map.get("stored_name"));
		if (map.get("stored_name") == null) {
			logger.info("비었습니다");
			astd.bannerUpdate(map);
		} else {
			logger.info("안비었습니다");
			astd.fileUploadInsert(map);
			int no = astd.fileUploadNo(map);
			map.put("no", no);
			astd.bannerUpdate(map);
		}
	}

	@Override
	public int getTotalCount() {
		return astd.selectCntBanner();
	}

	@Override
	public void bannerDelete(int b_no) {
		astd.delete(b_no);
	}


}
