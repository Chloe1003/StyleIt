package web.service.face;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Faq;
import web.util.Paging;

public interface AdminFaqService {
	
	// FAQ 전체 리스트
	public List<HashMap> getFaqList();
	
	// 현재 페이지 얻기
	public int getCurPage(HttpServletRequest req);
	
	// 총 게시물 수 얻기
	public int getTotalCount();
	
	// 게시글 상세보기
	public Faq view(int faq_no);
	
	// 게시글 추가
	public void insert(Faq faq);
	
	// 게시글 수정
	public void update(Faq faq);
	
	// 게시글 삭제
	public void delete(Faq faq);

}
