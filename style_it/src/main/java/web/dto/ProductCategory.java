package web.dto;

public class ProductCategory {
	
	private int pca_no;
	private String pca_category;

	public int getPca_no() {
		return pca_no;
	}
	public void setPca_no(int pca_no) {
		this.pca_no = pca_no;
	}

	public String getPca_category() {
		return pca_category;
	}
	public void setPca_category(String pca_category) {
		this.pca_category = pca_category;
	}
	@Override
	public String toString() {
		return "ProductCategory [pca_no=" + pca_no + ", pca_category=" + pca_category + "]";
	}
	
	


}
