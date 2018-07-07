package springs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springs.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long>{

	@Query("Select s from Score s where s.pid=:pid order by s.score desc")	
	public List<Score> findAll(@Param("pid") Long pid);

	@Query("Select s.id,sum(s.score) from Score s where s.cid=:cid group by s.id")	
	public Object[] findAllByCid(@Param("cid") Long cid);
	
	
	
	@Query("Select s.score from Score s where s.id=:id and s.pid=:pid")
	public Long findd(@Param("id")Long id,@Param("pid")Long pid);
	
	@Query("Select s from Score s where s.id=:id and s.pid=:pid")
	public Score findparticular(@Param("id") Long id,@Param("pid")Long pid);
	
}
