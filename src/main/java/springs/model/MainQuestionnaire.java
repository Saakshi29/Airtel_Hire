package springs.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="mainquestionnaire")
@EntityListeners(AuditingEntityListener.class)
public class MainQuestionnaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long questionnaireid;
	
	String qname;
	public Long getQuestionnaireid() {
		return questionnaireid;
	}
	public void setQuestionnaireid(Long questionnaireid) {
		this.questionnaireid = questionnaireid;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	
}
