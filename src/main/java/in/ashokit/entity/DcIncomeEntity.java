package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "DC_INCOME")
public class DcIncomeEntity {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeid;
	
	private Long caseNum;
	
	private Double empIncome;
	
	private Double propertyIncome;

	public Integer getIncomeid() {
		return incomeid;
	}

	public void setIncomeid(Integer incomeid) {
		this.incomeid = incomeid;
	}

	public Long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}

	public Double getEmpIncome() {
		return empIncome;
	}

	public void setEmpIncome(Double empIncome) {
		this.empIncome = empIncome;
	}

	public Double getPropertyIncome() {
		return propertyIncome;
	}

	public void setPropertyIncome(Double propertyIncome) {
		this.propertyIncome = propertyIncome;
	}

	public DcIncomeEntity(Integer incomeid, Long caseNum, Double empIncome, Double propertyIncome) {
		super();
		this.incomeid = incomeid;
		this.caseNum = caseNum;
		this.empIncome = empIncome;
		this.propertyIncome = propertyIncome;
	}

	public DcIncomeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
