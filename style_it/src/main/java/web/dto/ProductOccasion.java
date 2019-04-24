package web.dto;

public class ProductOccasion {

	
	private int po_no;
	private String po_name;
	
	public int getPo_no() {
		return po_no;
	}
	public void setPo_no(int po_no) {
		this.po_no = po_no;
	}
	public String getPo_name() {
		return po_name;
	}
	public void setPo_name(String po_name) {
		this.po_name = po_name;
	}
	@Override
	public String toString() {
		return "ProductOccasion [po_no=" + po_no + ", po_name=" + po_name + "]";
	}
	
	

}
