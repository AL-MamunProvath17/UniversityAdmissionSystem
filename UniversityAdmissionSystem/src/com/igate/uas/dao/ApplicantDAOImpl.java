package com.igate.uas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.exception.UASException;
/**
*
* File Name : AdminDAO.java
* Class Name : AdminDAO
* Description : DAO interface for Admin
* Created On : Sep 17, 2012
* @author : jb804412
* 
*/
public class ApplicantDAOImpl implements ApplicantDAO {

	Logger logger = Logger.getLogger(DBConnection.class);

	@Override
	public boolean addApplication(ApplicationBean application)
			throws UASException {
		Connection connection = null;
		if (application == null)
			throw new UASException("Application Detail is Empty");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_add_Application(?,?,?,?,?,?,?,?)}");
			callableStatement.setString(1, application.getFullName());
			callableStatement.setDate(2, new Date(application.getDateOfBirth()
					.getTime()));
			callableStatement.setString(3, application
					.getHighestQualification());
			callableStatement.setDouble(4, application.getMarks_obtained());
			callableStatement.setString(5, application.getGoals());
			callableStatement.setString(6, application.getEmail_id());
			callableStatement.setString(7, application.getScheduledProgramId());
			callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);

			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				String applicationId = callableStatement.getString(8);
				logger.info("Application Added Successfully");
				application.setApplicationId(applicationId);
				return true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Application Insertion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection is unable to Close");
			}
		}
	}

	@Override
	public ApplicationBean showStatus(String applicationId) throws UASException {
		
		Connection connection = null;
		if (applicationId == null)
			throw new UASException("Application Id is Empty");
		connection = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from au_application where application_id=?");
			preparedStatement.setString(1,applicationId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				ApplicationBean application=new ApplicationBean();
				application.setApplicationId(resultSet.getString(1));
				application.setFullName(resultSet.getString(2));
				application.setDateOfBirth(resultSet.getDate(3));
				application.setHighestQualification(resultSet.getString(4));
				application.setMarks_obtained(resultSet.getDouble(5));
				application.setGoals(resultSet.getString(6));
				application.setEmail_id(resultSet.getString(7));
				application.setScheduledProgramId(resultSet.getString(8));
				application.setStatus(resultSet.getString(9));
				application.setDateOfInterview(resultSet.getDate(10));
				application.setLoginId(resultSet.getString(11));
				return application;
				
			}
			else	
				throw new UASException("Application Id not found please Enter Proper Application Id");
		} 
		catch (SQLException e) {
			throw new UASException("Not Able to find record");
			
		}finally {
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
