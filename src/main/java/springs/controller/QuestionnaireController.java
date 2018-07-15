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

import springs.dao.EmployeeDAO;
import springs.dao.QuestionnaireDAO;
import springs.dao.RequestQuestionnaire;
import springs.dao.SubmissionDAO;
import springs.model.Questionnaire;
import springs.model.status;

@RestController
public class QuestionnaireController {
public static Long countt=(long)18;
	@Autowired
	QuestionnaireDAO questionnaireDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	SubmissionDAO submissionDAO;
	
	
	
	
	List<String>op=new ArrayList<String>();
	@PostMapping("/questionnaires")
	public ResponseEntity<status> putQuestionnaire(@RequestParam("qname")String qname,@RequestBody ArrayList<RequestQuestionnaire> arr)
	{
		for(int i=0;i<arr.size();i++)
		{
		RequestQuestionnaire q=arr.get(i);
		//if(q.getOptions()!=null){
		
		op=q.getOptions();
		//}
		StringBuilder y=new StringBuilder();
		if(op.size()!=0){
		for(int j=0;j<op.size()-1;j++)
		y.append(op.get(j)+",,");
		
		y.append(op.get(op.size()-1));}
		Questionnaire qnew=new Questionnaire();
		qnew.setQuestionnaireid(countt);
		qnew.setQname(qname);
		qnew.setQstatement(q.getQstatement());
		qnew.setMarks(q.getMarks());
		qnew.setAnswer(q.getAnswer());
		
		qnew.setType(q.getType());
		
		if(op!=null)
		qnew.setOptions(y.toString());
		questionnaireDAO.save(qnew);
		
			
		}
		
		status s=new status();
		s.setStatus("success");
		countt++;
		return ResponseEntity.ok().body(s);
		
	}
	
	@GetMapping("/questionnaires/{qid}")
	public List<RequestQuestionnaire> find(@Valid @PathVariable("qid")Long qid)
	{	List<Questionnaire>l= questionnaireDAO.find(qid);
	List<RequestQuestionnaire> res=new ArrayList<RequestQuestionnaire>();
	
		for(int i=0;i<l.size();i++)
		{	List<String> req=new ArrayList<String>();
			RequestQuestionnaire r=new RequestQuestionnaire();
			Questionnaire t=l.get(i);
			r.setQid(t.getQid());
			r.setQstatement(t.getQstatement());
			r.setType(t.getType());
			if(t.getOptions()!=null)
			{
			String [] str=t.getOptions().split(",,");
			for(int k=0;k<str.length;k++)
			{req.add(str[k]);
	
		}}
		r.setOptions(req);
		res.add(r);
		}
		return res;

	}
	
	@GetMapping("/allQuestionnaires")
	public ArrayList<Questionnaire>getAll(){
		return questionnaireDAO.getAll();
		
	}
	
	
	
	/*@GetMapping("/QuestionnaireSubmissions/{questionnaireid}")
	public ArrayList<Req_finalscore> sub(@PathVariable("questionnaireid")Long questionnaireid)
	{
		ArrayList<Req_finalscore> arr=new ArrayList<Req_finalscore>();
		ArrayList<Submission> s=submissionDAO.sub(questionnaireid);
		for(int i=0;i<s.size();i++){
		Req_finalscore r=new Req_finalscore();
		System.out.println(s.get(i).getId());
		System.out.println(employeeDAO.findOne(s.get(i).getId()).getUname());
		r.setId(s.get(i).getId());
		r.setUname(employeeDAO.findOne(s.get(i).getId()).getUname());
		
		arr.add(r);
		}
		
		return arr;
	}*/
	
	
	
	
	
	
	
	
}
