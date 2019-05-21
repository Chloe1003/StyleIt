package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminProductCategoryDao;
import web.dto.ProductCategory;
import web.service.face.AdminProductCategoryService;
import web.util.Paging;

@Service
public class AdminProductCategoryServiceImpl implements AdminProductCategoryService {
	@Autowired AdminProductCategoryDao fd;

	@Override
	public List<HashMap> getPagingProductCategoryList(Paging paging) {
		return fd.selectPagingList(paging);
	}

	@Override
	public int getTotalCount() {
		return fd.selectCntProductCategory();
	}

	@Override
	public ProductCategory fal(ProductCategory productCategory) {
		return fd.fal(productCategory);
	}

	@Override
	public void insert(ProductCategory productCategory) {
		fd.insert(productCategory);
	}

	@Override
	public void update(ProductCategory productCategory) {
		fd.update(productCategory);
		
	}

	@Override
	public void delete(ProductCategory productCategory) {
		fd.delete(productCategory);
		
	}

	@Override
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map) {
		return fd.selectSearchPagingList(map);
	}

	@Override
	public int getSearchCount(String word) {
		return fd.selectCntSearchProductCategory(word);
	}


	

}
