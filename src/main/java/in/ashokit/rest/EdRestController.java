package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.response.EligResponse;
import in.ashokit.service.EligServiceimpl;

@RestController
public class EdRestController {
	
	@Autowired
	private EligServiceimpl service ;

	
	@GetMapping("/eligibility/{caseNum}")
	public EligResponse determineEligibility(@PathVariable Long caseNum) {
		
		EligResponse eligResponse = service.determineEligibility(caseNum);
		
		
		return eligResponse;
	}
	
	
	
	
}
