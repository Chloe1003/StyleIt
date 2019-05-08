package web.dto;

public class MemberQuiz {

//	----- 원본 테이블 컬럼 --------
	int m_no;
	int qq_no;
	int mq_answer;
//	-------------------------
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getQq_no() {
		return qq_no;
	}
	public void setQq_no(int qq_no) {
		this.qq_no = qq_no;
	}
	public int getMq_answer() {
		return mq_answer;
	}
	public void setMq_answer(int mq_answer) {
		this.mq_answer = mq_answer;
	}
	@Override
	public String toString() {
		return "MemberQuiz [m_no=" + m_no + ", qq_no=" + qq_no + ", mq_answer=" + mq_answer + "]";
	}

	
	
	
}
