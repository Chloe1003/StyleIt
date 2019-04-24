package web.dto;

public class QuizAnswer {
	
	private int qa_no;
	private int qq_no;
	private String qa_answer;
	@Override
	public String toString() {
		return "QuizAnswer [qa_no=" + qa_no + ", qq_no=" + qq_no + ", qa_answer=" + qa_answer + "]";
	}
	public int getQa_no() {
		return qa_no;
	}
	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
	}
	public int getQq_no() {
		return qq_no;
	}
	public void setQq_no(int qq_no) {
		this.qq_no = qq_no;
	}
	public String getQa_answer() {
		return qa_answer;
	}
	public void setQa_answer(String qa_answer) {
		this.qa_answer = qa_answer;
	}
	
	

}
