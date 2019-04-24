package web.dto;

import java.util.Date;

public class StylingComment {
	
	private int co_no;
	private int  m_no;
	private Date co_date;
	private String co_content;
	private int  s_no;
	
	public int getCo_no() {
		return co_no;
	}
	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public Date getCo_date() {
		return co_date;
	}
	public void setCo_date(Date co_date) {
		this.co_date = co_date;
	}
	public String getCo_content() {
		return co_content;
	}
	public void setCo_content(String co_content) {
		this.co_content = co_content;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	@Override
	public String toString() {
		return "StylingComment [co_no=" + co_no + ", m_no=" + m_no + ", co_date=" + co_date + ", co_content="
				+ co_content + ", s_no=" + s_no + "]";
	}
	
	


}
