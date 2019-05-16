package web.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminStylingTagDao;
import web.dto.StylingTag;
import web.service.face.AdminStylingTagService;
import web.util.Paging;

@Service
public class AdminStylingTagServiceImpl implements AdminStylingTagService {
	private static final Logger logger = LoggerFactory.getLogger(AdminStylingTagServiceImpl.class);
	@Autowired AdminStylingTagDao astd;

	@Override
	public List<StylingTag> getPagingTagList(Paging paging) {
		return astd.selectStylingTagList(paging);
	}

	@Override
	public int getTotalCount() {
		return astd.selectCntStylingTag();
	}

	@Override
	public void stylingTagInsert(HashMap<String, Object> map) {
		logger.info("map : " + map);
		logger.info("map.get : "+ map.get("st_name"));
		logger.info("map.get : "+ map.get("stored_name"));
		astd.fileUploadInsert(map);
		int no = astd.fileUploadNo(map);
		map.put("no", no);
		logger.info("map2 : " + map);
		astd.stylingTagInsert(map);
		
	}

	@Override
	public void stylingTagUpdate(HashMap<String, Object> map) {
		logger.info("map : " + map);
		logger.info("map.get : "+ map.get("st_name"));
		logger.info("map.get : "+ map.get("stored_name"));
		if (map.get("stored_name") == null) {
			logger.info("비었당");
			astd.stylingTagUpdate(map);
		} else {
			logger.info("안비었당");
			astd.fileUploadInsert(map);
			int no = astd.fileUploadNo(map);
			map.put("no", no);
			astd.stylingTagUpdate(map);
		}
	}


}
