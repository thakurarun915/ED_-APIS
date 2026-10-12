package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DC_EDUCATION")
public class DcEducationEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eduId;
	private Long caseNum;
	private String highestQualification;
	private Integer graduationYear;
//	private String universityName;
	public Integer getEduId() {
		return eduId;
	}
	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}
	public Long getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	public Integer getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear = graduationYear;
	}
//	public String getUniversityName() {
//		return universityName;
//	}
//	public void setUniversityName(String universityName) {
//		universityName = universityName;
//	}
	public DcEducationEntity(Integer eduId, Long caseNum, String highestQualification, Integer graduationYear
			) {
		super();
		this.eduId = eduId;
		this.caseNum = caseNum;
		this.highestQualification = highestQualification;
		this.graduationYear = graduationYear;
		
	}
	public DcEducationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
