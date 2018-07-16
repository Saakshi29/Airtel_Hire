package springs.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springs.model.Questionnaire;
import springs.repository.QuestionnaireRespository;

@Service
public class QuestionnaireDAO {

	@Autowired
	QuestionnaireRespository questionnaireRepository;
	
	public Questionnaire save(Questionnaire q)
	{
		return questionnaireRepository.save(q);
	}

	public List<Questionnaire> find(Long qid)
	{
		return questionnaireRepository.find(qid);
	}
	
	public String findAnswer(Long qid)
	{
		return questionnaireRepository.findAnswer(qid);
	}
	
	public Long findMarks(Long qid)
	{
		return questionnaireRepository.findMarks(qid);
	}
	
	public String statement(Long qid)
	{	return questionnaireRepository.findStatement(qid);
	}
	
	public String findType(Long qid,Long questionnaireid)
	{
		return questionnaireRepository.findType(qid,questionnaireid);
	}
	
	public ArrayList<Long> findAllQid(Long questionnaireid)
	{return questionnaireRepository.findAllQid(questionnaireid);
	}
	
	public ArrayList<Questionnaire>getAll()
	{
		return questionnaireRepository.getAll();
	}
	
	public Long getMarks(Long qid)
	{
		return questionnaireRepository.getMarks(qid);
	}
	
}