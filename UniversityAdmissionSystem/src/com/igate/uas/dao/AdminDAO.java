package com.igate.uas.dao;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.bean.DegreeBean;
import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.exception.UASException;

public interface AdminDAO {
	
	public boolean addCollege(CollegeBean college) throws UASException;

	public boolean addDegree(DegreeBean degree) throws UASException;

	public boolean offerProgram(ProgramsOfferedBean programsOffered)
			throws UASException;

	public boolean scheduleProgram(ProgramScheduledBean programScheduled)
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

	public boolean removeMac(String loginId)
			throws UASException;
}
