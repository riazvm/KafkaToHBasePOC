package com.poc.digital.kafka.hbase.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * User Object
 */

@Data
@JsonInclude(Include.NON_NULL)
public class User   {
	private String personUniqueID = null;
	 private String firstName = null;
	 private String middleName = null;
	 private String workPhone = null;
	 private String cellPhone = null;
	 private String lastName = null;
	 private String emailAddress = null;
	 private String companyName = null;
	 private String companyUniqueID = null;
	 private String dateOfBirth = null;
	 private String gender = null;
	 private String city = null;
	 private String province = null;
	 private String country = null;
	 private String jobTitle = null;
	 private String jobClassification = null;
	 private String workerCategory = null;
	 private String plannedStartDate = null;
	 private String rosterStayDays = null;
	 private String rosterAwayDays = null;
	 private String status = null;
	 private String shift = null;
	 private String supervisorName = null;
	 private String supervisorEmail = null;
	 private String userType = null;
	 private String supervisorID = null;
	public String getPersonUniqueID() {
		return personUniqueID;
	}
	public void setPersonUniqueID(String personUniqueID) {
		this.personUniqueID = personUniqueID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyUniqueID() {
		return companyUniqueID;
	}
	public void setCompanyUniqueID(String companyUniqueID) {
		this.companyUniqueID = companyUniqueID;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobClassification() {
		return jobClassification;
	}
	public void setJobClassification(String jobClassification) {
		this.jobClassification = jobClassification;
	}
	public String getWorkerCategory() {
		return workerCategory;
	}
	public void setWorkerCategory(String workerCategory) {
		this.workerCategory = workerCategory;
	}
	public String getPlannedStartDate() {
		return plannedStartDate;
	}
	public void setPlannedStartDate(String plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}
	public String getRosterStayDays() {
		return rosterStayDays;
	}
	public void setRosterStayDays(String rosterStayDays) {
		this.rosterStayDays = rosterStayDays;
	}
	public String getRosterAwayDays() {
		return rosterAwayDays;
	}
	public void setRosterAwayDays(String rosterAwayDays) {
		this.rosterAwayDays = rosterAwayDays;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getSupervisorEmail() {
		return supervisorEmail;
	}
	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getSupervisorID() {
		return supervisorID;
	}
	public void setSupervisorID(String supervisorID) {
		this.supervisorID = supervisorID;
	}

}

