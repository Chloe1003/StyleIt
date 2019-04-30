package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import web.dto.Collection;
import web.service.face.CollectionService;
import web.util.Paging;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Override
	public List<Collection> getCollectionList(Paging paging) {
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
	public Collection view(int cf_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Collection collection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Collection collection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Collection collection) {
		// TODO Auto-generated method stub
		
	}

}
