package web.dto;

public class ProductColor {
	
	private int pco_no;
	private String pco_name;
	
	public int getPco_no() {
		return pco_no;
	}
	public void setPco_no(int pco_no) {
		this.pco_no = pco_no;
	}

	public String getPco_name() {
		return pco_name;
	}
	public void setPco_name(String pco_name) {
		this.pco_name = pco_name;
	}
	@Override
	public String toString() {
		return "ProductColor [pco_no=" + pco_no + ", pco_name=" + pco_name + "]";
	}
	
	


}
