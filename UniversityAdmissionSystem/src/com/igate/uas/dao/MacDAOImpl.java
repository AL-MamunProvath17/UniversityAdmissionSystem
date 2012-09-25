package com.igate.uas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.bean.UserBean;
import com.igate.uas.exception.UASException;
/**
*
* File Name : AdminDAO.java
* Class Name : AdminDAO
* Description : DAO Implementation for Mac
* Created On : Sep 17, 2012
* @author : jb804412
* 
*/
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
			callableStatement.setString(1, application.getApplicationId());
			callableStatement.setString(2, application.getLoginId());
			callableStatement.setString(3, application.getStatus());
			callableStatement.setDate(4, new Date(application
					.getDateOfInterview().getTime()));
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
	public List<ApplicationBean> getApplicantList(String loginId)
			throws UASException {

		List<ApplicationBean> applicationList = new ArrayList<ApplicationBean>();
		Connection connection = null;
		if (loginId == null)
			throw new UASException("Login Id is required");
		connection = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from au_application ap join au_access_permission ac on ac.scheduled_prog_id = ap.scheduled_program_id where ac.login_id = ?");
			preparedStatement.setString(1, loginId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ApplicationBean applicant = new ApplicationBean();
				applicant.setApplicationId(resultSet.getString(1));
				applicant.setFullName(resultSet.getString(2));
				applicant.setDateOfBirth(resultSet.getDate(3));
				applicant.setHighestQualification(resultSet.getString(4));
				applicant.setMarks_obtained(resultSet.getDouble(5));
				applicant.setGoals(resultSet.getString(6));
				applicant.setEmail_id(resultSet.getString(7));
				applicant.setScheduledProgramId(resultSet.getString(8));
				applicant.setStatus(resultSet.getString(9));
				applicant.setDateOfInterview(resultSet.getDate(10));
				applicant.setLoginId(resultSet.getString(11));
				applicationList.add(applicant);
			}
			return applicationList;

		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException(e.getMessage());
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
	public boolean login(UserBean user) throws UASException {

		Connection connection = null;
		if (user == null)
			throw new UASException("User is required");
		connection = DBConnection.getConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select users_role from au_users where login_id=? and users_password=?");
			preparedStatement.setString(1, user.getLoginId());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String userRole = resultSet.getString(1);
				user.setRole(userRole);
				return true;
			} else
				return false;

		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException(e.getMessage());
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

	@Override
	public boolean setStatus(String[] applicationId, String[] status,
			java.util.Date[] doi, String loginId) throws UASException {
		Connection connection = null;
		if (applicationId == null)
			throw new UASException("Application Detail is Empty");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_set_status(?,?,?,?)}");
			connection.setAutoCommit(false);
			for (int i = 0; i < applicationId.length; i++) {
				callableStatement.setString(1, applicationId[i]);
				callableStatement.setString(2, loginId);
				callableStatement.setString(3, status[i]);
				callableStatement.setDate(4, (doi[i]!=null)?new Date(doi[i].getTime()):null);
				if (callableStatement.execute()) {
					logger.info("Invalid Insert Query");
					connection.rollback();
					connection.setAutoCommit(true);
					return false;
				}
			}
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Status set Failed");
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
