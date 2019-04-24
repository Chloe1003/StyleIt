package web.dto;

public class Feed {

//	p_no, s_no를 f_no에
//	plike_no, slike_no를 flike_no에
//	p_name, s_name을 f_name에 넣어주고,
//	type에 p/s 값을 넣어주어 구분 
	int f_no;
	int flike_no;
	int f_name;
	String type;
	int	m_no;
	int fu_no;
	
	
	public int getF_no() {
		return f_no;
	}
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	public int getFlike_no() {
		return flike_no;
	}
	public void setFlike_no(int flike_no) {
		this.flike_no = flike_no;
	}
	public int getF_name() {
		return f_name;
	}
	public void setF_name(int f_name) {
		this.f_name = f_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getFu_no() {
		return fu_no;
	}
	public void setFu_no(int fu_no) {
		this.fu_no = fu_no;
	}
	
	@Override
	public String toString() {
		return "Feed [f_no=" + f_no + ", flike_no=" + flike_no + ", f_name=" + f_name + ", type=" + type + ", m_no="
				+ m_no + ", fu_no=" + fu_no + "]";
	}
	
	

	
	
	
}
