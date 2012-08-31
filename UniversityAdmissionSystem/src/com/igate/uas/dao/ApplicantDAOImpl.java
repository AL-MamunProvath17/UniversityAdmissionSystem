package com.igate.uas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.exception.UASException;

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
			callableStatement.setFloat(4, application.getMarks_obtained());
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
			System.out.println(e.getMessage());
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

}
