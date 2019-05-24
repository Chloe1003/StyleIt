package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminProductColorDao;
import web.dto.ProductColor;
import web.service.face.AdminProductColorService;
import web.util.Paging;

@Service
public class AdminProductColorServiceImpl implements AdminProductColorService {
	@Autowired AdminProductColorDao fd;

	@Override
	public List<HashMap> getPagingProductColorList(Paging paging) {
		return fd.selectPagingList(paging);
	}

	@Override
	public int getTotalCount() {
		return fd.selectCntProductColor();
	}

	@Override
	public ProductColor fal(ProductColor productColor) {
		return fd.fal(productColor);
	}

	@Override
	public void insert(ProductColor productColor) {
		fd.insert(productColor);
	}

	@Override
	public void update(ProductColor productColor) {
		fd.update(productColor);
		
	}

	@Override
	public void delete(ProductColor productColor) {
		fd.delete(productColor);
		
	}

	@Override
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map) {
		return fd.selectSearchPagingList(map);
	}

	@Override
	public int getSearchCount(String word) {
		return fd.selectCntSearchProductColor(word);
	}

	@Override
	public void disable(ProductColor pc) {
		 fd.disable(pc);
	}
	
	@Override
	public void able(ProductColor pc) {
		 fd.able(pc);
	}


	

}
