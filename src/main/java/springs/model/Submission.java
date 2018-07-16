package springs.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="submissions")
@EntityListeners(AuditingEntityListener.class)
public class Submission {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long subid;
	private Long id;
	private Long pid;
	String filename;
	String ftype;
	String type;
	String answer;
	private Long qid;
	private Long questionnaireid;
	
	public Long getQuestionnaireid() {
		return questionnaireid;
	}
	public void setQuestionnaireid(Long questionnaireid) {
		this.questionnaireid = questionnaireid;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getSubid() {
		return subid;
	}
	public void setSubid(Long subid) {
		this.subid = subid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

}
