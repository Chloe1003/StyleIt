package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminProductPatternDao;
import web.dto.ProductPattern;
import web.service.face.AdminProductPatternService;
import web.util.Paging;

@Service
public class AdminProductPatternServiceImpl implements AdminProductPatternService {
	@Autowired AdminProductPatternDao fd;

	@Override
	public List<HashMap> getPagingProductPatternList(Paging paging) {
		return fd.selectPagingList(paging);
	}

	@Override
	public int getTotalCount() {
		return fd.selectCntProductPattern();
	}

	@Override
	public ProductPattern fal(ProductPattern productPattern) {
		return fd.fal(productPattern);
	}

	@Override
	public void insert(ProductPattern productPattern) {
		fd.insert(productPattern);
	}

	@Override
	public void update(ProductPattern productPattern) {
		fd.update(productPattern);
		
	}

	@Override
	public void delete(ProductPattern productPattern) {
		fd.delete(productPattern);
		
	}

	@Override
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map) {
		return fd.selectSearchPagingList(map);
	}

	@Override
	public int getSearchCount(String word) {
		return fd.selectCntSearchProductPattern(word);
	}


	

}
