package com.bhp.digital.wfm.hbase.poc.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * User Wrapper Object
 */
@Data
@JsonInclude(Include.NON_NULL)
public class UserRequest {
	
	private User user;

}