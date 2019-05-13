package web.service.impl;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MypageDao;
import web.dto.MemberQuiz;
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
	public HashMap<String, Object> getStylingQuizAnswer() {
		HashMap<String, Object> answer = new HashMap<>();
		
		List<ProductBrand> brand = mypageDao.selectBrand();
		List<ProductCategory> category = mypageDao.selectCategory();
 		List<ProductColor> color = mypageDao.selectColor();
		List<ProductOccasion> occasion = mypageDao.selectOccasion();
		List<ProductPattern> pattern = mypageDao.selectPattern();
		List<ProductStyle> style = mypageDao.selectStyle();
		
		answer.put("brand", brand);
		answer.put("category", category);
		answer.put("color", color);
		answer.put("occasion", occasion);
		answer.put("pattern", pattern);
		answer.put("style", style);
		
		return answer;
	}

}
