package web.dto;

import java.util.Date;

public class FileUpload {

//	----- 기존 테이블 컬럼 -------------
	private int fu_no;
	private String fu_storedname;
	private Date fu_date;
	private int fut_no;
//	-------------------------------
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
	public Date getFu_date() {
		return fu_date;
	}
	public void setFu_date(Date fu_date) {
		this.fu_date = fu_date;
	}
	public int getFut_no() {
		return fut_no;
	}
	public void setFut_no(int fut_no) {
		this.fut_no = fut_no;
	}
	@Override
	public String toString() {
		return "FileUpload [fu_no=" + fu_no + ", fu_storedname=" + fu_storedname + ", fu_date=" + fu_date + ", fut_no="
				+ fut_no + "]";
	}
	
	
	
}
