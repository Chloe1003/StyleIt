package web.service.impl;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MypageDao;
import web.dto.MemberQuiz;
import web.dto.MemberQuizSet;
import web.dto.Product;
import web.dto.ProductBrand;
import web.dto.ProductCategory;
import web.dto.ProductColor;
import web.dto.ProductOccasion;
import web.dto.ProductPattern;
import web.dto.ProductStyle;
import web.dto.QuizQuestion;
import web.service.face.MypageService;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired MypageDao mypageDao;
	
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
	public List<Product> getRecommendProduct(int m_no) {
		
		List<MemberQuiz> mq = mypageDao.selectMemberQuiz(m_no);
		
		
		
		return null;
	}

	@Override
	public List<MemberQuiz> getMemberQuiz(int m_no) {
		return null;
	}

	@Override
	public List<QuizQuestion> getStylingQuiz() {
		return mypageDao.selectStylingQuiz();
	}

	@Override
	public List<ProductBrand> getBrand() {
		return mypageDao.selectBrand();
	}

	@Override
	public List<ProductCategory> getCategory() {
		return mypageDao.selectCategory();
	}

	@Override
	public List<ProductColor> getColor() {
		return mypageDao.selectColor();
	}

	@Override
	public List<ProductOccasion> getOccasion() {
		return mypageDao.selectOccasion();
	}

	@Override
	public List<ProductPattern> getPattern() {
		return mypageDao.selectPattern();
	}

	@Override
	public List<ProductStyle> getStyle() {
		return mypageDao.selectStyle();
	}

	@Override
	public void saveMemberQuiz(MemberQuizSet mq) {
//		mypageDao.insertMemberQuiz(mq);
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("m_no", mq.getM_no());
		
		mypageDao.insertMemberQuizGender(mq);
		
		for(int pca_no : mq.getPca_no()) {
			map.put("pca_no", pca_no);	
			mypageDao.insertMemberQuizCategory(map);
		}
		
		for(int pco_no : mq.getPco_no()) {
			map.put("pco_no", pco_no);
			mypageDao.insertMemberQuizColor(map);		
		}
		
		for(int pb_no : mq.getPb_no()) {
			map.put("pb_no", pb_no);
			mypageDao.insertMemberQuizBrand(map);
		}
		
		for(int po_no : mq.getPo_no()) {
			map.put("po_no", po_no);
			mypageDao.insertMemberQuizOccasion(map);
		}
		
		for(int ps_no : mq.getPs_no()) {
			map.put("ps_no", ps_no);
			mypageDao.insertMemberQuizStyle(map);			
		}
		
		for(int pp_no : mq.getPp_no()) {
			map.put("pp_no", pp_no);
			mypageDao.insertMemberQuizPattern(map);
		}
		
		mypageDao.insertMemberQuizLprice(mq);
		mypageDao.insertMemberQuizHprice(mq);
	}

}
