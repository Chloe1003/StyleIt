package web.dto;

public class Product {
	private int p_no;	
	private String p_gender;	
	private int p_pirce;	
	private String p_Sellers;	
	private int pca_no;	
	private int pco_no;	
	private int pb_no;	
	private int po_no;	
	private int pc_no;	
	private int pp_no;	
	private int p_name;	
	private int p_size;	
	private int p_picture;
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_gender() {
		return p_gender;
	}
	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}
	public int getP_pirce() {
		return p_pirce;
	}
	public void setP_pirce(int p_pirce) {
		this.p_pirce = p_pirce;
	}
	public String getP_Sellers() {
		return p_Sellers;
	}
	public void setP_Sellers(String p_Sellers) {
		this.p_Sellers = p_Sellers;
	}
	public int getPca_no() {
		return pca_no;
	}
	public void setPca_no(int pca_no) {
		this.pca_no = pca_no;
	}
	public int getPco_no() {
		return pco_no;
	}
	public void setPco_no(int pco_no) {
		this.pco_no = pco_no;
	}
	public int getPb_no() {
		return pb_no;
	}
	public void setPb_no(int pb_no) {
		this.pb_no = pb_no;
	}
	public int getPo_no() {
		return po_no;
	}
	public void setPo_no(int po_no) {
		this.po_no = po_no;
	}
	public int getPc_no() {
		return pc_no;
	}
	public void setPc_no(int pc_no) {
		this.pc_no = pc_no;
	}
	public int getPp_no() {
		return pp_no;
	}
	public void setPp_no(int pp_no) {
		this.pp_no = pp_no;
	}
	public int getP_name() {
		return p_name;
	}
	public void setP_name(int p_name) {
		this.p_name = p_name;
	}
	public int getP_size() {
		return p_size;
	}
	public void setP_size(int p_size) {
		this.p_size = p_size;
	}
	public int getP_picture() {
		return p_picture;
	}
	public void setP_picture(int p_picture) {
		this.p_picture = p_picture;
	}
	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_gender=" + p_gender + ", p_pirce=" + p_pirce + ", p_Sellers=" + p_Sellers
				+ ", pca_no=" + pca_no + ", pco_no=" + pco_no + ", pb_no=" + pb_no + ", po_no=" + po_no + ", pc_no="
				+ pc_no + ", pp_no=" + pp_no + ", p_name=" + p_name + ", p_size=" + p_size + ", p_picture=" + p_picture
				+ "]";
	}
	
	

}
