package com.igate.uas.service;

import java.util.Date;
import java.util.List;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.bean.DegreeBean;
import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.dao.AdminDAO;
import com.igate.uas.dao.AdminDAOImpl;
import com.igate.uas.exception.UASException;

public class AdminServiceImpl implements AdminService {

	private AdminDAO adminDAO;

	@Override
	public boolean addCollege(CollegeBean college) throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.addCollege(college);
	}

	@Override
	public boolean addDegree(DegreeBean degree) throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.addDegree(degree);
	}

	@Override
	public boolean addDegreeToCollege(String collegeId, String degreeId)
			throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.addDegreeToCollege(collegeId, degreeId);
	}

	@Override
	public boolean addProgramToDegree(String collegeId, String degreeId,
			String programId) throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.addProgramToDegree(collegeId, degreeId, programId);
	}

	@Override
	public boolean assignMac(String scheduledProgramId, String loginId)
			throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.assignMac(scheduledProgramId, loginId);
	}

	@Override
	public boolean deleteDegree(DegreeBean degree) throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.deleteDegree(degree);
	}

	@Override
	public boolean deleteProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.deleteProgram(programsOffered);
	}

	@Override
	public boolean offerProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.offerProgram(programsOffered);
	}

	@Override
	public boolean removeMac(String loginId) throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.removeMac(loginId);
	}

	@Override
	public boolean scheduleProgram(ProgramScheduledBean programScheduled)
			throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.scheduleProgram(programScheduled);
	}

	@Override
	public boolean updateDegree(DegreeBean degree) throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.updateDegree(degree);
	}

	@Override
	public boolean updateofferProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.updateofferProgram(programsOffered);
	}

	private AdminDAO getDAOObject() {
		if (adminDAO == null)
			adminDAO = new AdminDAOImpl();
		return adminDAO;
	}

	//select methods
	
	@Override
	public List<CollegeBean> getColleges() throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.getColleges();
	}

	@Override
	public List<DegreeBean> getDegrees() throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.getDegrees();
	}

	@Override
	public List<ProgramsOfferedBean> getOfferedPrograms() throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.getOfferedPrograms();
	}

	@Override
	public List<ProgramScheduledBean> getScheduledPrograms()
			throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.getScheduledPrograms();
	}

	@Override
	public List<ProgramScheduledBean> getScheduledPrograms(Date startDate,
			Date endDate) throws UASException {
		AdminDAO adminDAO =getDAOObject();
		return adminDAO.getScheduledPrograms(startDate, endDate);
	}
}
