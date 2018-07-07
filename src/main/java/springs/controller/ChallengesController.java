package springs.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import com.mysql.fabric.Response;

import springs.dao.ChallengeDAO;
import springs.dao.StorageService;
import springs.model.Challenge;
import springs.model.Submission;
import springs.model.status;




@RestController
public class ChallengesController {
	
	private final Path rootLocation2 = Paths.get("C:/challengeupload/");
@Autowired
ChallengeDAO challengeDAO;
	
@Autowired
StorageService storageService;

	@PostMapping("/challenges")
	public ResponseEntity<status> createChallenge(@Valid @RequestParam(value="cname")String cname,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,@RequestParam("type") String type,@RequestParam("aboutChallenge") String aboutChallenge,@RequestParam("prizes") String prizes,@RequestParam("faqs") String faqs,
			@RequestParam("guidelines")String guidelines,@RequestParam("banner") MultipartFile file)
	{
		Challenge ch=new Challenge(cname,startDate,endDate,startTime,endTime,type,aboutChallenge,prizes,faqs,guidelines);
		 challengeDAO.save(ch);
		 storageService.challengeStore(file,ch.getCid());
		 String ext= FilenameUtils.getExtension(rootLocation2+file.getOriginalFilename());
		// System.out.println(ext);
		 Challenge c= challengeDAO.findOne(ch.getCid());
		 ch.setImg(rootLocation2+"\\ch-"+ch.getCid());
		 challengeDAO.save(c);
		 status s=new status();
		 s.setStatus("success");
		 return ResponseEntity.ok().body(s);
		
	}
	
	
	@GetMapping("/img/{cid}")
	public ResponseEntity<?> getFile(@PathVariable(value="cid")Long cid)throws IOException {
		String filename="ch-"+cid.toString();
		System.out.println(filename);
		File file=new File("C:/challengeupload/"+filename);
		//String ext=submissionDAO.findtype("C:/uploads/"+filename);
		//System.out.println(ext);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Cache-Control","no-cache,no-store,must-revalidate");
		headers.add("Pragma","no-cache");
		headers.add("Expires","0");
		String contentDispositionHeader="attachment;filename="+filename;
		headers.add(HttpHeaders.CONTENT_DISPOSITION,contentDispositionHeader);
		java.nio.file.Path path=Paths.get("C:/challengeupload/"+filename);	
		System.out.println(path);
		ByteArrayResource resource =new ByteArrayResource(Files.readAllBytes((java.nio.file.Path) path));		

//		BufferedImage img=null;
		return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(org.springframework.http.MediaType.parseMediaType("application/octet-stream")).body(resource);
	//	img = ImageIO.read(new File("C:/challengeupload/ch-10"));
	//	return img;
    }
	
	
	

	@GetMapping("/challenges")
	public List<Challenge> getAllChallenges()
	{return challengeDAO.findAll();}
	
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





















