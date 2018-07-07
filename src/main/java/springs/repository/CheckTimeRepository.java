package springs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springs.model.CheckTime;

@Repository
public interface CheckTimeRepository extends JpaRepository<CheckTime,Long> {

	@Query("Select s.hasstarted from CheckTime s where s.id=:id and s.cid=:cid")	
	public Boolean checking(@Param("id") Long id,@Param("cid") Long cid);
}
