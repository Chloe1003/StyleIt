package web.dto;

public class ProductPattern {
	
	private int pp_no;
	private String pp_name;
	
	public int getPp_no() {
		return pp_no;
	}
	public void setPp_no(int pp_no) {
		this.pp_no = pp_no;
	}
	public String getPp_name() {
		return pp_name;
	}
	public void setPp_name(String pp_name) {
		this.pp_name = pp_name;
	}
	@Override
	public String toString() {
		return "ProductPattern [pp_no=" + pp_no + ", pp_name=" + pp_name + "]";
	}
	
	


}
