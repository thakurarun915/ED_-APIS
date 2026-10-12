package in.ashokit.entity;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CITIZEN_APPS")

public class CitizenAppEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	
	private String fullname;
	
	private String email;
	
	private Long phno;
	
	private String gender;
	
	private Long ssn;
	
	private String stateName;
	
	private LocalDate dob ;
	
	@CreationTimestamp
	private  LocalDate createdDate;
	@UpdateTimestamp
	private LocalDate updateddate;
	
	private String createdBy;
	
	private String updatedBy;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(LocalDate updateddate) {
		this.updateddate = updateddate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public CitizenAppEntity(Integer appId, String fullname, String email, Long phno, String gender, Long ssn,
			String stateName, LocalDate dob, LocalDate createdDate, LocalDate updateddate, String createdBy,
			String updatedBy) {
		super();
		this.appId = appId;
		this.fullname = fullname;
		this.email = email;
		this.phno = phno;
		this.gender = gender;
		this.ssn = ssn;
		this.stateName = stateName;
		this.dob = dob;
		this.createdDate = createdDate;
		this.updateddate = updateddate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public CitizenAppEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
