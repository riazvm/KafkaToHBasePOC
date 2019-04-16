package com.poc.digital.kafka.hbase.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * Company / Contractor Object
 */

@Data
@JsonInclude(Include.NON_NULL)
public class Company   {
	 private String companyID = null;
	 private String companyName = null;
	 private String contractorAdminName = null;
	 private String contractorAdminEmail = null;
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContractorAdminName() {
		return contractorAdminName;
	}
	public void setContractorAdminName(String contractorAdminName) {
		this.contractorAdminName = contractorAdminName;
	}
	public String getContractorAdminEmail() {
		return contractorAdminEmail;
	}
	public void setContractorAdminEmail(String contractorAdminEmail) {
		this.contractorAdminEmail = contractorAdminEmail;
	}
	
}

