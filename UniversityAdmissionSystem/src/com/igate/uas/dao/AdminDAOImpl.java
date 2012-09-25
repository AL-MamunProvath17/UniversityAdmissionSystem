package com.igate.uas.dao;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.xml.DOMConfigurator;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.bean.DegreeBean;
import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.bean.ProgramsOfferedBean;
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

public class AdminDAOImpl implements AdminDAO {
	Logger logger; 



    public AdminDAOImpl(){
    	URL url = Loader.getResource("loggerConfig.xml");
        logger = Logger.getLogger(DBConnection.class);
        DOMConfigurator.configure(url);
    }
	
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
		if (collegeId == null || degreeId == null)
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
		if (collegeId == null || degreeId == null || programId == null)
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
		if (scheduledProgramId == null || loginId == null)
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
		if (degree == null)
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
		if (programsOffered == null)
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
		if (programsOffered == null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_add_program(?,?,?,?,?)}");
			callableStatement.setString(1, programsOffered.getProgramName());
			callableStatement.setString(2, programsOffered
					.getApplicantEligibility());
			callableStatement.setInt(3, programsOffered.getDuration());
			callableStatement.setString(4, programsOffered
					.getDegreeCertificateOffered());
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
	public boolean removeMac(String loginId, String scheduleProgramId) throws UASException {
		Connection connection = null;
		if (loginId == null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_remove_mac(?,?)}");
			callableStatement.setString(1, loginId);
			callableStatement.setString(2, scheduleProgramId);
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
		if (programScheduled == null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_schedule_program(?,?,?,?,?,?)}");

			callableStatement.setDate(1, new java.sql.Date(programScheduled
					.getStartDate().getTime()));
			callableStatement.setDate(2, new java.sql.Date(programScheduled
					.getEndDate().getTime()));
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
		if (programsOffered == null)
			throw new UASException("Empty Details");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_update_program(?,?,?,?,?,?)}");
			callableStatement.setString(1, programsOffered.getProgramId());
			callableStatement.setString(2, programsOffered.getProgramName());
			callableStatement.setString(3, programsOffered
					.getApplicantEligibility());
			callableStatement.setInt(4, programsOffered.getDuration());
			callableStatement.setString(5, programsOffered
					.getDegreeCertificateOffered());
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

	// select mehtos

