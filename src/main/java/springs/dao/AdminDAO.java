package springs.dao;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.repository.AdminRepository;

@Service
public class AdminDAO {
	
	@Autowired
	AdminRepository adminRepository;

	public Long find(String username,String password)
	{
		return adminRepository.find(username,password);
			
	}

	public String generatePassword()
	{	int leftLimit = 97; // letter 'A'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 8;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	return generatedString;
	}
	
}
