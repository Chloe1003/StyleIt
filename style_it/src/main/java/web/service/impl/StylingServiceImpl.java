package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.StylingDao;
import web.dto.StylingComment;
import web.dto.StylingLike;
import web.service.face.StylingService;
@Service
public class StylingServiceImpl implements StylingService{
	@Autowired StylingDao stylingDao;
	
	@Override
	public List getStylingList() {
		return stylingDao.getStylingList();
	}

	@Override
	public void getStylingView(int s_no) {
		stylingDao.getStylingView(s_no);
	}

	@Override
	public void StylingLikeInsert(StylingLike sLike) {
		stylingDao.StylingLikeInsert(sLike);
	}

	@Override
	public void StylingLikeDelete(StylingLike sLike) {
		stylingDao.StylingLikeDelete(sLike);
	}

	@Override
	public void CollectionInsert(int cs_no) {
		stylingDao.CollectionInsert(cs_no);
	}

	@Override
	public void CollectionDelete(int cs_no) {
		stylingDao.CollectionDelete(cs_no);
	}

	@Override
	public void CommentInsert(int s_no) {
		stylingDao.CommentInsert(s_no);
	}

	@Override
	public void CommentDelete(int s_no) {
		stylingDao.CommentDelete(s_no);
	}

	@Override
	public void getStylingCommentList(StylingComment sComment) {
		stylingDao.getStylingCommentList(sComment);
	}

}
