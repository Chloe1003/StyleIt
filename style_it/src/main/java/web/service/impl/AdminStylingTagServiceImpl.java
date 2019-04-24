package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import web.dto.StylingTag;
import web.service.face.AdminStylingTagService;
import web.util.Paging;

@Service
public class AdminStylingTagServiceImpl implements AdminStylingTagService {

	@Override
	public List<StylingTag> getTagList(Paging paging) {
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
	public void insert(StylingTag stylingTag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StylingTag stylingTag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StylingTag stylingTag) {
		// TODO Auto-generated method stub
		
	}


}
