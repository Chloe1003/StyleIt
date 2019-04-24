package web.dto;

import java.util.Date;

public class StylingTag {
	
	private int st_no;
	private String st_name;
	private Date st_date;
	
	@Override
	public String toString() {
		return "StylingTag [st_no=" + st_no + ", st_name=" + st_name + ", st_date=" + st_date + "]";
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
