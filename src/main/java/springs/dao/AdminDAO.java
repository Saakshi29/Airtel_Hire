package springs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Submission;
import springs.repository.AdminRepository;
import springs.repository.EmployeeRepository;
import springs.repository.SubmissionRepository;

@Service
public class AdminDAO {
	@Autowired
	AdminRepository adminRepository;

	public Long find(String username,String password)
	{
		return adminRepository.find(username,password);
			
	}
	
	
	
}
