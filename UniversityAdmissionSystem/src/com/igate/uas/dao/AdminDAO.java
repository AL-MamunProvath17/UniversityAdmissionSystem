package com.igate.uas.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
public interface AdminDAO {

	/**
	 *
	 * @Method_Name addCollege
	 * @Description adds college
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param college
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean addCollege(CollegeBean college) throws UASException;

	/**
	 *
	 * @Method_Name addDegree
	 * @Description adds degree 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param degree
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean addDegree(DegreeBean degree) throws UASException;

	/**
	 *
	 * @Method_Name offerProgram
	 * @Description offers Program 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param programsOffered
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean offerProgram(ProgramsOfferedBean programsOffered)
			throws UASException;

	/**
	 *
	 * @Method_Name scheduleProgram
	 * @Description Schudule Program
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param programScheduled
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean scheduleProgram(ProgramScheduledBean programScheduled)
			throws UASException;

	/**
	 *
	 * @Method_Name addDegreeToCollege
	 * @Description associates degree to college 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param collegeId
	 * @param degreeId
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean addDegreeToCollege(String collegeId, String degreeId)
			throws UASException;

	/**
	 *
	 * @Method_Name addProgramToDegree
	 * @Description associates Program to Degree 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param collegeId
	 * @param degreeId
	 * @param programId
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean addProgramToDegree(String collegeId, String degreeId,
			String programId) throws UASException;

	/**
	 *
	 * @Method_Name assignMac
	 * @Description assign Mac to scheduleprogram 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param scheduledProgramId
	 * @param loginId
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean assignMac(String scheduledProgramId, String loginId)
			throws UASException;

	/**
	 *
	 * @Method_Name updateCollege
	 * @Description update college details 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param college
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean updateCollege(CollegeBean college) throws UASException;
	
	/**
	 *
	 * @Method_Name updateDegree
	 * @Description update Degree Details 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param degree
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean updateDegree(DegreeBean degree) throws UASException;

	/**
	 *
	 * @Method_Name updateofferProgram
	 * @Description update Program details 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param programsOffered
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean updateofferProgram(ProgramsOfferedBean programsOffered)
			throws UASException;

	/**
	 *
	 * @Method_Name deleteDegree
	 * @Description deletes degree 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param degree
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean deleteDegree(DegreeBean degree) throws UASException;

	/**
	 *
	 * @Method_Name deleteProgram
	 * @Description deletes Program
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param programsOffered
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean deleteProgram(ProgramsOfferedBean programsOffered)
			throws UASException;

	/**
	 *
	 * @Method_Name removeMac
	 * @Description removes mac  
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param loginId
	 * @param scheduleProgramId
	 * @throws UASException
	 * 
	 * returns : boolean
	 */
	public boolean removeMac(String loginId, String scheduleProgramId) throws UASException;

	// select methods

	/**
	 *
	 * @Method_Name getColleges
	 * @Description get List of all Colleges 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : List<CollegeBean>
	 */
	public List<CollegeBean> getColleges() throws UASException;

	/**
	 *
	 * @Method_Name getDegrees
	 * @Description get List of all Degrees 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : List<DegreeBean>
	 */
	public List<DegreeBean> getDegrees() throws UASException;

	/**
	 *
	 * @Method_Name getOfferedPrograms
	 * @Description get List of offered Programs 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : List<ProgramsOfferedBean>
	 */
	public List<ProgramsOfferedBean> getOfferedPrograms() throws UASException;

	/**
	 *
	 * @Method_Name getScheduledPrograms
	 * @Description get list of Scheduled Programs 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : List<ProgramScheduledBean>
	 */
	public List<ProgramScheduledBean> getScheduledPrograms()
			throws UASException;

	/**
	 *
	 * @Method_Name getScheduledPrograms
	 * @Description get Scheduled Programs between Dates 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @param startDate
	 * @param endDate
	 * @throws UASException
	 * 
	 * returns : List<ProgramScheduledBean>
	 */
	public List<ProgramScheduledBean> getScheduledPrograms(Date startDate,
			Date endDate) throws UASException;

	/**
	 *
	 * @Method_Name getCollgeDegreeProgram
	 * @Description Get associated College Degree and Programs 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : Map<CollegeBean,Map<DegreeBean,List<ProgramsOfferedBean>>>
	 */
	public Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> getCollgeDegreeProgram()
			throws UASException;
	
	/**
	 *
	 * @Method_Name getScheduledProgramsInYear
	 * @Description Get Scheduled Programs associated with College and Degree 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : Map<CollegeBean,Map<DegreeBean,List<ProgramsOfferedBean>>>
	 */
	public Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> getScheduledProgramsInYear()
	throws UASException;
	
	//mac
	
	/**
	 *
	 * @Method_Name macMembers
	 * @Description get Mac Members 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : List<String>
	 */
	public List<String> macMembers() throws UASException;
	
	/**
	 *
	 * @Method_Name getAssignedMac
	 * @Description get Assigned MAC 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : Map<String,Map<String,String>>
	 */
	public Map<String,Map<String, String>> getAssignedMac() throws UASException;
}
