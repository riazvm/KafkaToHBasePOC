/*
 * Copyright (c) 2017 . All rights reserved.
 */

package com.bhp.digital.wfm.hbase.poc.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.digital.kafka.hbase.model.Company;
import com.poc.digital.kafka.hbase.model.User;
import com.poc.digital.kafka.hbase.service.HbaseService;
import com.poc.digital.kafka.hbase.util.HBaseConnection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Method implementation of the HBase operations
 * Method implementation of the HBase operations
 */
 
@Service
public class HbaseServiceImpl implements HbaseService{

	@Autowired
	private HBaseConnection hbaseCon;

	/**
	 * This method creates a user in HBase , this method is called when a user is created 
	 * and the user request is consumed from a Kafka topic
	 * Method implementation of the HBase operations
	 * @param User 
	 * @return Void
	 */	
	@Override
	public void createUser(User userRequest) {
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString= null;
		try {
			jsonString= objMapper.writeValueAsString(userRequest);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			System.out.println(e);
		}
		int rows = upsertUser(userRequest);
		
	}
	/**
	 * This method updates a user in HBase , this method is called when a user is updated 
	 * and the user request is consumed from a Kafka topic
	 * Method implementation of the HBase operations
	 * @param User 
	 * @return Void
	 */
	@Override
	public void updateUser(User userRequest) {

		int rows = upsertUser(userRequest);
	}
	/**
	 * This method creates a company in HBase , this method is called when a company is created 
	 * and the company request is consumed from a Kafka topic
	 * Method implementation of the HBase operations
	 * @param Company 
	 * @return Void
	 */
	@Override
	public void createCompany(Company companyRequest) {

		int rows = upsertCompany(companyRequest);
	}
	/**
	 * This method updates a company in HBase , this method is called when a company is updated 
	 * and the company request is consumed from a Kafka topic
	 * Method implementation of the HBase operations
	 * @param Company 
	 * @return Void
	 */	
	@Override
	public void updateCompany(Company companyRequest) {

		int rows = upsertCompany(companyRequest);
	}

	/**
	 * This method upserts a user in HBase ,this method is called by both update and create user API's 
	 * Phoenix driver is used to update and isert data into HBASE
	 * @param User 
	 *  @return int - returns the number of rows that were inserted / updated
	 */
	public int upsertUser(User userRequest)
	{
		
		PreparedStatement stmt =null;
		int rows=0;
		try
		{
			Class.forName("org.apache.phoenix.queryserver.client.Driver");
			System.out.println("got connection");
			Connection connection= hbaseCon.connection();
			connection.getMetaData();
			stmt = connection.prepareStatement
					("UPSERT INTO wfmpoc.user(personUniqueID,firstName,lastName,companyName,companyUniqueID,jobTitle,jobClassification,"
							+ "workerCategory,userType,status,supervisorID, middleName,WORKPHONE,CELLPHONE,EMAIL,DOB, GENDER,CITY,"
							+ "PROVINCE,COUNTRY,PLANNEDSTARTDATE,ROSTERSTAYDAYS,ROSTERAWAYDAYS,SHIFT) "
							+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setBigDecimal(1, new BigDecimal(userRequest.getPersonUniqueID().trim()));
			stmt.setString(2, userRequest.getFirstName());
			stmt.setString(3, userRequest.getLastName());
			stmt.setString(4, userRequest.getCompanyName());
			stmt.setString(5, userRequest.getCompanyUniqueID());
			stmt.setString(6, userRequest.getJobTitle());
			stmt.setString(7, userRequest.getJobClassification());
			stmt.setString(8, userRequest.getWorkerCategory());
			stmt.setString(9, userRequest.getUserType());
			stmt.setString(10, userRequest.getStatus());
			stmt.setString(11, userRequest.getSupervisorID());
			stmt.setString(12, userRequest.getMiddleName());
			stmt.setString(13, userRequest.getWorkPhone());
			stmt.setString(14, userRequest.getCellPhone());
			stmt.setString(15, userRequest.getEmailAddress());
			stmt.setString(16, userRequest.getDateOfBirth());
			stmt.setString(17, userRequest.getGender());
			stmt.setString(18, userRequest.getCity());
			stmt.setString(19, userRequest.getProvince());
			stmt.setString(20, userRequest.getCountry());
			stmt.setString(21, userRequest.getPlannedStartDate());
			stmt.setString(22, userRequest.getRosterStayDays());
			stmt.setString(23, userRequest.getRosterAwayDays());
			stmt.setString(24, userRequest.getShift());
           // stmt = connection.prepareStatement("UPSERT INTO wfmpoc.user(personUniqueID,companyUniqueID) VALUES(12345,'615267')");
			
			rows=  stmt.executeUpdate();
			System.out.println(rows+" records got inserted/updated successfully");
			connection.commit();
			stmt.close();
			stmt=null;
		

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	/**
	 * This method upserts a Company in HBase ,this method is called by both update and create user API's 
	 * Phoenix driver is used to update and isert data into HBASE
	 * @param Company 
	 * @return int - returns the number of rows that were inserted / updated
	 */	
	
	public int upsertCompany(Company companyRequest)
	{
		PreparedStatement stmt =null;
		int rows=0;
		try
		{
			Class.forName("org.apache.phoenix.queryserver.client.Driver");
			System.out.println("got connection");
			Connection connection= hbaseCon.connection();
			connection.getMetaData();
			stmt = connection.prepareStatement
					("UPSERT INTO wfmpoc.company(companyID,lastName,companyName,contractorAdminName,contractorAdminEmail) VALUES(?,?,?,?,?)");
			stmt.setBigDecimal(1, new BigDecimal(companyRequest.getCompanyID().trim()));
			stmt.setString(2, "NIL");
			stmt.setString(3, companyRequest.getCompanyName());
			stmt.setString(4, companyRequest.getContractorAdminName());
			stmt.setString(5, companyRequest.getContractorAdminEmail());
			rows=  stmt.executeUpdate();
			System.out.println(rows+" records got inserted/updated successfully");
			connection.commit();
			stmt.close();
			stmt=null;

		

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	



}

