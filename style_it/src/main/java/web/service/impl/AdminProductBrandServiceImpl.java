package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminProductBrandDao;
import web.dto.ProductBrand;
import web.service.face.AdminProductBrandService;
import web.util.Paging;

@Service
public class AdminProductBrandServiceImpl implements AdminProductBrandService {
	@Autowired AdminProductBrandDao fd;

	@Override
	public List<HashMap> getPagingProductBrandList(Paging paging) {
		return fd.selectPagingList(paging);
	}

	@Override
	public int getTotalCount() {
		return fd.selectCntProductBrand();
	}

	@Override
	public ProductBrand fal(ProductBrand productBrand) {
		return fd.fal(productBrand);
	}

	@Override
	public void insert(ProductBrand productBrand) {
		fd.insert(productBrand);
	}

	@Override
	public void update(ProductBrand productBrand) {
		fd.update(productBrand);
		
	}

	@Override
	public void delete(ProductBrand productBrand) {
		fd.delete(productBrand);
		
	}

	@Override
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map) {
		return fd.selectSearchPagingList(map);
	}

	@Override
	public int getSearchCount(String word) {
		return fd.selectCntSearchProductBrand(word);
	}


	

}
