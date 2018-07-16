package springs.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Submission;
import springs.repository.SubmissionRepository;

@Service
public class SubmissionDAO {

	@Autowired
	SubmissionRepository submissionRepository;
	
	public Submission save(Submission s)
	{
		return submissionRepository.save(s);
	}
	
	public String findtype(String filename)
	{
		return submissionRepository.findOne(filename);
	}
	
	public String findPath(Long id,Long pid)
	{
		return submissionRepository.findPath(id,pid);
	}
	
	public List<Long> findStatus(Long id,Long pid)
	{
		return submissionRepository.findOne(id,pid);
	}

	public List<Long> findStatus2(Long id,Long questionnaireid)
	{
		return submissionRepository.findOnee(id,questionnaireid);
	}
	
	public List<Submission> findSubmissions(Long pid)
	{
		return submissionRepository.findAll(pid);
	}
	
	public ArrayList<Submission> sub(Long questionnaireid)
	{
		return submissionRepository.sub(questionnaireid);}
		
	public String ans(Long id,Long qid)
	{return submissionRepository.ans(id,qid);
	}
	
}

