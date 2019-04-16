package com.bhp.digital.wfm.hbase.poc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * Class returns a datase connection
 */
 
@Component
public class HBaseConnection {
	 @Value("${hbase.databaseUri}")
	 private String databaseUri;
	 public Connection connection()
	    {
	        Connection con = null;
	       try {
	            con = DriverManager.getConnection(databaseUri);

	        } catch (SQLException e)
	        {
	            e.printStackTrace();
	        }

	        return con;
	    }
}
