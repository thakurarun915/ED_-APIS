package in.ashokit.response;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EligResponse {
		
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	private Integer edTraceId;
//	
//	
//	private Long CaseNum;	
//	
//	private String holderName;
	
	private String  PLAN_NAME ;		
	private String PLAN_STATUS	;		
    
	private LocalDate PlanStartDate;			         
	
	private LocalDate PlanEndDate;
	
	private Double benefitAmt;
			
	private String   denialReason;
	
	public String getPLAN_NAME() {
		return PLAN_NAME;
	}

	public void setPLAN_NAME(String pLAN_NAME) {
		PLAN_NAME = pLAN_NAME;
	}

	public String getPLAN_STATUS() {
		return PLAN_STATUS;
	}

	public void setPLAN_STATUS(String pLAN_STATUS) {
		PLAN_STATUS = pLAN_STATUS;
	}

	public LocalDate getPlanStartDate() {
		return PlanStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		PlanStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return PlanEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		PlanEndDate = planEndDate;
	}

	public Double getBenefitAmt() {
		return benefitAmt;
	}

	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public EligResponse(String pLAN_NAME, String pLAN_STATUS, LocalDate planStartDate, LocalDate planEndDate,
			Double benefitAmt, String denialReason) {
		super();
		PLAN_NAME = pLAN_NAME;
		PLAN_STATUS = pLAN_STATUS;
		PlanStartDate = planStartDate;
		PlanEndDate = planEndDate;
		this.benefitAmt = benefitAmt;
		this.denialReason = denialReason;
	}

	public EligResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
