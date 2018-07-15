package springs.repository;

import springs.model.Employee;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

//	@Query("SELECT e FROM Employee e WHERE e.uname=:uname")
//    public Employee findOne(@Param("uname") String uname);
	
	@Query("Select e.id from Employee e where e.emailid=:emailid and e.password=:password")	
	public Long find(@Param("emailid") String emailid,@Param("password") String password);
		
	/*@Query("Select c.cname from Employee e,Challenge c where e.id=:id and c.cid=:id")	
	public List<Integer> fin(@Param("id") int id);*/
	
	@Query("Select e.type from Employee e where e.id=:id")	
	public String findType(@Param("id") Long id);
	
	@Query("Select e.resume from Employee e where e.id=:id")
	public String findPath(@Param("id")Long id);
	
	
}
