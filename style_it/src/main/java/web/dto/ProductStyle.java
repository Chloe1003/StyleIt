package web.dto;

public class ProductStyle {
	
	private int ps_no;
	private String ps_name;
	
	public int getPs_no() {
		return ps_no;
	}
	public void setPs_no(int ps_no) {
		this.ps_no = ps_no;
	}
	public String getPs_name() {
		return ps_name;
	}
	public void setPs_name(String ps_name) {
		this.ps_name = ps_name;
	}
	@Override
	public String toString() {
		return "ProductStyle [ps_no=" + ps_no + ", ps_name=" + ps_name + "]";
	}
	
	


}
