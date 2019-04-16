/*
 * Copyright (c) 2017 . All rights reserved.
 */
package com.poc.digital.kafka.hbase.service;

import com.poc.digital.kafka.hbase.model.Company;
import com.poc.digital.kafka.hbase.model.User;

/**
 * Hbase service Interface
 */
public interface HbaseService {

	//create user in HBase
	public void createUser(User userRequest);
	
	//update user in HBase
	public void updateUser(User userRequest);
	
	//create company in HBase
	public void createCompany(Company companyRequest);
	
	//update company in HBase
	public void updateCompany(Company companyRequest);



}
