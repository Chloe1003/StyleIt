package web.dto;

public class ProductCategory {
	
	private int pca_no;
	private String p_category;
	
	public int getPca_no() {
		return pca_no;
	}
	public void setPca_no(int pca_no) {
		this.pca_no = pca_no;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	@Override
	public String toString() {
		return "ProductCategory [pca_no=" + pca_no + ", p_category=" + p_category + "]";
	}
	
	


}