	@Override
	public List<CollegeBean> getColleges() throws UASException {
		Connection connection = null;
		List<CollegeBean> colleges = new ArrayList<CollegeBean>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from getcolleges");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String collegeId = resultSet.getString(1);
				String collegeName = resultSet.getString(2);
				String street = resultSet.getString(3);
				String landmark = resultSet.getString(4);
				String city = resultSet.getString(5);
				String state = resultSet.getString(6);
				String pincode = resultSet.getString(7);

				colleges.add(new CollegeBean(collegeId, collegeName, street,
						landmark, city, state, pincode));
			}
			return colleges;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("College Retrival Failed");
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
	public List<DegreeBean> getDegrees() throws UASException {
		Connection connection = null;
		List<DegreeBean> degrees = new ArrayList<DegreeBean>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from au_degree_master");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String degreeId = resultSet.getString(1);
				String degreeName = resultSet.getString(2);
				degrees.add(new DegreeBean(degreeId, degreeName));
			}
			return degrees;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Degree Retrival Failed");
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
	public List<ProgramsOfferedBean> getOfferedPrograms() throws UASException {
		Connection connection = null;
		List<ProgramsOfferedBean> offeredPrograms = new ArrayList<ProgramsOfferedBean>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from au_program_offered");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String programId = resultSet.getString(1);
				String programName = resultSet.getString(2);
				String applicantEligibility = resultSet.getString(3);
				int duration = resultSet.getInt(4);
				String degreeCertificateOffered = resultSet.getString(5);
				String description = resultSet.getString(6);

				offeredPrograms.add(new ProgramsOfferedBean(programId,
						programName, applicantEligibility, duration,
						degreeCertificateOffered, description));
			}
			return offeredPrograms;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Offered Programs Retrival Failed");
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
	public List<ProgramScheduledBean> getScheduledPrograms()
			throws UASException {
		Connection connection = null;
		List<ProgramScheduledBean> scheduledPrograms = new ArrayList<ProgramScheduledBean>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from au_program_scheduled");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String scheduledProgramId = resultSet.getString(1);
				Date startDate = resultSet.getDate(2);
				Date endDate = resultSet.getDate(3);
				int sessionPerWeek = resultSet.getInt(4);
				String collegeId = resultSet.getString(5);
				String degreeId = resultSet.getString(6);
				String programId = resultSet.getString(7);

				scheduledPrograms.add(new ProgramScheduledBean(
						scheduledProgramId, startDate, endDate, sessionPerWeek,
						collegeId, degreeId, programId));
			}
			return scheduledPrograms;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Scheduled Programs Retrival Failed");
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
	public List<ProgramScheduledBean> getScheduledPrograms(Date startDate,
			Date endDate) throws UASException {
		Connection connection = null;
		List<ProgramScheduledBean> scheduledPrograms = new ArrayList<ProgramScheduledBean>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from au_program_scheduled where START_DATE = ? and END_DATE = ?");
			preparedStatement
					.setDate(1, new java.sql.Date(startDate.getTime()));
			preparedStatement.setDate(2, new java.sql.Date(endDate.getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String scheduledProgramId = resultSet.getString(1);
				startDate = resultSet.getDate(2);
				endDate = resultSet.getDate(3);
				int sessionPerWeek = resultSet.getInt(4);
				String collegeId = resultSet.getString(5);
				String degreeId = resultSet.getString(6);
				String programId = resultSet.getString(7);

				scheduledPrograms.add(new ProgramScheduledBean(
						scheduledProgramId, startDate, endDate, sessionPerWeek,
						collegeId, degreeId, programId));
			}
			return scheduledPrograms;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Scheduled Programs Retrival Failed");
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
	public Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> getCollgeDegreeProgram()
			throws UASException {
		Connection connection = null;
		Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> collegeMap = new HashMap<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from collegeDegreeProgram");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				String collegeId = resultSet.getString(1);
				String collegeName = resultSet.getString(2);
				String degreeId = resultSet.getString(3);
				String degreeName = resultSet.getString(4);
				String programId = resultSet.getString(5);
				String programName = resultSet.getString(6);
				String description = resultSet.getString(7);

				CollegeBean college = new CollegeBean();
				college.setCollegeId(collegeId);
				college.setCollegeName(collegeName);

				DegreeBean degree = new DegreeBean();
				degree.setDegreeId(degreeId);
				degree.setDegreeName(degreeName);

				ProgramsOfferedBean offeredProgram = new ProgramsOfferedBean();
				offeredProgram.setProgramId(programId);
				offeredProgram.setProgramName(programName);
				offeredProgram.setDescription(description);

				Map<DegreeBean, List<ProgramsOfferedBean>> degreeMap = collegeMap
						.get(college);
				degreeMap = (degreeMap == null) ? new HashMap<DegreeBean, List<ProgramsOfferedBean>>()
						: degreeMap;

				List<ProgramsOfferedBean> offeredProgramList = degreeMap
						.get(degree);
				offeredProgramList = (offeredProgramList == null) ? new ArrayList<ProgramsOfferedBean>()
						: offeredProgramList;

				offeredProgramList.add(offeredProgram);
				degreeMap.put(degree, offeredProgramList);
				collegeMap.put(college, degreeMap);
			}
			return collegeMap;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Scheduled Programs Retrival Failed");
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
	public Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> getScheduledProgramsInYear()
			throws UASException {
		Connection connection = null;
		Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> collegeMap = new HashMap<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select clg.college_id, clg.college_name, deg.degree_id, deg.degree_name, ps.scheduled_program_id, prog.program_name, prog.description from au_program_scheduled ps join au_college_master clg on ps.college_id = clg.college_id join au_college_degree_prog cdp on clg.college_id = cdp.college_id join au_degree_master deg on deg.degree_id = cdp.degree_id join au_program_offered prog on prog.program_id = cdp.program_id where ps.college_id = cdp.college_id  and ps.degree_id = cdp.degree_id  and ps.program_id = cdp.program_id and extract(year from ps.start_date) = extract(year from ?)");
			preparedStatement.setDate(1,
					new java.sql.Date(new Date().getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				String collegeId = resultSet.getString(1);
				String collegeName = resultSet.getString(2);
				String degreeId = resultSet.getString(3);
				String degreeName = resultSet.getString(4);
				String programId = resultSet.getString(5);
				String programName = resultSet.getString(6);
				String description = resultSet.getString(7);

				CollegeBean college = new CollegeBean();
				college.setCollegeId(collegeId);
				college.setCollegeName(collegeName);

				DegreeBean degree = new DegreeBean();
				degree.setDegreeId(degreeId);
				degree.setDegreeName(degreeName);

				ProgramsOfferedBean offeredProgram = new ProgramsOfferedBean();
				offeredProgram.setProgramId(programId);
				offeredProgram.setProgramName(programName);
				offeredProgram.setDescription(description);

				Map<DegreeBean, List<ProgramsOfferedBean>> degreeMap = collegeMap
						.get(college);
				degreeMap = (degreeMap == null) ? new HashMap<DegreeBean, List<ProgramsOfferedBean>>()
						: degreeMap;

				List<ProgramsOfferedBean> offeredProgramList = degreeMap
						.get(degree);
				offeredProgramList = (offeredProgramList == null) ? new ArrayList<ProgramsOfferedBean>()
						: offeredProgramList;

				offeredProgramList.add(offeredProgram);
				degreeMap.put(degree, offeredProgramList);
				collegeMap.put(college, degreeMap);
			}
			return collegeMap;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Scheduled Programs Retrival Failed");
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
	public List<String> macMembers() throws UASException {
		Connection connection = null;
		List<String> macs = new ArrayList<String>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select login_id from au_users where users_role='mac'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String loginId = resultSet.getString(1);
				macs.add(loginId);
			}
			return macs;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Scheduled Programs Retrival Failed");
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
	public Map<String, Map<String, String>> getAssignedMac()
			throws UASException {
		Connection connection = null;
		Map<String, Map<String, String>> macMap = new HashMap<String, Map<String, String>>();
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select ap.login_id,ps.scheduled_program_id, po.program_name from au_access_permission ap join au_program_scheduled ps on ap.scheduled_prog_id = ps.scheduled_program_id join au_program_offered po on ps.program_id = po.program_id");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String loginId = resultSet.getString(1);
				String scheduledProgramId = resultSet.getString(2);
				String programName = resultSet.getString(3);

				Map<String, String> programMap = macMap.get(loginId);
				programMap = (programMap == null) ? new HashMap<String, String>()
						: programMap;

				programMap.put(scheduledProgramId, programName);
				macMap.put(loginId, programMap);
			}
			return macMap;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new UASException("Mac List Retrival Failed");
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
	public boolean updateCollege(CollegeBean college) throws UASException {
		Connection connection = null;
		if (college == null)
			throw new UASException("College Details is Empty");
		try {
			connection = DBConnection.getConnection();
			CallableStatement callableStatement = connection
					.prepareCall("{call au_proc_update_college(?,?,?,?,?,?,?)}");
			callableStatement.setString(1, college.getCollegeId());
			callableStatement.setString(2, college.getCollegeName());
			callableStatement.setString(3, college.getStreet());
			callableStatement.setString(4, college.getLandmark());
			callableStatement.setString(5, college.getCity());
			callableStatement.setString(6, college.getState());
			callableStatement.setString(7, college.getPincode());

			if (callableStatement.execute()) {
				logger.info("Invalid Update Query");
				return false;
			} else {
				logger.info("College Updated Successfully");
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