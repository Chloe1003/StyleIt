package web.dto;

import java.util.Date;

public class Banner {
	private int b_no;
	private String b_name;
	private int fu_no;
	private Date b_date;
	@Override
	public String toString() {
		return "Banner [b_no=" + b_no + ", b_name=" + b_name + ", fu_no=" + fu_no + ", b_date=" + b_date + "]";
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getFu_no() {
		return fu_no;
	}
	public void setFu_no(int fu_no) {
		this.fu_no = fu_no;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	
	
}
