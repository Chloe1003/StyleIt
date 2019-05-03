package web.service.face;

import java.util.List;

import web.dto.Product;
import web.dto.Styling;

public interface ShopService {

	public List<Product> getList();

	public Product view(int p_no);

	public List<Styling> list(int p_no);

	
//	//SHOP List 출력
//	public List<Product> selectSearchList();
//	
//	//추천or추천삭제
//	public int recommend();
//	
//	//콜렉션추가or삭제
//	public String collection();
//	
//	//상세페이지 List출력
//	public List<Styling> getStylingList();
	
}
