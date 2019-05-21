package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminProductStyleDao;
import web.dto.ProductStyle;
import web.service.face.AdminProductStyleService;
import web.util.Paging;

@Service
public class AdminProductStyleServiceImpl implements AdminProductStyleService {
	@Autowired AdminProductStyleDao fd;

	@Override
	public List<HashMap> getPagingProductStyleList(Paging paging) {
		return fd.selectPagingList(paging);
	}

	@Override
	public int getTotalCount() {
		return fd.selectCntProductStyle();
	}

	@Override
	public ProductStyle fal(ProductStyle productStyle) {
		return fd.fal(productStyle);
	}

	@Override
	public void insert(ProductStyle productStyle) {
		fd.insert(productStyle);
	}

	@Override
	public void update(ProductStyle productStyle) {
		fd.update(productStyle);
		
	}

	@Override
	public void delete(ProductStyle productStyle) {
		fd.delete(productStyle);
		
	}

	@Override
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map) {
		return fd.selectSearchPagingList(map);
	}

	@Override
	public int getSearchCount(String word) {
		return fd.selectCntSearchProductStyle(word);
	}


	

}
