package web.dto;

public class Faq {

	private int faq_no;        
    private String faq_name;
    private String faq_answer;    
    private int faqct_no;
    
	@Override
	public String toString() {
		return "Faq [faq_no=" + faq_no + ", faq_name=" + faq_name + ", faq_answer=" + faq_answer + ", faqct_no="
				+ faqct_no + "]";
	}

	public int getFaq_no() {
		return faq_no;
	}

	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}

	public String getFaq_name() {
		return faq_name;
	}

	public void setFaq_name(String faq_name) {
		this.faq_name = faq_name;
	}

	public String getFaq_answer() {
		return faq_answer;
	}

	public void setFaq_answer(String faq_answer) {
		this.faq_answer = faq_answer;
	}

	public int getFaqct_no() {
		return faqct_no;
	}

	public void setFaqct_no(int faqct_no) {
		this.faqct_no = faqct_no;
	}
    
	
    

}
