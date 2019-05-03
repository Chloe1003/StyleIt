package web.dto;

import java.util.Date;

public class StylingTag {
	
//	----- 기본 테이블 컬럼 -----------
	private int st_no;
	private String st_name;
	private int fu_no;
	private Date st_date;
//	-----------------------------
	
//	----- 조인 테이블 컬럼 ------------
	private String fu_storedname;
//	-----------------------------
	
	
	@Override
	public String toString() {
		return "StylingTag [st_no=" + st_no + ", st_name=" + st_name + ", fu_no=" + fu_no + ", st_date=" + st_date
				+ ", fu_storedname=" + fu_storedname + "]";
	}

	public int getFu_no() {
		return fu_no;
	}

	public String getFu_storedname() {
		return fu_storedname;
	}

	public void setFu_storedname(String fu_storedname) {
		this.fu_storedname = fu_storedname;
	}

	public void setFu_no(int fu_no) {
		this.fu_no = fu_no;
	}

	public int getSt_no() {
		return st_no;
	}

	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public Date getSt_date() {
		return st_date;
	}

	public void setSt_date(Date st_date) {
		this.st_date = st_date;
	}
	
	
	

}
