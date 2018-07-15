package springs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import springs.dao.EmployeeDAO;
import springs.dao.QuestionnaireDAO;
import springs.dao.ScoreDAO;
import springs.dao.SubmissionDAO;
import springs.model.Problem;
import springs.model.Response_score;
import springs.model.Score;
import springs.model.ScoreOfSubjective;
import springs.model.status;
import springs.model.subjectiveRequest;

@RestController
public class ScoreController {

@Autowired
ScoreDAO scoreDAO;

@Autowired
SubmissionDAO submissionDAO;

@Autowired	
EmployeeDAO employeeDAO;
    
@Autowired
QuestionnaireDAO questionnaireDAO;

	@GetMapping("/score/{id}")
	public List<Response_score> scoreByPid(@PathVariable(value="id") Long pid)
	{List<Response_score> res=new ArrayList<Response_score>();
	
	List<Score>s= scoreDAO.findScore(pid);
	for(int i=0;i<s.size();i++)
	{Score t1=s.get(i);
	Response_score t2=new Response_score();
	t2.setScore(t1.getScore());
	t2.setUid(t1.getId());
	t2.setUname(employeeDAO.findOne(t1.getId()).getUname());
	res.add(t2);	
	}
	return res;
	}
	
	
	@GetMapping("/scoreboard/{id}")
	public List<Response_score> scoreByCid(@PathVariable(value="id") Long cid)
	{List<Response_score> res=new ArrayList<Response_score>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	Object[] s= scoreDAO.findScoreByCid(cid);
	for(int i=0;i<s.length;i++)
	{Object t1=s[i];
	String jsont1 = gson.toJson(t1);
	System.out.println(jsont1);
	JsonParser jsonParser = new JsonParser();
	JsonArray jo = (JsonArray)jsonParser.parse(jsont1);
	Long u=Long.parseLong(jo.get(0).toString());
	Long v=Long.parseLong(jo.get(1).toString());
	Response_score t2=new Response_score();	
	t2.setScore(v);
	t2.setUid(u);
	t2.setUname(employeeDAO.findOne(t2.getUid()).getUname());

	res.add(t2);	
	}	
	return res;
	}
	
	
	@GetMapping("/QuestionnaireSubmissions/{questionnaireid}")
	public List<Response_score> scoreByQid(@PathVariable(value="questionnaireid") Long questionnaireid)
	{Long v=null;
		List<Response_score> res=new ArrayList<Response_score>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	Object[] s= scoreDAO.findScoreByQid(questionnaireid);
	ArrayList<Long>arr=questionnaireDAO.findAllQid(questionnaireid);	
	for(int i=0;i<s.length;i++)
	{Object t1=s[i];
	String jsont1 = gson.toJson(t1);
	System.out.println(jsont1);
	JsonParser jsonParser = new JsonParser();
	JsonArray jo = (JsonArray)jsonParser.parse(jsont1);
	Long u=Long.parseLong(jo.get(0).toString());
	Response_score t2=new Response_score();
	if(!jo.get(1).toString().equals("null")) {
		System.out.println("jo get1: " + jo.get(1) + " check: " + jo.get(1).toString());
		v=Long.parseLong(jo.get(1).toString());
	}
	t2.setScore(v);	
	t2.setUid(u);
	
	if(arr.size()==0)
		t2.setIsfinal(true);
	else{
	for(int j=0;j<arr.size();j++)
	{Long x=scoreDAO.findScoree(arr.get(j),u);
	if(x==null)
		{t2.setIsfinal(false);
	break;
		}else
		t2.setIsfinal(true);
	}
	}
	
	
	t2.setUname(employeeDAO.findOne(t2.getUid()).getUname());

	res.add(t2);	
	}	
	return res;
	}
	
	@GetMapping("/subjective/{id}/{questionnaireid}")
	public ArrayList<subjectiveRequest> get(@PathVariable("questionnaireid")Long questionnaireid,@PathVariable("id")Long id)
	{ArrayList<subjectiveRequest>fin=new ArrayList<subjectiveRequest>();
	ArrayList<Long>arr=questionnaireDAO.findAllQid(questionnaireid);	
	for(int i=0;i<arr.size();i++){
		subjectiveRequest k=new subjectiveRequest();
		k.setId(id);
	//Long qid=arr.get(i);
		
			
	k.setQid(arr.get(i));
	k.setQstatement(questionnaireDAO.statement(arr.get(i)));
	k.setAnswer(submissionDAO.ans(id,arr.get(i)));
	k.setMarks(questionnaireDAO.getMarks(arr.get(i)));
	fin.add(k);
	}
	return fin;
	}
	
	@PostMapping("/scoreOfSubjective")
	public ResponseEntity<status> scores(@RequestBody ArrayList<ScoreOfSubjective>arr)
	{for(int i=0;i<arr.size();i++){
	ScoreOfSubjective t=arr.get(i);
		Score fin=scoreDAO.findScoreByQid(t.getId(),t.getQid());	
		fin.setScore(t.getScore());
		System.out.println(t.getScore());
		scoreDAO.save(fin);
	
	}
	status s=new status();
	s.setStatus("success");
	return ResponseEntity.ok().body(s);
	}
	
	@PostMapping("/scores/{id}")
	public ResponseEntity<status> updateScore(@PathVariable(value="id") Long id, @Valid @RequestBody Score sDetails)
	{
	sDetails.setId(id);
	scoreDAO.save(sDetails);
	status s=new status();
	s.setStatus("success");
	return ResponseEntity.ok().body(s);
	}
	@PostMapping("/scoresOfQuestionnaire/{id}")
	public ResponseEntity<status> updateScoreOfQid(@PathVariable(value="id") Long id, @Valid @RequestBody ArrayList<Score> sDetails)
	{
	for(int i=0;i<sDetails.size();i++)
	{Score s=new Score();
	s.setId(id);
	s.setQid(sDetails.get(i).getQid());
	s.setQuestionnaireid(sDetails.get(i).getQuestionnaireid());
	s.setScore(sDetails.get(i).getScore());
	scoreDAO.save(s);}
	status stat=new status();
	stat.setStatus("success");
	return ResponseEntity.ok().body(stat);
	}
}
