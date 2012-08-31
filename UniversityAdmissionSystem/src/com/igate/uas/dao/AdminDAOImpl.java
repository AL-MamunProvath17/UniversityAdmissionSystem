package com.igate.uas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.igate.uas.bean.CollegeBean;
import com.igate.uas.bean.DegreeBean;
import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.exception.UASException;

public class AdminDAOImpl implements AdminDAO {
	Logger logger = Logger.getLogger(DBConnection.class);

	@Override
	public boolean addCollege(CollegeBean college) throws UASException {
		Connection connection = null;
		if (college == null)
			throw new UASException("College Details is Empty");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_add_college(?,?,?,?,?,?)}");
			callableStatement.setString(1, college.getCollegeName());
			callableStatement.setString(2, college.getStreet());
			callableStatement.setString(3, college.getLandmark());
			callableStatement.setString(4, college.getCity());
			callableStatement.setString(5, college.getState());
			callableStatement.setString(6, college.getPincode());
			
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("College Added Successfully");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Insertion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean addDegree(DegreeBean degree) throws UASException {
		Connection connection = null;
		if (degree == null)
			throw new UASException("Degree Details is Empty");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_add_degree(?)}");
			callableStatement.setString(1, degree.getDegreeName());
			
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("Degree Added Successfully");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Insertion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean addDegreeToCollege(String collegeId, String degreeId)
			throws UASException {
		Connection connection = null;
		if (collegeId==null || degreeId == null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_add_degree_to_college(?,?)}");
			callableStatement.setString(1, collegeId);
			callableStatement.setString(2, degreeId);
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("Degree Added Successfully to College");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Insertion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean addProgramToDegree(String collegeId, String degreeId,
			String programId) throws UASException {
		Connection connection = null;
		if (collegeId==null || degreeId == null || programId==null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_add_program_to_degree(?,?,?)}");
			callableStatement.setString(1, collegeId);
			callableStatement.setString(2, degreeId);
			callableStatement.setString(3, programId);
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("Program Added Successfully to Degree");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Insertion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean assignMac(String scheduledProgramId, String loginId)
			throws UASException {
		Connection connection = null;
		if (scheduledProgramId==null || loginId == null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_assign_mac(?,?)}");
			callableStatement.setString(1, scheduledProgramId);
			callableStatement.setString(2, loginId);
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("MAC Successfully assigned to Scheduled Program");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Insertion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean deleteDegree(DegreeBean degree) throws UASException {
		Connection connection = null;
		if (degree==null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_delete_degree(?)}");
			callableStatement.setString(1, degree.getDegreeId());
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("Degree Successfully Deleted");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Deletion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean deleteProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		Connection connection = null;
		if (programsOffered ==null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_delete_program(?)}");
			callableStatement.setString(1, programsOffered.getProgramId());
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("Program Successfully Deleted");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Deletion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean offerProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		Connection connection = null;
		if (programsOffered ==null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_add_program(?,?,?,?,?)}");
			callableStatement.setString(1, programsOffered.getProgramName());
			callableStatement.setString(2, programsOffered.getApplicantEligibility());
			callableStatement.setInt(3, programsOffered.getDuration());
			callableStatement.setString(4, programsOffered.getDegreeCertificateOffered());
			callableStatement.setString(5, programsOffered.getDescription());
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("Program Successfully Added");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Insertion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean removeMac(String loginId) throws UASException {
		Connection connection = null;
		if (loginId ==null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_remove_mac(?)}");
			callableStatement.setString(1, loginId);
			if (callableStatement.execute()) {
				logger.info("Invalid Delete Query");
				return false;
			} else {
				logger.info("MAC Successfully Deleted");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Deletion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean scheduleProgram(ProgramScheduledBean programScheduled)
			throws UASException {
		Connection connection = null;
		if (programScheduled ==null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_schedule_program(?,?,?,?,?,?)}");
			
			callableStatement.setDate(1, new java.sql.Date(programScheduled.getStartDate().getTime()));
			callableStatement.setDate(2, new java.sql.Date(programScheduled.getEndDate().getTime()));
			callableStatement.setInt(3, programScheduled.getSessionPerWeek());
			callableStatement.setString(4, programScheduled.getCollegeId());
			callableStatement.setString(5, programScheduled.getDegreeId());
			callableStatement.setString(6, programScheduled.getProgramId());
			
			if (callableStatement.execute()) {
				logger.info("Invalid Insert Query");
				return false;
			} else {
				logger.info("Program Successfully Scheduled");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Insertion Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean updateDegree(DegreeBean degree) throws UASException {
		Connection connection = null;
		if (degree == null)
			throw new UASException("Degree Details is Empty");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_update_degree(?,?)}");
			callableStatement.setString(1, degree.getDegreeId());
			callableStatement.setString(2, degree.getDegreeName());
			
			if (callableStatement.execute()) {
				logger.info("Invalid Update Query");
				return false;
			} else {
				logger.info("Degree Updated Successfully");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Updation Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}

	@Override
	public boolean updateofferProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		
		Connection connection = null;
		if (programsOffered ==null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_update_program(?,?,?,?,?,?)}");
			callableStatement.setString(1, programsOffered.getProgramId());
			callableStatement.setString(2, programsOffered.getProgramName());
			callableStatement.setString(3, programsOffered.getApplicantEligibility());
			callableStatement.setInt(4, programsOffered.getDuration());
			callableStatement.setString(5, programsOffered.getDegreeCertificateOffered());
			callableStatement.setString(6, programsOffered.getDescription());
			if (callableStatement.execute()) {
				logger.info("Invalid Update Query");
				return false;
			} else {
				logger.info("Program Successfully Updated");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Updation Failed");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new UASException("Connection was unable to Close");
			}
		}
	}


	

	
	
}
