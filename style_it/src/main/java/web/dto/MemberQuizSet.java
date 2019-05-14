package web.dto;

import java.util.Arrays;

public class MemberQuizSet {

	int m_no;
	private int p_gender;
	private int lprice;
	private int hprice;
	private int[] pca_no;
	private int[] pco_no;
	private int[] pb_no;
	private int[] po_no;
	private int[] ps_no;
	private int[] pp_no;

	
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
	public int getLprice() {
		return lprice;
	}
	public void setLprice(int lprice) {
		this.lprice = lprice;
	}
	public int getHprice() {
		return hprice;
	}
	public void setHprice(int hprice) {
		this.hprice = hprice;
	}
	public int[] getPca_no() {
		return pca_no;
	}
	public void setPca_no(int[] pca_no) {
		this.pca_no = pca_no;
	}
	public int[] getPco_no() {
		return pco_no;
	}
	public void setPco_no(int[] pco_no) {
		this.pco_no = pco_no;
	}
	public int[] getPb_no() {
		return pb_no;
	}
	public void setPb_no(int[] pb_no) {
		this.pb_no = pb_no;
	}
	public int[] getPo_no() {
		return po_no;
	}
	public void setPo_no(int[] po_no) {
		this.po_no = po_no;
	}
	public int[] getPs_no() {
		return ps_no;
	}
	public void setPs_no(int[] ps_no) {
		this.ps_no = ps_no;
	}
	public int[] getPp_no() {
		return pp_no;
	}
	public void setPp_no(int[] pp_no) {
		this.pp_no = pp_no;
	}

	@Override
	public String toString() {
		return "MemberQuizSet [m_no=" + m_no + ", p_gender=" + p_gender + ", lprice=" + lprice + ", hprice=" + hprice
				+ ", pca_no=" + Arrays.toString(pca_no) + ", pco_no=" + Arrays.toString(pco_no) + ", pb_no="
				+ Arrays.toString(pb_no) + ", po_no=" + Arrays.toString(po_no) + ", ps_no=" + Arrays.toString(ps_no)
				+ ", pp_no=" + Arrays.toString(pp_no) + "]";
	}
	
}
