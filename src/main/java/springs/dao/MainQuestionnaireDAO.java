package springs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.MainQuestionnaire;
import springs.repository.MainQuestionnaireRepository;


@Service
public class MainQuestionnaireDAO {
	
	@Autowired
	MainQuestionnaireRepository mainQuestionnaireRepository;
	
	public MainQuestionnaire save(MainQuestionnaire q)
	{
		return mainQuestionnaireRepository.save(q);
	}
	
	public Long findId(String qname)
	{
		return mainQuestionnaireRepository.findId(qname);
	}
	
}
