package web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MainDao;
import web.dto.Banner;
import web.dto.Styling;
import web.service.face.MainService;

@Service 
public class MainServiceImpl implements MainService {
	@Autowired MainDao mainDao;

	@Override
	public List<HashMap> getBannerList() {
		return mainDao.selectBanner();
	}

	@Override
	public List<HashMap> getStylingList() {
		return mainDao.selectStyling();
	}

	@Override
	public List<HashMap> getBestProduct() {
		return mainDao.selectBestProduct();
	}

		
	
}
