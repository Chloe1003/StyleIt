package web.dto;

public class StylingProduct {
	
	
	private int sp_no;	
	private int s_no;	
	private int p_no;	
	private String sp_x;
	private String  sp_y;

	public int getSp_no() {
		return sp_no;
	}
	public void setSp_no(int sp_no) {
		this.sp_no = sp_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getSp_x() {
		return sp_x;
	}
	public void setSp_x(String sp_x) {
		this.sp_x = sp_x;
	}
	public String getSp_y() {
		return sp_y;
	}
	public void setSp_y(String sp_y) {
		this.sp_y = sp_y;
	}
	
	@Override
	public String toString() {
		return "StylingProduct [sp_no=" + sp_no + ", s_no=" + s_no + ", p_no=" + p_no + ", sp_x=" + sp_x + ", sp_y="
				+ sp_y + "]";
	}

	

}
