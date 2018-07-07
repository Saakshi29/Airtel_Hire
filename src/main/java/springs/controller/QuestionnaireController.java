package springs.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import springs.dao.QuestionnaireDAO;
import springs.dao.RequestQuestionnaire;
import springs.model.Questionnaire;
import springs.model.Response;
import springs.model.status;

@RestController
public class QuestionnaireController {
public static Long count=(long)1;
	@Autowired
	QuestionnaireDAO questionnaireDAO;
	
	List<String>op=new ArrayList<String>();
	@PostMapping("/questionnaires")
	public ResponseEntity<status> putQuestionnaire(@Valid @RequestBody ArrayList<RequestQuestionnaire> arr)
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
		qnew.setQid(count);
		
		qnew.setQstatement(q.getQstatement());
		qnew.setType(q.getType());
		if(op!=null)
		qnew.setOptions(y.toString());
		questionnaireDAO.save(qnew);
		
			
		}
		
		status s=new status();
		s.setStatus("success");
		count++;
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
	
	
	
	
}
