package springs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springs.dao.ChallengeDAO;
import springs.model.Challenge;
import springs.model.status;



@RestController
public class ChallengesController {
	
@Autowired
ChallengeDAO challengeDAO;
	

	@PostMapping("/challenges")
	public ResponseEntity<status> createChallenge(@Valid @RequestBody Challenge ch)
	{
		 challengeDAO.save(ch);
		status s=new status();
		s.setStatus("success");
		 return ResponseEntity.ok().body(s);}

	@GetMapping("/challenges")
	public List<Challenge> getAllChallenges()
	{return challengeDAO.findAll();}
	
/*
	@GetMapping("/jj")
	public List<Challenge> f()
	{return challengeDAO.fink();}
	*/
	
	@GetMapping("/challenges/{id}")
	public ResponseEntity<Challenge> getChallengeById(@PathVariable(value="id") Long cid)
	{Challenge c= challengeDAO.findOne(cid);
		if(c==null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(c);
	}
	
	@PutMapping("/challenges/{id}")
	public ResponseEntity<Challenge> updateChallenge(@PathVariable(value="id") Long cid, @Valid @RequestBody Challenge cDetails)
	{Challenge c= challengeDAO.findOne(cid);
		if(c==null)
			return ResponseEntity.notFound().build();
		c.setCategory(cDetails.getCategory());
		c.setEndDate(cDetails.getEndDate());
		c.setEndTime(cDetails.getEndTime());
		c.setImg(cDetails.getImg());
		c.setCname(cDetails.getCname());
		c.setFaqs(cDetails.getFaqs());
		c.setAboutChallenge(cDetails.getAboutChallenge());
		c.setStartDate(cDetails.getStartDate());
		c.setStartTime(cDetails.getStartTime());
		c.setPrizes(cDetails.getPrizes());
		c.setType(cDetails.getType());
		c.setGuidelines(cDetails.getGuidelines());
		c.setCategory(cDetails.getCategory());
	
	Challenge updatechallenge=challengeDAO.save(c);
	return ResponseEntity.ok().body(updatechallenge);
	}
	
	
	//delete
	@DeleteMapping("/challenges/{id}")
	public ResponseEntity<Challenge> deleteChallenge(@PathVariable(value="id") Long cid)
	{Challenge c= challengeDAO.findOne(cid);
		if(c==null)
			return ResponseEntity.notFound().build();
		challengeDAO.delete(c);
		return ResponseEntity.ok().build();
	}
	

}





















