package springs.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.jni.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springs.dao.StorageService;
import springs.dao.SubmissionDAO;
import springs.model.Challenge;
import springs.model.RequestSubmission;
import springs.model.Score;
import springs.model.Submission;
import springs.model.status;

@RestController
public class SubmissionController {
	
	private final Path rootLocation = Paths.get("C:/uploads/");
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	SubmissionDAO submissionDAO;
	
	@GetMapping("/file/{id}/{pid}")
	public ResponseEntity<?> getFile(@PathVariable(value="id")Long id,@PathVariable(value="pid")Long pid)throws IOException {
		String filename=id+"-"+pid;
		System.out.println(filename);
		File file=new File("C:/uploads/"+filename);
		String ext=submissionDAO.findtype("C:/uploads/"+filename);
		System.out.println(ext);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Cache-Control","no-cache,no-store,must-revalidate");
		headers.add("Pragma","no-cache");
		headers.add("Expires","0");
		String contentDispositionHeader="attachment;filename="+filename;
		headers.add(HttpHeaders.CONTENT_DISPOSITION,contentDispositionHeader);
		java.nio.file.Path path=Paths.get("C:/uploads/"+filename);	
		System.out.println(path);
		ByteArrayResource resource =new ByteArrayResource(Files.readAllBytes((java.nio.file.Path) path));		
		
		return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(org.springframework.http.MediaType.parseMediaType("application/octet-stream")).body(resource);
         
    }

	

	@PostMapping("/submission")
	public ResponseEntity<status> addSubmission(@Valid @RequestParam("id") Long id,@RequestParam("pid") Long pid, @RequestParam(value="file") MultipartFile file)
	{    storageService.store(file,id,pid);
		 String ext= FilenameUtils.getExtension(rootLocation+file.getOriginalFilename());
		 Submission s=new Submission();
		 s.setId(id);
		 s.setType("challenge");
		 s.setPid(pid);
		 s.setFtype(ext);
		 s.setFilename(rootLocation+"\\"+id+"-"+pid);
		 submissionDAO.save(s);
		 status s1=new status();
		 s1.setStatus("success");
		 return ResponseEntity.ok().body(s1);}
	
	
	@PostMapping("/submissionFromQuestionnaire")
	public ResponseEntity<status> addSubmissionOfQid(@Valid @RequestBody ArrayList<RequestSubmission> sub)
	{	for(int i=0;i<sub.size();i++)
	{
		Submission s=new Submission();
		 s.setId(sub.get(i).getId());
		 s.setQuestionnaireid(sub.get(i).getQuestionnaireid());
		 s.setQid(sub.get(i).getQid());
		 s.setAnswer(sub.get(i).getAnswer());
		 s.setType("questionnaire");
		 submissionDAO.save(s);
	}
		 status s1=new status();
		 s1.setStatus("success");
		 return ResponseEntity.ok().body(s1);
	}
	
	
	
	
	@PostMapping("/checksubmissionstatus")
	public ResponseEntity<status> isSubmitted(@Valid @RequestBody Score r)
	{	status s=new status();
	if(r.getQid()!=null)
	{	List<Long> y=submissionDAO.findStatus2(r.getId(),r.getQid());
		if(y.size()!=0)
		s.setStatus("success");	
		else
		s.setStatus("fail");
	}
	if(r.getPid()!=null)
	{	List<Long> x=submissionDAO.findStatus(r.getId(),r.getPid());
		if(x.size()!=0)
		s.setStatus("success");	
		else
		s.setStatus("fail");
	}
	return ResponseEntity.ok().body(s);	
	}	
	

}
