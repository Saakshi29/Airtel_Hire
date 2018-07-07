package springs.dao;

import java.util.List;

public class RequestQuestionnaire {

	
	private Long qid;
	private String type;
	private String qstatement;
	private List<String> options;
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
