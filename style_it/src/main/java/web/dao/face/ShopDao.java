package web.dao.face;

import java.util.List;

import web.dto.Product;

public interface ShopDao {

	public List<Product> getList();

	public Product view(int p_no);

//	//페이지 조회
//	public List<Product> getSearchList();
//	
//	//추천 추가
//	public int recommendInsert();
//	
//	//추천 삭제
//	public int recommendDelete();
//	
//	//콜렉션추가
//	public String collectionInsert();
//	
//	//콜렉션 삭제
//	public String collectionDelete();
	
	//상세페이지 조회
//	public List<Styling> getStylingList();
	
}
