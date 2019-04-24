package web.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.dto.Product;
import web.service.face.AdminProductService;

@Controller
public class AdminProductController {
	
	public AdminProductService apServ;
	private static final Logger logger=LoggerFactory.getLogger(AdminProductController.class);
	
	// 페이징 처리된 제품 리스트 반환(검색/카테고리&브랜드 필터링 처리)
	@RequestMapping(value="/admin/product/list")
	public void productList(Model model, String search, int pca_no, int pb_no, @RequestParam HashMap<String, Object> map) {
	
	}
	
	// 제품 상세 보기
	@RequestMapping(value="/admin/product/detail")
	public void productPage(int p_no, Model model) {
	
	}
	
	// 제품 정보 수정 폼 반환
	@RequestMapping(value="/admin/product/update", method=RequestMethod.GET)
	public void productUpdateForm(int p_no, Model model) {
	
	}
	
	// 제품 정보 수정
	@RequestMapping(value="/admin/product/update", method=RequestMethod.POST)
	public String productUpdate(Product product) {
		return null;
	}
	
	// 제품 추가 폼 반환
	@RequestMapping(value="/admin/product/add", method=RequestMethod.GET)
	public void productAddForm() {
	
	}
	
	// 제품 추가
	@RequestMapping(value="/admin/product/add", method=RequestMethod.POST)
	public String productAdd(Product product) {
	
		return null;
	}
	
	// 제품 삭제
	@RequestMapping(value="/admin/product/delete")
	public String productDelete(int p_no) {

		return null;
	}
	
	// 제품 속성 리스트 반환
	@RequestMapping(value="/admin/pAttribute/list", method=RequestMethod.GET)
	public void productAttributeList() {
	
	}
	
	// 페이징 처리된 선택 제품 속성의 리스트 반환(검색 처리)
	@RequestMapping(value="/admin/pAttribute/list", method=RequestMethod.POST)
	public void productAttributeList(String attributeType, String search, Model model, @RequestParam HashMap<String, Object> map) {
	
	}
	
	// 선택 제품 속성 추가
	@RequestMapping(value="/admin/pAttribute/add")
	public void productAttributeAdd(String attributeType, String name) {
	
	}
	
	// 선택 제품 속성 수정
	@RequestMapping(value="/admin/pAttribute/update")
	public void productAttributeUpdate(String attributeType, String name) {
	
	}
	
	// 선택 제품 속성 삭제
	@RequestMapping(value="/admin/pAttribute/delete")
	public void productAttributeDelete(String attributeType, int attribute_no) {
	
	}
	
}
