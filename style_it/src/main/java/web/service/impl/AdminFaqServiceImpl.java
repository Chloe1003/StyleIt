package web.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminFaqDao;
import web.dto.Faq;
import web.service.face.AdminFaqService;
import web.util.Paging;

@Service
public class AdminFaqServiceImpl implements AdminFaqService {
	@Autowired AdminFaqDao fd;

	@Override
	public List<HashMap> getPagingFaqList(Paging paging) {
		return fd.selectPagingList(paging);
	}

	@Override
	public int getTotalCount() {
		return fd.selectCntFaq();
	}

	@Override
	public Faq fal(Faq faq) {
		return fd.fal(faq);
	}

	@Override
	public void insert(Faq faq) {
		fd.insert(faq);
	}

	@Override
	public void update(Faq faq) {
		fd.update(faq);
		
	}

	@Override
	public void delete(Faq faq) {
		fd.delete(faq);
		
	}

	@Override
	public List<HashMap> getSearchPagingList(HashMap<String, Object> map) {
		return fd.selectSearchPagingList(map);
	}

	@Override
	public int getSearchCount(String word) {
		return fd.selectCntSearchFaq(word);
	}


	

}
