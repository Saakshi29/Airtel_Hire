package springs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Employee;
import springs.model.Problem;
import springs.model.Score;
import springs.repository.ProblemRepository;
import springs.repository.ScoreRepository;

@Service
public class ScoreDAO {
	@Autowired
	ScoreRepository scoreRepository;

	public Long findScoree(Long qid,Long id)
	{
		return scoreRepository.findScoree(qid,id);
	}
	public List<Score> findScore(Long pid)
	{
     return scoreRepository.findAll(pid);		
	}
	public Object[] findScoreByCid(Long cid)
	{
     return scoreRepository.findAllByCid(cid);		
	}
	public Object[] findScoreByQid(Long questionnaireid)
	{
     return scoreRepository.findAllByQid(questionnaireid);		
	}
	public Score findScore(Long uid,Long pid)
	{
		return  scoreRepository.findparticular(uid,pid);
	}
	public Long findScoreByUidPid(Long uid,Long pid)
	{
		return scoreRepository.findd(uid,pid);
	}
	public Score save(Score s)
	{
		return scoreRepository.save(s);
	}
	public Score findScoreByQid(Long id,Long qid)
	{
		return scoreRepository.findScoreByQid(id,qid);
	}


}
