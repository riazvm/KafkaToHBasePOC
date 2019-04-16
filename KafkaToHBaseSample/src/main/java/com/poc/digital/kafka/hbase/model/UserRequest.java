package com.poc.digital.kafka.hbase.model;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
