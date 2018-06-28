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
	//save
	public Employee save(Employee emp)
	{
		return employeeRepository.save(emp);
	}

	/*public void fin(int id)
	{
		List<Integer> l=employeeRepository.fin(id);
		for(int i=0;i<l.size();i++)
			System.out.println(l.get(i));
	}*/
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
