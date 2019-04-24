package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import web.dto.Faq;
import web.service.face.AdminFaqService;
import web.util.Paging;

@Service
public class AdminFaqServiceImpl implements AdminFaqService {

	@Override
	public List<Faq> getFaqList(Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurPage(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Faq view(int faq_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Faq faq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Faq faq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Faq faq) {
		// TODO Auto-generated method stub
		
	}

	

}
