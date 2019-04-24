package web.dto;

public class ProductColor {
	
	private int pco_no;
	private String pc_name;
	
	public int getPco_no() {
		return pco_no;
	}
	public void setPco_no(int pco_no) {
		this.pco_no = pco_no;
	}
	public String getPc_name() {
		return pc_name;
	}
	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}
	@Override
	public String toString() {
		return "ProductColor [pco_no=" + pco_no + ", pc_name=" + pc_name + "]";
	}
	
	


}
