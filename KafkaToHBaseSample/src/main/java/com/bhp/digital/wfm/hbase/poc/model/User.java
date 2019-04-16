package com.bhp.digital.wfm.hbase.poc.model;

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

}

