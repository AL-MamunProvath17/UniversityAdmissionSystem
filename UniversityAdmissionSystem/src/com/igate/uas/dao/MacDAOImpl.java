package com.igate.uas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.exception.UASException;

public class MacDAOImpl implements MacDAO {

	Logger logger = Logger.getLogger(DBConnection.class);

	
	@Override
	public boolean setApplicationStatus(ApplicationBean application)
			throws UASException {
		
		Connection connection = null;
		if (application == null)
			throw new UASException("Application Detail is Empty");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
			.prepareCall("{call au_proc_set_status(?,?,?,?)}");
			callableStatement.setString(1,application.getApplicationId());
			callableStatement.setString(2, application.getLoginId());
			callableStatement.setString(3,application.getStatus());
			callableStatement.setDate(4,new Date(application.getDateOfInterview().getTime()));
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("Status Set Successfully");
				return true;
			}
			
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			throw new UASException("Status set Failed");
		}
		finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection is unable to Close");
			}
		}
	}
	
}
