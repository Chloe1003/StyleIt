package web.dto;

import java.util.Date;

public class Styling {
	
	private int s_no;
	private int m_no;
	private String s_name;
	private String s_content;
	private int st_no;
	private Date s_date;
	
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public int getSt_no() {
		return st_no;
	}
	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	@Override
	public String toString() {
		return "Styling [s_no=" + s_no + ", m_no=" + m_no + ", s_name=" + s_name + ", s_content=" + s_content
				+ ", st_no=" + st_no + ", s_date=" + s_date + "]";
	}
	
	


}
