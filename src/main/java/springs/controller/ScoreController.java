package springs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import springs.dao.ScoreDAO;
import springs.model.Problem;
import springs.model.Score;

@RestController
public class ScoreController {

@Autowired
ScoreDAO scoreDAO;
	
    @GetMapping("/score/{id}")
	public List<Score> scoreByPid(@PathVariable(value="id") Long pid)
	{return scoreDAO.findScore(pid);}
    
    /*
    
	@Query(" FROM UserData where userId= :id")
	public List<UserData> findBySearchTerm(@Param("id") Long id);

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserData userdata
    */
}
