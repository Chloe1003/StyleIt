package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.controller.AdminStylingTagController;
import web.dao.face.StylingDao;
import web.dto.Styling;
import web.dto.StylingComment;
import web.dto.StylingLike;
import web.dto.StylingTag;
import web.service.face.StylingService;
@Service
public class StylingServiceImpl implements StylingService{
	@Autowired StylingDao sDao;
	private static final Logger logger = LoggerFactory.getLogger(StylingServiceImpl.class);
	
	@Override
	public List<Styling> getStylingList(HashMap<String, Integer> map) {
		return sDao.selectStylingList(map);
	}

	@Override
	public List<StylingTag> getStylingTag() {
		return sDao.selectStylingTag();
	}

	@Override
	public void sLikeUpdate(HashMap<String, Object> like) {
		if(sDao.slikeCheck(like)>0) { // 이미 좋아요 누름
			sDao.slikeDelete(like);
		} else {
			sDao.slikeInsert(like);
		}
		
	}

	@Override
	public int slikeCnt(int s_no) {
		return sDao.slikeCnt(s_no);
	}

	@Override
	public int slikeCheck(HashMap<String, Object> like) {
		return sDao.slikeCheck(like);
	}

	@Override
	public Styling getStylingView(HashMap<String, Integer> map) {
		return sDao.getStylingView(map);
	}

	@Override
	public Styling getStylingViewNoLogin(int s_no) {
		return sDao.getStylingViewNoLogin(s_no);
	}
	
	@Override
	public void CollectionInsert(int cs_no) {
		sDao.CollectionInsert(cs_no);
	}

	@Override
	public void CollectionDelete(int cs_no) {
		sDao.CollectionDelete(cs_no);
	}

	@Override
	public void CommentInsert(int s_no) {
		sDao.CommentInsert(s_no);
	}

	@Override
	public void CommentDelete(int s_no) {
		sDao.CommentDelete(s_no);
	}

	@Override
	public void getStylingCommentList(StylingComment sComment) {
		sDao.getStylingCommentList(sComment);
	}

	@Override
	public List<Styling> getStylingListNoLogin(int st_no) {
		return sDao.selectStylingListNoLogin(st_no);
	}

	@Override
	public List<StylingTag> getStylingTagList() {
		
		return sDao.selectStylingTagList();
	}

	@Override
	public void stylingTagInsert(HashMap<String, Object> map) {
		
		logger.info("map : " + map);
		logger.info("map.get : "+ map.get("st_name"));
		logger.info("map.get : "+ map.get("stored_name"));
		sDao.fileUploadInsert(map);
		int no = sDao.fileUploadNo(map);
		map.put("no", no);
		logger.info("map2 : " + map);
		sDao.stylingTagInsert(map);
	}

	@Override
	public void stylingTagUpdate(HashMap<String, Object> map) {
		logger.info("map : " + map);
		logger.info("map.get : "+ map.get("st_name"));
		logger.info("map.get : "+ map.get("stored_name"));
		if (map.get("stored_name") == null) {
			logger.info("비었당");
			sDao.stylingTagUpdate(map);
		} else {
			logger.info("안비었당");
			sDao.fileUploadInsert(map);
			int no = sDao.fileUploadNo(map);
			map.put("no", no);
			sDao.stylingTagUpdate(map);
		}
	}

//	@Override
//	public void stylingTagDelete(StylingTag st) {
//		sDao.stylingTagDelete(st);
//		
//	}
}
