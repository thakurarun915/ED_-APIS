package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DC_CASES")
public class DcCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseNum;

    private Integer appId;

    private Integer planId;

    // Getter & Setter
    public Long getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(Long caseNum) {
        this.caseNum = caseNum;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    // Parameterized Constructor
    public DcCaseEntity(Long caseNum, Integer appId, Integer planId) {
        super();
        this.caseNum = caseNum;
        this.appId = appId;
        this.planId = planId;
    }

    // Default Constructor
    public DcCaseEntity() {
        super();
    }
}
	


