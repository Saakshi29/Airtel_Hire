package springs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Problem;
import springs.repository.ProblemRepository;

@Service
public class ProblemDAO {
	@Autowired
	ProblemRepository problemRepository;

	
	public List<Problem> findProblem(Long cid)
	{
return problemRepository.findProb(cid);		
	}
	//save
	public Problem save(Problem p)
	{return problemRepository.save(p);
	}

	//search
	public List<Problem> findAll()
	{
	return problemRepository.findAll();}
	
	//get
	public Problem findOne(Long pid){
	
		return problemRepository.findOne(pid);}

	public void delete(Problem p)
	{
		problemRepository.delete(p);}
	}
