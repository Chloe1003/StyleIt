package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MypageDao;
import web.dto.Member;
import web.service.face.MypageService;
@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired MypageDao mypageDao;
	
	@Override
	public Member getUserInfo(Member member) {
		return mypageDao.getUserInfo(member);
	}
	
	
	@Override
	public List getFollowList() {
		return mypageDao.getFollowList();
	}

	@Override
	public List getFollowingList() {
		return mypageDao.getFollowingList();
	}

	@Override
	public List getStylieLikeList() {
		return mypageDao.getStylieLikeList();
	}

	@Override
	public void removeStylieList() {
		mypageDao.removeStylieList();
	}

	@Override
	public List getCollectionLikeList() {
		return mypageDao.getCollectionLikeList();
	}

	@Override
	public void removeCollectionList() {
		mypageDao.removeCollectionList();
	}

	@Override
	public List getProdurctLikeList() {
		return mypageDao.getProdurctLikeList();
	}

	@Override
	public void removeProductLike() {
		mypageDao.removeProductLike();
	}

	@Override
	public List getMypageStyling() {
		return mypageDao.getMypageStyling();
	}

	@Override
	public void insertStyling() {
		mypageDao.insertStyling();
	}

	@Override
	public void updateStyling() {
		mypageDao.updateStyling();
	}

	@Override
	public void deleteStyling() {
		mypageDao.deleteStyling();
	}

	@Override
	public List getMypageCollection() {
		return mypageDao.getMypageCollection();
	}

	@Override
	public void insertCollection() {
		mypageDao.insertCollection();
	}

	@Override
	public void updateCollection() {
		mypageDao.updateCollection();
	}

	@Override
	public void deleteCollection() {
		mypageDao.deleteCollection();
	}

	@Override
	public List getRecommendProduct() {
		return mypageDao.getRecommendProduct();
	}



	
}
