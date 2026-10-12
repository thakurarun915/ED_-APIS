package in.ashokit.entity.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

//import in.ashokit.entity.DcEducation;
import in.ashokit.entity.DcEducationEntity;

public interface DcEducationRepo  extends JpaRepository<DcEducationEntity, Serializable>{
	
	public DcEducationEntity findByCaseNum(Long caseNum);

}
