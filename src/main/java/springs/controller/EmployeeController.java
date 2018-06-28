package springs.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.parser.MediaType;
import org.mockito.internal.util.io.IOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springs.dao.EmployeeDAO;
import springs.dao.StorageService;
import springs.model.Employee;
import springs.model.Request;
import springs.model.Response;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDaO;
	
	@Autowired
	StorageService storageService;
	
	List<String> files = new ArrayList<String>();
	@PostMapping("/upload")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		//System.out.println(file.toString());
		try {
			storageService.store(file);
			//System.out.println(file.getOriginalFilename());
			files.add(file.getOriginalFilename());
			System.out.println(files);
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	} 
	
	
	@GetMapping("/file/{filename}")
	public ResponseEntity<?> getFile(@PathVariable(value="filename") String filename) throws IOException {
	System.out.println(filename);
		File file=new File("C:/uploads/"+filename);
	
		HttpHeaders headers=new HttpHeaders();
		headers.add("Cache-Control","no-cache,no-store,must-revalidate");
		headers.add("Pragma","no-cache");
		headers.add("Expires","0");
		String contentDispositionHeader="attachment;filename="+filename;
		headers.add(HttpHeaders.CONTENT_DISPOSITION,contentDispositionHeader);
		java.nio.file.Path path=Paths.get("C:/uploads/"+filename+".txt");	
		System.out.println(path);
		ByteArrayResource resource =new ByteArrayResource(Files.readAllBytes((java.nio.file.Path) path));		
		
		return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(org.springframework.http.MediaType.parseMediaType("application/octet-stream")).body(resource);
         
    }

	
	@GetMapping("/app")
	public String calling()
	{
		return "app";
	}
	
	//save a user
	@PostMapping("/register")
	public ResponseEntity<Response> createEmployee(@Valid @RequestBody Employee emp) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		employeeDaO.save(emp);
		Response r=new Response();
		r.setId(emp.getId());
		r.setStatus("success");
//		System.out.println("id: " + r.id);
		return ResponseEntity.ok().headers(headers).body(r);

	}
	
	/*
	@GetMapping("/trial/{uname}/{password}")
	public int getEmployeeById(@PathVariable(value="uname") String uname,@PathVariable(value="password") String password)
	{return employeeDaO.find(uname,password);
	}
	*/
	
	

	@PostMapping("/login")
	public ResponseEntity<Response> find(@Valid @RequestBody Request r)
	{Long id= employeeDaO.find(r.getEmailid(),r.getPassword());
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
	
	//get all users
	@GetMapping("/registers")
	public List<Employee> getAllEmployees()
	{return employeeDaO.findAll();}
	
	
	
	/*@GetMapping("/trii/{id}")
	public void fin(@PathVariable(value="id") int empid)
	{employeeDaO.fin(empid);
		
	}*/
	
	//get users by id
	@GetMapping("/users/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid)
	{Employee emp= employeeDaO.findOne(empid);
		if(emp==null)
			return ResponseEntity.notFound().build();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		//headers.add("Access-Control-Allow-Origin", "http://podcastpedia.org"); //allows CORS requests only coming from podcastpedia.org		
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
		return ResponseEntity.ok().headers(headers).body(emp);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateEmployee(@PathVariable(value="id") Long empid, @Valid @RequestBody Employee empDetails)
		{
		
			Employee emp= employeeDaO.findOne(empid);
			if(emp==null)
				return ResponseEntity.notFound().build();
			if(empDetails.getCollegename()!=null)
				emp.setCollegename(empDetails.getCollegename());
			if(empDetails.getPhone_number()!=null)
				emp.setPhone_number(empDetails.getPhone_number());
			if(empDetails.getResume()!=null)
				emp.setResume(empDetails.getResume());
			if(empDetails.getSpecialization()!=null)		
				emp.setSpecialization(empDetails.getSpecialization());
			if(empDetails.getDegree()!=null)		
				emp.setDegree(empDetails.getDegree());
			if(empDetails.getYear()!=null)		
				emp.setYear(empDetails.getYear());
		    Employee updatemployee=employeeDaO.save(emp);
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Access-Control-Allow-Origin", "*");
	       //headers.add("Access-Control-Allow-Origin", "http://podcastpedia.org"); //allows CORS requests only coming from podcastpedia.org		
        	headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");	
	
        	Response r=new Response();
        	r.setId(updatemployee.getId());
        	r.setStatus("success");
        	//System.out.println("id: " + r.id);
        	//return ResponseEntity.ok().headers(headers).body(r);
        	return ResponseEntity.ok().headers(headers).body(r);
	}
	
	
	//delete
	@DeleteMapping("/register/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid)
	{	Employee emp= employeeDaO.findOne(empid);
		if(emp==null)
			return ResponseEntity.notFound().build();
		employeeDaO.delete(emp);
		return ResponseEntity.ok().build();
	}
}	
