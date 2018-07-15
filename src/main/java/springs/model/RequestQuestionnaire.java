package springs.model;

import java.util.List;

public class RequestQuestionnaire {
	private Long qid;
	private String type;
	private String qstatement;
	private List<String> options;
	private Long marks;
	private String answer;
	private String qname;
	
	
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public Long getMarks() {
		return marks;
	}
	public void setMarks(Long marks) {
		this.marks = marks;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Long getQid() {
		return qid;
	}
	public void setQid(Long qid) {
		this.qid = qid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQstatement() {
		return qstatement;
	}
	public void setQstatement(String qstatement) {
		this.qstatement = qstatement;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	
	
	
	


}
