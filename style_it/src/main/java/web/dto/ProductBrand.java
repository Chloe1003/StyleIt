package web.dto;

public class ProductBrand {

	private int pb_no;
	private String pb_name;
	private int order;
	
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getPb_no() {
		return pb_no;
	}
	public void setPb_no(int pb_no) {
		this.pb_no = pb_no;
	}
	public String getPb_name() {
		return pb_name;
	}
	public void setPb_name(String pb_name) {
		this.pb_name = pb_name;
	}
	@Override
	public String toString() {
		return "ProductBrand [pb_no=" + pb_no + ", pb_name=" + pb_name + "]";
	}
	
	

	
}
