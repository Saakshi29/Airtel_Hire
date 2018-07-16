package springs.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="problems")
@EntityListeners(AuditingEntityListener.class)
public class Problem {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long pid;

		private Long cid;
		private String probname;
		private String probdetails;
		private String owner;
		
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

		public String getProbname() {
			return probname;
		}

		public void setProbname(String probname) {
			this.probname = probname;
		}

		public String getProbdetails() {
			return probdetails;
		}

		public void setProbdetails(String probdetails) {
			this.probdetails = probdetails;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}

}
