package springs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springs.model.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge,Long>{

	@Query("Select c from Challenge c")	
	public List<Challenge> findAll();
		
	@Query("Select c.img from Challenge c where c.cid=:cid")
	public String findPath(@Param("cid")Long cid);
	
	}
	

