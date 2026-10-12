package in.ashokit.entity.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Dcchildren;

public interface DcchildrenRepo   extends JpaRepository<Dcchildren, Serializable> {
	
	public List<Dcchildren>findByCaseNum(Long caseNum);

}
