package springs.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springs.dao.ChallengeDAO;
import springs.dao.StorageService; 
import springs.model.Challenge;
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
		 String ext= FilenameUtils.getExtension(rootLocation2+file.getOriginalFilename());
		 storageService.challengeStore(file,ch.getCid(),ext);
		 Challenge c= challengeDAO.findOne(ch.getCid());
		 c.setImg(rootLocation2+"\\ch-"+ch.getCid()+"."+ext);
		 challengeDAO.save(c);
		 status s=new status();
		 s.setStatus("success");
		 return ResponseEntity.ok().body(s);	
	}
	
	
	@GetMapping("/img/{cid}")
	public ResponseEntity<?> getFile(@PathVariable(value="cid")Long cid)throws IOException {
		String p=challengeDAO.findPath(cid);
		String filename="ch-"+cid.toString();
		System.out.println(filename);
		File file=new File(p);
		
		/*Compression of image
		BufferedImage image = ImageIO.read(file);
        File output = new File(p);
        OutputStream out = new FileOutputStream(output);
        ImageWriter writer =  ImageIO.getImageWritersByFormatName("jpg").next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(out);
        writer.setOutput(ios);
        ImageWriteParam param = writer.getDefaultWriteParam();
        if (param.canWriteCompressed()){
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.05f);
        }
        writer.write(null, new IIOImage(image, null, null), param);
        out.close();
        ios.close();
        writer.dispose();
		file=new File(p);
		*/
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Cache-Control","no-cache,no-store,must-revalidate");
		headers.add("Pragma","no-cache");
		headers.add("Expires","0");
		String contentDispositionHeader="attachment;filename="+filename;
		headers.add(HttpHeaders.CONTENT_DISPOSITION,contentDispositionHeader);
		java.nio.file.Path path=Paths.get(p);	
		System.out.println(path);
		ByteArrayResource resource =new ByteArrayResource(Files.readAllBytes((java.nio.file.Path) path));		
		return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(org.springframework.http.MediaType.parseMediaType("application/octet-stream")).body(resource);
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