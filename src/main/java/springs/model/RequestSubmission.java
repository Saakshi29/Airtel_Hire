package springs.model;

public class RequestSubmission {

	Long id;
	Long qid;
	String answer;
	Long questionnaireid;
	
	public Long getQuestionnaireid() {
		return questionnaireid;
	}
	public void setQuestionnaireid(Long questionnaireid) {
		this.questionnaireid = questionnaireid;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
