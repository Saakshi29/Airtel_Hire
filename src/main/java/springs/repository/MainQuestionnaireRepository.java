package springs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springs.model.MainQuestionnaire;
import springs.model.Problem;
import springs.model.Questionnaire;
	
@Repository
public interface MainQuestionnaireRepository extends JpaRepository<MainQuestionnaire,Long>{

	
	@Query("Select q.questionnaireid from MainQuestionnaire q where q.qname=:qname")	
	public Long findId(@Param("qname") String qname);
	
}
