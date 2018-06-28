package springs.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="challenges")
@EntityListeners(AuditingEntityListener.class)
public class Challenge {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long cid;

		
		private String cname;
		
		private String startDate;
		
		private String endDate;
		
		private String startTime;
		
		private String endTime;
		
		private String img;
		
		private String type;
		
		private String category;
		
		private String aboutChallenge;
		
		private String prizes;
		
		private String faqs;
		
		private String guidelines;
		public Long getCid() {
			return cid;
		}
		public void setCid(Long cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getAboutChallenge() {
			return aboutChallenge;
		}
		public void setAboutChallenge(String aboutChallenge) {
			this.aboutChallenge = aboutChallenge;
		}
		public String getPrizes() {
			return prizes;
		}
		public void setPrizes(String prizes) {
			this.prizes = prizes;
		}
		public String getFaqs() {
			return faqs;
		}
		public void setFaqs(String faqs) {
			this.faqs = faqs;
		}
		public String getGuidelines() {
			return guidelines;
		}
		public void setGuidelines(String guidelines) {
			this.guidelines = guidelines;
		}


}
