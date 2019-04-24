package web.dto;

import java.util.Date;

public class Message {
	
//	----- 메시지 테이블 ----- 
	
	int msg_no;
	String msg_content;
	String msg_read;
	Date msg_date;
	int sender_no;
	int receiver_no;
	int mr_no;
	
//	--------------------
	
	
//	----- 조인 테이블 ------
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
	
	@Override
	public String toString() {
		return "Message [msg_no=" + msg_no + ", msg_content=" + msg_content + ", msg_read=" + msg_read + ", msg_date="
				+ msg_date + ", sender_no=" + sender_no + ", receiver_no=" + receiver_no + ", mr_no=" + mr_no + "]";
	}
	
	
	
	
	
}
