package web.dto;

import java.util.Date;

public class Message {
	
//	----- 메시지 테이블 ----- 
	
	private int msg_no;
	private String msg_content;
	private String msg_read;
	private Date msg_date;
	private int sender_no;
	private int receiver_no;
	private int mr_no;
	
//	--------------------
	
	
//	----- 조인 테이블 ------
	private int m_no;
	private String m_nick;
	private String fu_storedname;
//	--------------------
	
	
	public int getMsg_no() {
		return msg_no;
	}
	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public String getMsg_read() {
		return msg_read;
	}
	public void setMsg_read(String msg_read) {
		this.msg_read = msg_read;
	}
	public Date getMsg_date() {
		return msg_date;
	}
	public void setMsg_date(Date msg_date) {
		this.msg_date = msg_date;
	}
	public int getSender_no() {
		return sender_no;
	}
	public void setSender_no(int sender_no) {
		this.sender_no = sender_no;
	}
	public int getReceiver_no() {
		return receiver_no;
	}
	public void setReceiver_no(int receiver_no) {
		this.receiver_no = receiver_no;
	}
	public int getMr_no() {
		return mr_no;
	}
	public void setMr_no(int mr_no) {
		this.mr_no = mr_no;
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
	@Override
	public String toString() {
		return "Message [msg_no=" + msg_no + ", msg_content=" + msg_content + ", msg_read=" + msg_read + ", msg_date="
				+ msg_date + ", sender_no=" + sender_no + ", receiver_no=" + receiver_no + ", mr_no=" + mr_no
				+ ", m_no=" + m_no + ", m_nick=" + m_nick + ", fu_storedname=" + fu_storedname + "]";
	}

	
	
	
	
	
	
	
	
	
}
