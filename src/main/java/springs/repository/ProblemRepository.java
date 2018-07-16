package springs.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springs.model.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem,Long>{

	@Query("Select p from Problem p where p.cid=:cid")	
	public List<Problem> findProb(@Param("cid") Long cid);
		
}
