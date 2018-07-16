package springs.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springs.dao.CheckTimeDAO;
import springs.model.CheckTime;
import springs.model.status;

@RestController
public class CheckTimeController {

	@Autowired 
	CheckTimeDAO checkTimeDAO;
	
	@PostMapping("/enter")
	public ResponseEntity<status> createProblem(@Valid @RequestBody CheckTime ch)
	{	ch.setHasstarted(true);
		checkTimeDAO.save(ch);
		status s=new status();
		s.setStatus("success");
		return ResponseEntity.ok().body(s);}

	@GetMapping("/checkTime")
	public ResponseEntity<status> check(@Valid @RequestParam("id")Long id, @RequestParam("cid")Long cid)
	{	Boolean y=checkTimeDAO.checkk(id,cid);
		status s=new status();
		if(y==true)
		s.setStatus("continue");
		else
			s.setStatus("Start");
		return ResponseEntity.ok().body(s);
	}
}
