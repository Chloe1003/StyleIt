package web.dto;

import java.util.Date;

public class ProductLike {
	
	private int plike_no;
	private int p_no;
	private int m_no;
	private Date plike_date;
	
	@Override
	public String toString() {
		return "ProductLike [plike_no=" + plike_no + ", p_no=" + p_no + ", m_no=" + m_no + ", plike_date=" + plike_date
				+ "]";
	}

	public int getPlike_no() {
		return plike_no;
	}

	public void setPlike_no(int plike_no) {
		this.plike_no = plike_no;
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
	
}
