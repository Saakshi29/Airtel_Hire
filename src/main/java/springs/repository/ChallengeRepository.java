package springs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springs.model.Challenge;
import springs.model.Employee;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge,Long>{

	@Query("Select c from Challenge c")	
	public List<Challenge> findAll();
		
	}
	

