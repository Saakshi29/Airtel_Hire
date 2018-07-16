package springs.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springs.dao.AdminDAO;
import springs.dao.EmailServiceImpl;
import springs.dao.EmployeeDAO;
import springs.dao.ScoreDAO;
import springs.dao.SubmissionDAO;
import springs.model.Employee;
import springs.model.Request;
import springs.model.Response;
import springs.model.Response_score;
import springs.model.Submission;
import springs.model.status;

@RestController
public class AdminController {
	
	@Autowired
	AdminDAO adminDao;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	SubmissionDAO submissionDAO;
	
	@Autowired
	ScoreDAO scoreDAO;
	
	@Autowired
	EmailServiceImpl emailServiceImpl;
	
	//	public ResponseEntity<status> sendd(@RequestParam("uname")String uname,@RequestParam("emailid")String emailid,@RequestParam("link")String link)

	@PostMapping("/sendmail")
	public ResponseEntity<status> sendd(@RequestBody ArrayList<String> emailid,@RequestParam("link")String link)
	{	
		for(int i=0;i<emailid.size();i++){
		String password=adminDao.generatePassword();
		emailServiceImpl.sendSimpleMessage(emailid.get(i),"Questionnaire for Airtel", "Hey user"+","+"\npassword: "+password+"\nLink for Questionnaire: "+link+"\n\n\n\n"+"Regards,\n Airtel Hire");
		Employee emp=new Employee();
		emp.setEmailid(emailid.get(i));
		emp.setPassword(password);
		//emp.setUname(uname);
		emp.setType("questionnaire");
		employeeDAO.save(emp);
		}
		
		status s=new status();
		s.setStatus("success");
		return ResponseEntity.ok().body(s);
	}
	
	@PostMapping("/adminlogin")
	public ResponseEntity<Response> find(@Valid @RequestBody Request r)
	{	Long id= adminDao.find(r.getEmailid(),r.getPassword());
		String status;
		if(id!=null){
		status="success";}
		else
		{
			status="not valid";
		}
		Response t=new Response();
		t.setId(id);
		t.setStatus(status);
	return ResponseEntity.ok().body(t);
	}
	
	@GetMapping("/allsubmissions/{pid}")
	public List<Response_score> getSubmissionsByPid(@PathVariable(value="pid") Long pid)
	{	List<Submission>s= submissionDAO.findSubmissions(pid);
		List<Response_score> neww=new ArrayList<Response_score>();
		for(int i=0;i<s.size();i++)
		{Response_score r=new Response_score();
			/*System.out.println(s.get(i).getId());
			System.out.println(employeeDAO.findOne(s.get(i).getId()).getUname());
			System.out.println(scoreDAO.findScoreByUidPid(s.get(i).getId(),pid));*/
			r.setUid(s.get(i).getId());
			r.setUname(employeeDAO.findOne(s.get(i).getId()).getUname());
			r.setScore(scoreDAO.findScoreByUidPid(s.get(i).getId(),pid));
			neww.add(r);
		}
	return neww;
	}

}
