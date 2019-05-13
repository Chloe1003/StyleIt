package web.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminProductDao;
import web.dto.Product;
import web.dto.ProductCategory;
import web.service.face.AdminProductService;
import web.util.Paging;

@Service
public class AdminProductServiceImpl implements AdminProductService {
	
	private static final Logger logger=LoggerFactory.getLogger(AdminProductServiceImpl.class);
	@Autowired AdminProductDao apd;

	@Override
	public List<HashMap> getProductList(Paging paging) {
		return apd.selectProductList(paging);
	}

	@Override
	public int getCurPage(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCount() {
		return apd.selectProductCnt();
	}

	@Override
	public List<HashMap> getFilteredList(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap> getSearchedList(HashMap<String, Object> map) {
		return apd.selectSearchedList(map);
	}

	@Override
	public Product getProduct(int p_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(HashMap<String, Object> map) {
		logger.info("map : " + map);
		logger.info("map.get : "+ map.get("stored_name"));
		apd.fileUploadInsert(map);
		int no = apd.fileUploadNo(map);
		map.put("no", no);
		logger.info("mapInsert : "+map);
		apd.insertProduct(map);
		
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int p_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getProductAttributeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProductAttribute(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductAttribute(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductAttribute(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getSearchedProductAttribute(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cntProductByProductAttribute(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSearchCount(HashMap<String, Object> map) {
		logger.info("map : "+map);
		if( map.get("word")==null) {
			map.put("word", "");
			return apd.selectSearchCount(map);
		} else {
		return apd.selectSearchCount(map);
		}
	}

	@Override
	public List<HashMap> getpcaList() {
		return apd.selectpcaList();
	}
	
	@Override
	public List<HashMap> getpbList() {
		return apd.selectpbList();
	}

	@Override
	public List<HashMap> getpcList() {
		return apd.selectpcList();
	}

	@Override
	public List<HashMap> getpoList() {
		return apd.selectpoList();
	}

	@Override
	public List<HashMap> getppList() {
		return apd.selectppList();
	}

	@Override
	public List<HashMap> getpsList() {
		return apd.selectpsList();
	}

	

}
