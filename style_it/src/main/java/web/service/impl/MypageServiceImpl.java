package web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MypageDao;

import web.dto.FileUpload;
import web.dto.Follow;
import web.dto.Member;

import web.dto.MemberQuiz;
import web.dto.MemberQuizSet;
import web.dto.Message;
import web.dto.Product;
import web.dto.ProductBrand;
import web.dto.ProductCategory;
import web.dto.ProductColor;
import web.dto.ProductLike;
import web.dto.ProductOccasion;
import web.dto.ProductPattern;
import web.dto.ProductStyle;
import web.dto.QuizQuestion;
import web.dto.Styling;
import web.dto.StylingLike;
import web.service.face.MypageService;


@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired MypageDao mypageDao;
//	유저 정보 조회
	@Override
	public Member getUserInfo(Member member) {
		return mypageDao.getUserInfo(member);
	}
//	비밀번호 확인
	@Override
	public int checkPass(Member member) {
		if( mypageDao.checkPass(member) == 1) {
			return 1;
		}else {
			return 0;
		}
		
	}
//	비밀번호 변경
	@Override
	public void changePass(Member member) {
		mypageDao.changePass(member);
	}
//	nick 변경
	@Override
	public void changeNick(Member member) {
		mypageDao.changeNick(member);
	}
//	프로필 사진 삽입
	@Override
	public void insertImg(FileUpload fu) {
		mypageDao.insertImg(fu);
	}
//	유저 사진 업데이트
	@Override
	public void updateUserImg(Member member) {
		mypageDao.updateUserImg(member);
	}
//	고객 다음 사진 번호 받아오기
	@Override
	public int dualNo() {
		
		return mypageDao.dualNo();
	}
//	회원 탈퇴
	@Override
	public void deleteUser(Member member) {
		 mypageDao.deleteUser(member);
	}
//	팔로우 숫자 뿌리기
	@Override
	public int getFollower(Member member) {
		return mypageDao.getFollower(member);
	}
//	팔로잉 숫자 뿌리기
	@Override
	public int getFollowee(Member member) {
		return mypageDao.getFollowee(member);
	}
//	스타일링 숫자 뿌리기
	@Override
	public int getCoStyling(Member member) {
		return mypageDao.getCoStyling(member);
	}
//	컬렉션 숫자 뿌리기
	@Override
	public int getCoCollection(Member member) {
		return mypageDao.getCoCollection(member);
	}
//	본인이 체크한 모든 좋아요 수 
	@Override
	public int getCoLike(Member member) {
		return mypageDao.getCoLike(member);
	}
//	팔로우 리스트
	@Override
	public List<Member> getFollowList(int m_no) {
		return mypageDao.getFollowList(m_no);
	}
//	팔로잉 리스트
	@Override
	public List<Member> getFollowingList(int m_no) {
		return mypageDao.getFollowingList(m_no);
	}
//	내가 좋아요한 상품 리스트
	@Override
	public List<Product> getProLikeList(int m_no) {
		return mypageDao.getProLikeList(m_no);
	}
//	내가 만든 스타일링 리스트
	@Override
	public List<Product> getStylingList(int m_no) {
		return mypageDao.getStylingList(m_no);
	}
//	유저가 좋아요한 스타일링 리스트
	@Override
	public List<Product> getStylingLikeList(int m_no) {
		return mypageDao.getStylingLikeList(m_no);
	}
//	유저가 좋아요한 상품 리스트
	@Override
	public List<Product> getMemProLikeList(HashMap<String, Object> map) {
		return mypageDao.getMemProLikeList(map);
	}
//	세션 유저 프로필
	@Override
	public String getUserImg(String m_nick) {
		return mypageDao.getUserImg(m_nick);
	}
//	안읽은 메세지 총 수
	@Override
	public int getCountAllRead(Message message) {
		return mypageDao.getCountAllRead(message);
	}
	
	
	

	@Override
	public List<Product> getRecommendProduct(MemberQuizSet mq) {				
		return mypageDao.selectRecommendProduct(mq);
	}

  	@Override
	public List<MemberQuiz> getMemberQuiz(int m_no) {
		return mypageDao.selectMemberQuiz(m_no);
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

  
	@Override
	public MemberQuizSet transferToMemberQuizSet(List<MemberQuiz> answer) {
		MemberQuizSet mqs = new MemberQuizSet();
		MemberQuiz mq = new MemberQuiz();
		
		for(int i=0; i<answer.size(); i++) {
			mq= answer.get(i);
			if(mq.getQq_no()==1) {
				mqs.setP_gender(mq.getMq_answer());
			} else if(mq.getQq_no()==2) {
				mqs.getPo_no().add(mq.getMq_answer());
			} else if(mq.getQq_no()==3) {
				mqs.getPb_no().add(mq.getMq_answer());
			} else if(mq.getQq_no()==4) {
				mqs.getPs_no().add(mq.getMq_answer());
			} else if(mq.getQq_no()==5) {
				mqs.getPca_no().add(mq.getMq_answer());
			} else if(mq.getQq_no()==6) {
				mqs.getPco_no().add(mq.getMq_answer());
			} else if(mq.getQq_no()==7) {
				mqs.getPp_no().add(mq.getMq_answer());
			} else if(mq.getQq_no()==8) {
				mqs.getPrice().add(mq.getMq_answer());
			}
		}

		int p1 = mqs.getPrice().get(0);
		int p2 = mqs.getPrice().get(1);
		
		if(p2>p1) {
			mqs.setP_lowprice(p1);
			mqs.setP_highprice(p2);
		} else {
			mqs.setP_lowprice(p2);
			mqs.setP_highprice(p1);
		}
		
		return mqs;		
	}
	
	

	//---------yoon---------//

	@Override
	public List<ProductLike> getProductLikeList() {				
		return mypageDao.getProductLikeList();
	}
	
//	@Override
//	public List<StylingLike> getStylingLikeList() {				
//		return mypageDao.getStylingLikeList();
//	}
	
//	@Override
//	public List<Styling> getStylingList(int m_no) {
//		return mypageDao.getStylingList(m_no);
//	}
	
	@Override
	public int getCountStyling(int m_no) {
		return mypageDao.selectCountStyling(m_no);
	}
	@Override
	public int getCountProduct(int m_no) {
		return mypageDao.selectCountProduct(m_no);
	}

	
}

