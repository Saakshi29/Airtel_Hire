package springs.model;

public class subjectiveRequest {

	Long id;
	Long qid;
	String qstatement;
	String answer;
	Long marks;
	
	
	
	
	public Long getMarks() {
		return marks;
	}
	public void setMarks(Long marks) {
		this.marks = marks;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQid() {
		return qid;
	}
	public void setQid(Long qid) {
		this.qid = qid;
	}
	public String getQstatement() {
		return qstatement;
	}
	public void setQstatement(String qstatement) {
		this.qstatement = qstatement;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
