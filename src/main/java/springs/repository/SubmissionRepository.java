package springs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import springs.model.Score;
import springs.model.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {
	
	@Query("Select s.subid from Submission s where s.id=:id and s.pid=:pid")	
	public List<Long> findOne(@Param("id") Long id,@Param("pid") Long pid);

	@Query("Select s.filename from Submission s where s.filename=:filename")
	public String findOne(@Param("filename")String filename);
	
	@Query("Select s.subid from Submission s where s.id=:id and s.qid=:qid")	
	public List<Long> findOnee(@Param("id") Long id,@Param("qid") Long qid);
	
	@Query("Select s from Submission s where s.pid=:pid")
	public List<Submission>findAll(@Param("pid")Long pid);
	
}
