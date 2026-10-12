package in.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DC_CHILDREN")
public class Dcchildren {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer childId;
	private Integer childAge;
	private Long childSsn;
	private Long caseNum;
	private String childName;
	
	
	
	public Integer getChildId() {
		return childId;
	}
	public void setChildId(Integer childId) {
		this.childId = childId;
	}
//	public LocalDate getChildDob() {
//		return childAge;
//	}
//	public void setChildDob(LocalDate childDob) {
//		this.childAge = childDob;
//	}
	public Long getChildSsn() {
		return childSsn;
	}
	public void setChildSsn(Long childSsn) {
		this.childSsn = childSsn;
	}
	public Integer getChildAge() {
		return childAge;
	}
	public void setChildAge(Integer childAge) {
		this.childAge = childAge;
	}
	public Long getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}

	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	
	
	public Dcchildren(Integer childId, Integer childAge, Long childSsn, Long caseNum, String childName) {
		super();
		this.childId = childId;
		this.childAge = childAge;
		this.childSsn = childSsn;
		this.caseNum = caseNum;
		this.childName = childName;
	}
	public Dcchildren() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
