package springs.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity()
@Table(name="scoreboard")
@EntityListeners(AuditingEntityListener.class)
public class Score {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sid;

	private Long pid;
	private Long cid;
	private Long id;
	private Long score;

	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}
}
