package web.dto;

import java.util.Date;

public class CollectionProduct {
	
	private int cp_no;
	private int c_no;
	private int p_no;
	private Date cp_date;

	@Override
	public String toString() {
		return "CollectionProduct [cp_no=" + cp_no + ", c_no=" + c_no + ", p_no=" + p_no + ", cp_date=" + cp_date + "]";
	}

	public int getCp_no() {
		return cp_no;
	}

	public void setCp_no(int cp_no) {
		this.cp_no = cp_no;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public Date getCp_date() {
		return cp_date;
	}

	public void setCp_date(Date cp_date) {
		this.cp_date = cp_date;
	}
	
	

}
