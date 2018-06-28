package springs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Problem;
import springs.model.Score;
import springs.repository.ProblemRepository;
import springs.repository.ScoreRepository;

@Service
public class ScoreDAO {
	@Autowired
	ScoreRepository scoreRepository;

	
	public List<Score> findScore(Long pid)
	{
     return scoreRepository.findAll(pid);		
	}
	}
