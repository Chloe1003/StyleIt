package web.dto;

import java.util.Date;

public class MessageRoom {

//	----- 메시지 룸 테이블 -----
	int mr_no;
	int participant1;
	int participant2;
	Date mr_date;
	
//	----------------------
	
//	----- 조인 테이블 ------
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
	
	@Override
	public String toString() {
		return "MessageRoom [mr_no=" + mr_no + ", participant1=" + participant1 + ", participant2=" + participant2
				+ ", mr_date=" + mr_date + "]";
	}
	

	
	
}
