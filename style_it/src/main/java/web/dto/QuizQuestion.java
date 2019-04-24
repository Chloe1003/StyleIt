package web.dto;

public class QuizQuestion {

	private int qq_no;
	private String qq_title;
	private String qq_select;
	@Override
	public String toString() {
		return "QuizQuestion [qq_no=" + qq_no + ", qq_title=" + qq_title + ", qq_select=" + qq_select + "]";
	}
	public int getQq_no() {
		return qq_no;
	}
	public void setQq_no(int qq_no) {
		this.qq_no = qq_no;
	}
	public String getQq_title() {
		return qq_title;
	}
	public void setQq_title(String qq_title) {
		this.qq_title = qq_title;
	}
	public String getQq_select() {
		return qq_select;
	}
	public void setQq_select(String qq_select) {
		this.qq_select = qq_select;
	}
	
	
}
