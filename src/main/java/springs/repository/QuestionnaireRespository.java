package springs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springs.model.Problem;
import springs.model.Questionnaire;

@Repository
public interface QuestionnaireRespository extends JpaRepository<Questionnaire,Long>{

	@Query("Select q from Questionnaire q where q.questionnaireid=:questionnaireid")	
	public List<Questionnaire> find(@Param("questionnaireid") Long questionnaireid);
	
}
