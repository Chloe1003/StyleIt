package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminProductOccasionDao;
import web.dto.ProductOccasion;
import web.service.face.AdminProductOccasionService;
import web.util.Paging;

@Service
public class AdminProductOccasionServiceImpl implements AdminProductOccasionService {
	@Autowired AdminProductOccasionDao fd;

	@Override
	public List<HashMap> getPagingProductOccasionList(Paging paging) {
		return fd.selectPagingList(paging);
	}

	@Override
	public int getTotalCount() {
		return fd.selectCntProductOccasion();
	}

	@Override
	public ProductOccasion fal(ProductOccasion productOccasion) {
		return fd.fal(productOccasion);
	}

	@Override
	public void insert(ProductOccasion productOccasion) {
		fd.insert(productOccasion);
	}

	@Override
	public void update(ProductOccasion productOccasion) {
		fd.update(productOccasion);
		
	}

	@Override
	public void delete(ProductOccasion productOccasion) {
		fd.delete(productOccasion);
		
	}

	@Override
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map) {
		return fd.selectSearchPagingList(map);
	}

	@Override
	public int getSearchCount(String word) {
		return fd.selectCntSearchProductOccasion(word);
	}


	

}
