package web.dto;

public class ProductColor {
	
	private int pco_no;
	private String pco_name;
	private String pco_able;
	
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
	public String getPco_able() {
		return pco_able;
	}
	public void setPco_able(String pco_able) {
		this.pco_able = pco_able;
	}
	@Override
	public String toString() {
		return "ProductColor [pco_no=" + pco_no + ", pco_name=" + pco_name + ", pco_able=" + pco_able + "]";
	}
	
	


}
