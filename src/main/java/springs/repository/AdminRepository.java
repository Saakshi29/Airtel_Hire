package springs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springs.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
	
	@Query("Select a.aid from Admin a where a.emailid=:emailid and a.password=:password")	
	public Long find(@Param("emailid") String emailid,@Param("password") String password);
}
