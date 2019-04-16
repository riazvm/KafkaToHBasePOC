/*
 * Copyright (c) 2017 Infosys. All rights reserved.
 */

package com.bhp.digital.wfm.hbase.poc.service;

import com.bhp.digital.wfm.hbase.poc.model.Company;
import com.bhp.digital.wfm.hbase.poc.model.User;

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
