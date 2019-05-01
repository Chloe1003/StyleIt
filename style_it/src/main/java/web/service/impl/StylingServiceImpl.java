package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.StylingDao;
import web.dto.Styling;
import web.dto.StylingComment;
import web.dto.StylingLike;
import web.dto.StylingTag;
import web.service.face.StylingService;
@Service
public class StylingServiceImpl implements StylingService{
	@Autowired StylingDao sDao;
	
	@Override
	public List<Styling> getStylingList(int st_no) {
		return sDao.selectStylingList(st_no);
	}

	@Override
	public void getStylingView(int s_no) {
		sDao.getStylingView(s_no);
	}

	@Override
	public void StylingLikeInsert(StylingLike sLike) {
		sDao.StylingLikeInsert(sLike);
	}

	@Override
	public void StylingLikeDelete(StylingLike sLike) {
		sDao.StylingLikeDelete(sLike);
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
	public List<StylingTag> getStylingTag() {
		return sDao.selectStylingTag();
	}

}
