package springs.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="checktime")
@EntityListeners(AuditingEntityListener.class)
public class CheckTime {
	
	
	@Id
	Long id;
	Long cid;
	Boolean hasstarted;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Boolean getHasstarted() {
		return hasstarted;
	}
	public void setHasstarted(Boolean hasstarted) {
		this.hasstarted = hasstarted;
	}
	
	

}
