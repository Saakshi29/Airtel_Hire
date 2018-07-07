package springs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Employee;
import springs.model.Questionnaire;
import springs.repository.EmployeeRepository;
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
	
	
}
