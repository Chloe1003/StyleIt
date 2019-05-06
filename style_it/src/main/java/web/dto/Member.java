package web.dto;

import java.util.Date;


public class Member {

//	----- 기존 테이블 컬럼 -----------
	private int m_no;
    private String m_email; 
    private String m_nick; 
    private Date m_date;
    private String m_pw;
    private String m_valid;
    private int m_img;
//  ----------------------------
//  ----- 조인 테이블 컬럼 -----------
    private String fu_storedname;
//  ----------------------------  
    
    
	public int getM_no() {
		return m_no;
	}
	public int getM_img() {
		return m_img;
	}
	public void setM_img(int m_img) {
		this.m_img = m_img;
	}
	public String getFu_storedname() {
		return fu_storedname;
	}
	public void setFu_storedname(String fu_storedname) {
		this.fu_storedname = fu_storedname;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public Date getM_date() {
		return m_date;
	}
	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_valid() {
		return m_valid;
	}
	public void setM_valid(String m_valid) {
		this.m_valid = m_valid;
	}
	@Override
	public String toString() {
		return "Member [m_no=" + m_no + ", m_email=" + m_email + ", m_nick=" + m_nick + ", m_date=" + m_date + ", m_pw="
				+ m_pw + ", m_valid=" + m_valid + ", m_img=" + m_img + ", fu_storedname=" + fu_storedname + "]";
	} 
    
    
    
	
}
