package springs.dao;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("C:/uploads/");
	
	private final Path rootLocation2=Paths.get("C:/challengeupload/");
	private final Path rootLocation3=Paths.get("C:/resumeupload/");
	

	public void store(MultipartFile file,Long id,Long pid) {
	
		try {
		Files.copy(file.getInputStream(), this.rootLocation.resolve(id+"-"+pid));
		String ext1 = FilenameUtils.getExtension(rootLocation+id.toString()+"-"+pid);
		//System.out.println(ext1);
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}


	public void challengeStore(MultipartFile file,Long cid) {
		
		try {
		Files.copy(file.getInputStream(), this.rootLocation2.resolve("ch-"+cid));
		String ext1 = FilenameUtils.getExtension(rootLocation2+"ch-"+cid);
		//System.out.println(ext1);
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}
public void resumeStore(MultipartFile file,Long uid) {
		
		try {
		Files.copy(file.getInputStream(), this.rootLocation3.resolve("resume-"+uid));
		String ext1 = FilenameUtils.getExtension(rootLocation3+"resume-"+uid);
		//System.out.println(ext1);
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
		
			//System.out.println(file);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	
}