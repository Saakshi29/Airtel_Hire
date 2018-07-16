package springs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springs.model.Employee;
import springs.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Long find(String username,String password)
	{
		return employeeRepository.find(username,password);			
	}
	
	public String findPath(Long id)
	{
		return employeeRepository.findPath(id);
	}
	
	public String findType(Long id)
	{
		return employeeRepository.findType(id);
	}
	//save
	public Employee save(Employee emp)
	{
		return employeeRepository.save(emp);
	}

	//search
	public List<Employee> findAll()
	{
	return employeeRepository.findAll();
	}
	
	//get
	public Employee findOne(Long empid){
	
		return employeeRepository.findOne(empid);}

	public void delete(Employee emp)
	{
		employeeRepository.delete(emp);}
}
