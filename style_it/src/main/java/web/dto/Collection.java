package web.dto;

import java.util.Date;

public class Collection {
	
	// 컬렉션 테이블
	private int c_no;
	private String c_name;
	private String c_content;
	private Date c_date;
	private int cf_no;
	
	// 조인 테이블 만드셈
	
	@Override
	public String toString() {
		return "Collection [c_no=" + c_no + ", c_name=" + c_name + ", c_content=" + c_content + ", c_date=" + c_date
				+ ", cf_no=" + cf_no + "]";
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public int getCf_no() {
		return cf_no;
	}

	public void setCf_no(int cf_no) {
		this.cf_no = cf_no;
	}
	
	
	

}
