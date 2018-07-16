package springs.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Challenge;

import springs.repository.ChallengeRepository;


@Service
public class ChallengeDAO {
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	Date date=new Date();
	
	@Autowired
	ChallengeRepository challengeRepository;

	//save
	public Challenge save(Challenge c)
	{
		return challengeRepository.save(c);
	}

	public String findPath(Long cid)
	{
		return challengeRepository.findPath(cid);
	}
	
	public List<Challenge> findAll()
	{List<Challenge> x=new ArrayList<Challenge>();
     List<Challenge> ch= challengeRepository.findAll();
     for(int i=0;i<ch.size();i++)
     {  Challenge c=ch.get(i);
     	String start=c.getStartDate();
     	String end=c.getEndDate();
		//String startTime=c.getStartTime();
		//String endTime=c.getEndTime();
		Date star;

		Date en;
		try {
			en = formatter.parse(end);
			star=formatter.parse(start);
			
			if(date.after(star) && date.before(en)) {
				c.setCategory("live");		
			}
			else if(star.after(date))
			{c.setCategory("upcoming");}
			else
			{c.setCategory("previous");}
		
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		x.add(c);}
	return x;
	}
	
	//get
	public Challenge findOne(Long cid){
		Challenge c=challengeRepository.findOne(cid);
		String start=c.getStartDate();
		String end=c.getEndDate();
		Date star;
		Date en;
		try {
				en = formatter.parse(end);
				star=formatter.parse(start);
				if(date.after(star) && date.before(en)) {
				c.setCategory("live");		
				}
				else if(star.after(date))
				{c.setCategory("upcoming");}
				else
				{c.setCategory("previous");}
			} catch (ParseException e) {
				e.printStackTrace();
			}
	return c;
	}

	public void delete(Challenge c)
	{
		challengeRepository.delete(c);}
}
