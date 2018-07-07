package springs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Challenge;
import springs.model.CheckTime;
import springs.repository.CheckTimeRepository;

@Service
public class CheckTimeDAO {

	@Autowired
	CheckTimeRepository checkTimeRepository;
	
	public void save(CheckTime c)
	{
	  checkTimeRepository.save(c);
	}
	
	
	public Boolean checkk(Long id, Long cid)
	{
		return checkTimeRepository.checking(id,cid);
	}
}
