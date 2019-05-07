
package web.dto;

import java.util.Date;

public class Styling {
	
//	----- 기본 테이블 컬럼 -------------
	private int s_no;
	private int m_no;
	private String s_name;
	private String s_content;
	private int st_no;
	private Date s_date;
	private int fu_no;	
//	-------------------------------
	
//	----- 조인 테이블 컬럼 --------------
	private String fu_storedname;
	private int cntslike;
	private int slikecheck;
	private int p_no;
	private int fut_no;
//	-------------------------------
		
	public int getS_no() {
		return s_no;
	}
	public int getSlikecheck() {
		return slikecheck;
	}
	public void setSlikecheck(int slikecheck) {
		this.slikecheck = slikecheck;
	}
	public int getCntslike() {
		return cntslike;
	}
	public void setCntslike(int cntslike) {
		this.cntslike = cntslike;
	}
	public int getFu_no() {
		return fu_no;
	}
	public void setFu_no(int fu_no) {
		this.fu_no = fu_no;
	}
	public String getFu_storedname() {
		return fu_storedname;
	}
	public void setFu_storedname(String fu_storedname) {
		this.fu_storedname = fu_storedname;
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
  public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
  public int getFut_no() {
		return fu_no;
	}
	public void setFut_no(int fu_no) {
		this.fu_no = fu_no;

	}
	@Override
	public String toString() {
		return "Styling [s_no=" + s_no + ", m_no=" + m_no + ", s_name=" + s_name + ", s_content=" + s_content
				+ ", st_no=" + st_no + ", s_date=" + s_date + ", fu_no=" + fu_no + ", fu_storedname=" + fu_storedname
				+ ", cntslike=" + cntslike + ", slikecheck=" + slikecheck + ", p_no=" + p_no + ", fut_no=" + fut_no
				+ "]";
	}
	
	
	


}

