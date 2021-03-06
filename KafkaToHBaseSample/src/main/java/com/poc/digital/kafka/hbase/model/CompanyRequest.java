package com.poc.digital.kafka.hbase.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Company / Contractor Wrapper Object
 */
@Data
@JsonInclude(Include.NON_NULL)
public class CompanyRequest {
	
	private Company company;

}
