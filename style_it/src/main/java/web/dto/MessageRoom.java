package web.dto;

import java.util.Date;

public class MessageRoom {

//	----- 메시지 룸 테이블 -----
	private int mr_no;
	private int participant1;
	private int participant2;
	private Date mr_date;
	
//	----------------------
	
//	----- 조인 테이블 ------
	private int m_no;
	private String m_nick;
	private String fu_storedname;
	private int notRead;
//	--------------------
	public int getMr_no() {
		return mr_no;
	}
	public void setMr_no(int mr_no) {
		this.mr_no = mr_no;
	}
	public int getParticipant1() {
		return participant1;
	}
	public void setParticipant1(int participant1) {
		this.participant1 = participant1;
	}
	public int getParticipant2() {
		return participant2;
	}
	public void setParticipant2(int participant2) {
		this.participant2 = participant2;
	}
	public Date getMr_date() {
		return mr_date;
	}
	public void setMr_date(Date mr_date) {
		this.mr_date = mr_date;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getFu_storedname() {
		return fu_storedname;
	}
	public void setFu_storedname(String fu_storedname) {
		this.fu_storedname = fu_storedname;
	}
	public int getNotRead() {
		return notRead;
	}
	public void setNotRead(int notRead) {
		this.notRead = notRead;
	}
	@Override
	public String toString() {
		return "MessageRoom [mr_no=" + mr_no + ", participant1=" + participant1 + ", participant2=" + participant2
				+ ", mr_date=" + mr_date + ", m_no=" + m_no + ", m_nick=" + m_nick + ", fu_storedname=" + fu_storedname
				+ ", notRead=" + notRead + "]";
	}

	
	

	

	
	
}
