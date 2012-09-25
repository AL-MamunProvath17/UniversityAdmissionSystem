package com.igate.uas.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.bean.DegreeBean;
import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.exception.UASException;

public interface AdminService {

	public boolean addCollege(CollegeBean college) throws UASException;

	public boolean addDegree(DegreeBean degree) throws UASException;

	public boolean offerProgram(ProgramsOfferedBean programsOffered)
			throws UASException;

	public boolean scheduleProgram(ProgramScheduledBean programScheduled, String appPath)
			throws UASException;

	public boolean addDegreeToCollege(String collegeId, String degreeId)
			throws UASException;

	public boolean addProgramToDegree(String collegeId, String degreeId,
			String programId) throws UASException;

	public boolean assignMac(String scheduledProgramId, String loginId)
			throws UASException;

	public boolean updateDegree(DegreeBean degree) throws UASException;

	public boolean updateofferProgram(ProgramsOfferedBean programsOffered)
			throws UASException;

	public boolean deleteDegree(DegreeBean degree) throws UASException;

	public boolean deleteProgram(ProgramsOfferedBean programsOffered)
			throws UASException;

	public boolean removeMac(String loginId, String scheduleProgramId)
			throws UASException;
	
	// select methods

	public List<CollegeBean> getColleges() throws UASException;

	public List<DegreeBean> getDegrees() throws UASException;

	public List<ProgramsOfferedBean> getOfferedPrograms() throws UASException;

	public List<ProgramScheduledBean> getScheduledPrograms()
			throws UASException;

	public List<ProgramScheduledBean> getScheduledPrograms(Date startDate,Date endDate)
	throws UASException;
	
	public Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> getCollgeDegreeProgram()
	throws UASException;
	
	// xml methods
	
	public void createNavigationXML(String appPath) throws UASException;
	
	public void createContentXML(Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> collegeMap, String appPath) throws UASException;
	
	//mac
	
	public List<String> macMembers() throws UASException;
	
	public Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> getScheduledProgramsInYear()
	throws UASException;
	
	public Map<String,Map<String, String>> getAssignedMac() throws UASException;

	public boolean updateCollege(CollegeBean college) throws UASException;
}
