package web.dto;

import java.util.Date;

public class StylingLike {
	
	private int slike_no;
	private int  s_no;
	private int  m_no;
	private Date slike_date;
	
	public int getSlike_no() {
		return slike_no;
	}
	public void setSlike_no(int slike_no) {
		this.slike_no = slike_no;
	}
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
	public Date getSlike_date() {
		return slike_date;
	}
	public void setSlike_date(Date slike_date) {
		this.slike_date = slike_date;
	}
	@Override
	public String toString() {
		return "StylingLike [slike_no=" + slike_no + ", s_no=" + s_no + ", m_no=" + m_no + ", slike_date=" + slike_date
				+ "]";
	}
	
	
	

		

}
