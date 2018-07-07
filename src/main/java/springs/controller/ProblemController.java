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
import springs.dao.ProblemDAO;
import springs.model.Challenge;
import springs.model.Problem;
import springs.model.status;



@RestController
public class ProblemController {

@Autowired	
ProblemDAO problemDAO;
	

	@PostMapping("/problems")
	public ResponseEntity<status> createProblem(@Valid @RequestBody Problem p)
	{
	problemDAO.save(p);
	status s=new status();
	s.setStatus("success");
	return ResponseEntity.ok().body(s);}

	@GetMapping("/problems")
	public List<Problem> getAllProblems()
	{return problemDAO.findAll();}
	
	
	@GetMapping("/problems/{id}")
	public List<Problem> getProblemsByCid(@PathVariable(value="id") Long cid)
	{return problemDAO.findProblem(cid);}

	@GetMapping("/problem/{id}")
	public ResponseEntity<Problem> getProblemById(@PathVariable(value="id") Long pid)
	{Problem p= problemDAO.findOne(pid);
		if(p==null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(p);
	}
	
	@PutMapping("/problems/{id}")
	public ResponseEntity<Problem> updateProblem(@PathVariable(value="id") Long pid, @Valid @RequestBody Problem pDetails)
	{Problem p= problemDAO.findOne(pid);
		if(p==null)
			return ResponseEntity.notFound().build();
		p.setCid(pDetails.getCid());
		p.setProbdetails(pDetails.getProbdetails());
		p.setProbname(pDetails.getProbname());
		p.setOwner(pDetails.getOwner());
	
	
	Problem updateproblem=problemDAO.save(p);
	return ResponseEntity.ok().body(updateproblem);
	}
	
	
	//delete
	@DeleteMapping("/problems/{id}")
	public ResponseEntity<Problem> deleteProblem(@PathVariable(value="id") Long pid)
	{Problem p= problemDAO.findOne(pid);
		if(p==null)
			return ResponseEntity.notFound().build();
		problemDAO.delete(p);
		return ResponseEntity.ok().build();
	}
	

}
