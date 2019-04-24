package web.dto;

import java.util.Date;

public class ProductLike {
	
	private int p_like;
	private int p_no;
	private int m_no;
	private Date plike_date;
	
	public int getP_like() {
		return p_like;
	}
	public void setP_like(int p_like) {
		this.p_like = p_like;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public Date getPlike_date() {
		return plike_date;
	}
	public void setPlike_date(Date plike_date) {
		this.plike_date = plike_date;
	}
	@Override
	public String toString() {
		return "ProductLike [p_like=" + p_like + ", p_no=" + p_no + ", m_no=" + m_no + ", plike_date=" + plike_date
				+ "]";
	}

	
	


}
