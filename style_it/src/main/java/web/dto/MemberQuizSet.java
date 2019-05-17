package web.dto;

import java.util.ArrayList;
import java.util.List;

public class MemberQuizSet {

	int m_no;
	private int p_gender;
	private int p_lowprice;
	private int p_highprice;
	private List<Integer> pca_no = new ArrayList<>();
	private List<Integer> pco_no = new ArrayList<>();
	private List<Integer> pb_no = new ArrayList<>();
	private List<Integer> po_no = new ArrayList<>();
	private List<Integer> ps_no = new ArrayList<>();
	private List<Integer> pp_no = new ArrayList<>();
	private List<Integer> price = new ArrayList<>();
	
	
	public List<Integer> getPrice() {
		return price;
	}
	public void setPrice(List<Integer> price) {
		this.price = price;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getP_gender() {
		return p_gender;
	}
	public void setP_gender(int p_gender) {
		this.p_gender = p_gender;
	}
	public int getP_lowprice() {
		return p_lowprice;
	}
	public void setP_lowprice(int p_lowprice) {
		this.p_lowprice = p_lowprice;
	}
	public int getP_highprice() {
		return p_highprice;
	}
	public void setP_highprice(int p_highprice) {
		this.p_highprice = p_highprice;
	}
	public List<Integer> getPca_no() {
		return pca_no;
	}
	public void setPca_no(List<Integer> pca_no) {
		this.pca_no = pca_no;
	}
	public List<Integer> getPco_no() {
		return pco_no;
	}
	public void setPco_no(List<Integer> pco_no) {
		this.pco_no = pco_no;
	}
	public List<Integer> getPb_no() {
		return pb_no;
	}
	public void setPb_no(List<Integer> pb_no) {
		this.pb_no = pb_no;
	}
	public List<Integer> getPo_no() {
		return po_no;
	}
	public void setPo_no(List<Integer> po_no) {
		this.po_no = po_no;
	}
	public List<Integer> getPs_no() {
		return ps_no;
	}
	public void setPs_no(List<Integer> ps_no) {
		this.ps_no = ps_no;
	}
	public List<Integer> getPp_no() {
		return pp_no;
	}
	public void setPp_no(List<Integer> pp_no) {
		this.pp_no = pp_no;
	}
	@Override
	public String toString() {
		return "MemberQuizSet [m_no=" + m_no + ", p_gender=" + p_gender + ", p_lowprice=" + p_lowprice
				+ ", p_highprice=" + p_highprice + ", pca_no=" + pca_no + ", pco_no=" + pco_no + ", pb_no=" + pb_no
				+ ", po_no=" + po_no + ", ps_no=" + ps_no + ", pp_no=" + pp_no + ", price=" + price + "]";
	}
		
	

}
