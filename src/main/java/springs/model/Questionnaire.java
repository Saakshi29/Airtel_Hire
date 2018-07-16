package springs.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="questionnaire")
@EntityListeners(AuditingEntityListener.class)
public class Questionnaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long qid;
	private Long questionnaireid;
	private String type;
	private String qstatement;
	private String options;
	private Long marks;
	private String answer;
	private String qname;
	
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Long getMarks() {
		return marks;
	}
	public void setMarks(Long marks) {
		this.marks = marks;
	}
	public Long getQid() {
		return qid;
	}
	public void setQid(Long qid) {
		this.qid = qid;
	}
	
	public Long getQuestionnaireid() {
		return questionnaireid;
	}
	public void setQuestionnaireid(Long questionnaireid) {
		this.questionnaireid = questionnaireid;
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
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
}
