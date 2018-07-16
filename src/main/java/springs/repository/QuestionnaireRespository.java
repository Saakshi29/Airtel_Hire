package springs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springs.model.Questionnaire;

@Repository
public interface QuestionnaireRespository extends JpaRepository<Questionnaire,Long>{

	@Query("Select q from Questionnaire q where q.questionnaireid=:questionnaireid")	
	public List<Questionnaire> find(@Param("questionnaireid") Long questionnaireid);
	
	@Query("Select q.answer from Questionnaire q where q.qid=:qid")	
	public String findAnswer(@Param("qid") Long qid);
	
	@Query("Select q.marks from Questionnaire q where q.qid=:qid")	
	public Long findMarks(@Param("qid") Long qid);
	
	@Query("Select q.qstatement from Questionnaire q where q.qid=:qid")	
	public String findStatement(@Param("qid") Long qid);
	
	@Query("Select q.type from Questionnaire q where q.qid=:qid and q.questionnaireid=:questionnaireid")	
	public String findType(@Param("qid") Long qid,@Param("questionnaireid")Long questionniareid);
	
	@Query("Select q.qid from Questionnaire q where q.questionnaireid=:questionnaireid and q.type='subjective'")	
	public ArrayList<Long> findAllQid(@Param("questionnaireid") Long questionnaireid);
	
	@Query("Select q from Questionnaire q group by q.questionnaireid")	
	public ArrayList<Questionnaire> getAll();
	
	@Query("Select q.marks from Questionnaire q where q.qid=:qid")	
	public Long getMarks(@Param("qid")Long qid);
	
}
