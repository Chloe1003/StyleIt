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
    
//    프로필 사진 파일업로드 조인 용
    private int fu_no;
    private String fu_storedname;
//    팔로우 리스트 조회용
    private int follower_no;
    private int followee_no;
    private int followcheck;
	public int getM_no() {
		return m_no;
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
	public int getM_img() {
		return m_img;
	}
	public void setM_img(int m_img) {
		this.m_img = m_img;
	}
	public int getFu_no() {
		return fu_no;
	}
	public void setFu_no(int fu_no) {
		this.fu_no = fu_no;
	}

	public String getfu_storedname() {
		return fu_storedname;
	}
	public void setfu_storedname(String fu_storedname) {

		this.fu_storedname = fu_storedname;
	}
	public int getFollower_no() {
		return follower_no;
	}
	public void setFollower_no(int follower_no) {
		this.follower_no = follower_no;
	}
	public int getFollowee_no() {
		return followee_no;
	}
	public void setFollowee_no(int followee_no) {
		this.followee_no = followee_no;
	}
	public int getFollowcheck() {
		return followcheck;
	}
	public void setFollowcheck(int followcheck) {
		this.followcheck = followcheck;
	}
	@Override
	public String toString() {
		return "Member [m_no=" + m_no + ", m_email=" + m_email + ", m_nick=" + m_nick + ", m_date=" + m_date + ", m_pw="
				+ m_pw + ", m_valid=" + m_valid + ", m_img=" + m_img + ", fu_no=" + fu_no + ", fu_storedname="
				+ fu_storedname + ", follower_no=" + follower_no + ", followee_no=" + followee_no + ", followcheck="
				+ followcheck + "]";
	}

    
    

    
    
	

}
