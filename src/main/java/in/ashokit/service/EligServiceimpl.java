package in.ashokit.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenAppEntity;
import in.ashokit.entity.CoTriggerEntity;
import in.ashokit.entity.DcCaseEntity;
import in.ashokit.entity.DcEducationEntity;
import in.ashokit.entity.DcIncomeEntity;
import in.ashokit.entity.Dcchildren;
import in.ashokit.entity.EligDtlsEntity;
import in.ashokit.entity.PlanEntity;
import in.ashokit.entity.repository.CitizenAppRepository;
import in.ashokit.entity.repository.CoTriggerRepository;
import in.ashokit.entity.repository.DcCaseRepo;
import in.ashokit.entity.repository.DcEducationRepo;
import in.ashokit.entity.repository.DcIncomeRepo;
import in.ashokit.entity.repository.DcchildrenRepo;
import in.ashokit.entity.repository.EligDtlsRepository;
import in.ashokit.entity.repository.PlanRepository;
import in.ashokit.response.EligResponse;

@Service
public class EligServiceimpl implements EligService{

	@Autowired
	private DcCaseRepo dcCaseRepo;
	
	@Autowired
	private  PlanRepository planRepo;
	
	@Autowired
	private DcIncomeRepo incomerepo;
	
	@Autowired
	private DcchildrenRepo childRepo ;
	
	@Autowired
	private CitizenAppRepository appRepo ;
	
	@Autowired
	private DcEducationRepo eduRepo ;
	
	@Autowired
	private EligDtlsRepository eligRepo;
     
	@Autowired
	private CoTriggerRepository coTrgRepo;
	
	@Override
	public EligResponse determineEligibility(Long caseNum) {
		// TODO Auto-generated method stu
		
		
	Optional<DcCaseEntity> caseEntity = dcCaseRepo.findById(caseNum);
		
	Integer planId = null;
	String planName= null;
	Integer appId = null;
	
	if(caseEntity.isPresent())	{
		DcCaseEntity dcCaseEntity = caseEntity.get();
		
     planId = dcCaseEntity.getPlanId();
     appId = dcCaseEntity.getAppId();
		              
	}
		
		Optional<PlanEntity> planEntity = planRepo.findById(planId);
		
		if(planEntity.isPresent()) {
			
		PlanEntity plan  =  planEntity.get();
		 planName = plan.getPlanName();
			             
		}
		
		EligResponse eligResponse =  executePlanConditions(caseNum ,  planName, appId);
		
		// logic to store data in db 
		
		EligDtlsEntity eligEntity =  new EligDtlsEntity();
		BeanUtils.copyProperties(eligResponse, eligEntity);
		
		eligEntity.setCaseNum(caseNum);
//		eligEntity.setHolderName("");
//		eligEntity.setHolderSsn(0);
		eligRepo.save(eligEntity);
		
		
		CoTriggerEntity coEntity = new CoTriggerEntity();
		coEntity.setCaseNum(caseNum);
		coEntity.setTrgStatus("Pending");
		coTrgRepo.save(coEntity);
		
		return eligResponse ;
	}
	
	private EligResponse executePlanConditions(Long caseNum, String planname , Integer appId) {
		
		EligResponse response = new EligResponse();
		response.setPLAN_NAME(planname);
		DcIncomeEntity income  = incomerepo.findByCaseNum(caseNum);

		//logic to execute conditions
		
		if("SNAP".equals(planname)) {
			//logic
			
//			DcIncomeEntity income  = incomerepo.findByCaseNum(caseNum);
			
			Double empincome = income.getEmpIncome();
			if(empincome <= 300) {
				
				response.setPLAN_STATUS("AP");
				
			}else {
					response.setPLAN_STATUS("DN");
				response.setDenialReason("High Income");
			}
						
		}
			
		else if("CCAP".equals(planname)) {
			
			boolean agecondition = true ;
			boolean kidsCountCondition = false;
			List<Dcchildren> childs = childRepo.findByCaseNum(caseNum);
			
			 if(!childs.isEmpty()) {
				 kidsCountCondition = true;
				 for(Dcchildren entity : childs) {
					 
	        Integer childAge = entity.getChildAge();
	        
					 if(childAge > 16) {
						 agecondition = false ;
					 }
				 }
			 }
			 
			 if(income.getEmpIncome() <= 300 &&  kidsCountCondition  && agecondition) {
				 response.setPLAN_STATUS("AP");
			 }else {
				 response.setPLAN_STATUS("DN");
			 response.setDenialReason("Not satisfied business rules");
			 }
			 
					
		}else if ("MEDICAID".equals(planname)) {
			
			Double empIncome = income.getEmpIncome();
			
			Double propertyincome = income.getPropertyIncome();
			
			if(empIncome <= 300 && propertyincome == 0) {
				response.setPLAN_STATUS("AP");
			}
			
			else {
				
				response.setPLAN_STATUS("DN");
				response.setPLAN_STATUS("High income");
			}
		
		}
//		
//		else if("Medicare".equals(planname)){
//			
//      Optional<CitizenAppEntity> app = appRepo.findById(appId);
//      if(app.isPresent()) {
//    	  
//    	  CitizenAppEntity citizenAppEntity =  app.get();
//    	  	     LocalDate dob   =   citizenAppEntity.getDob();
//    	  	     LocalDate  now =  LocalDate.now();
//    	  	     int age = Period.between(dob, now).getYears();
//   	                                      
//    	  	     if(age >= 65) {
//    	  	    	 response.setPLAN_STATUS("AP");
//    	  	     }
//      }else {
//    	  response.setPLAN_STATUS("DN");
//    	  response.setPLAN_STATUS("Age not matched");
//      }
//					
//		}
				 
				 else if ("MEDICARE".equals(planname)) {

					    Optional<CitizenAppEntity> app = appRepo.findById(appId);

					    if (app.isPresent()) {

					        CitizenAppEntity citizenAppEntity = app.get();

					        LocalDate dob = citizenAppEntity.getDob();
					        LocalDate now = LocalDate.now();

					        int age = Period.between(dob, now).getYears();

					        if (age >= 65) {
					            response.setPLAN_STATUS("AP");
					        } else {
					            response.setPLAN_STATUS("DN");
					            response.setDenialReason("Age not matched");
					        }

					    } else {
					        response.setPLAN_STATUS("DN");
					        response.setDenialReason("Citizen not found");
					    }
					}
		
		
		else if ("NJW".equals(planname)) {
			
			DcEducationEntity educationEntity = eduRepo.findByCaseNum(caseNum);
			
			Integer graduationYear = educationEntity.getGraduationYear();
			
			int currYear = LocalDate.now().getYear();
			if(income.getEmpIncome() <=0 && graduationYear < currYear) {
				
				response.setPLAN_STATUS("AP");
				
			}else {
				
				response.setPLAN_STATUS("DN");
				response.setPLAN_STATUS("Rules not satisfied");
			}
			
		}
		if(response.getPLAN_STATUS().equals("AP")) {
		response.setPlanStartDate(LocalDate.now());
		response.setPlanEndDate(LocalDate.now().plusMonths(6));
		response.setBenefitAmt(350.00);
		
		
		}
		return response;
	}
}
