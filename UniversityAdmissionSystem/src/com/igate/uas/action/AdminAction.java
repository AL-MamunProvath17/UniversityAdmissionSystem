package com.igate.uas.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.bean.DegreeBean;
import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * File Name : AdminAction.java
 * Class Name : AdminAction
 * Description : Admin Action
 * Created On : Sep 17, 2012
 * @author : jb804412
 * 
 */
@SuppressWarnings("serial")
public class AdminAction extends ActionSupport implements SessionAware,ParameterAware{
	
	AdminService adminService;
	Map<String, Object> session;
	Map<String, String[]> params;
	
	/*CollegeBean college;
	DegreeBean degree;
	ProgramsOfferedBean offeredProgram;
	ProgramScheduledBean scheduledProgram;*/
	
	/**
	 *
	 * @Method_Name loadData
	 * @Description loads Data Required for Admin 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String loadData() throws Exception{
		AdminService adminService = getServiceObject();
		session.put("colleges", adminService.getColleges());
		session.put("degrees", adminService.getDegrees());
		session.put("offeredPrograms", adminService.getOfferedPrograms());
		session.put("scheduledData", adminService.getCollgeDegreeProgram());
		return SUCCESS;
	}
	
	/**
	 *
	 * @Method_Name loadCollege
	 * @Description Load College Details
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String loadCollege() throws Exception{
		AdminService adminService = getServiceObject();
		session.put("colleges", adminService.getColleges());
		return SUCCESS;
	}
	
	/**
	 *
	 * @Method_Name loadPrograms
	 * @Description Load Program Details 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String loadPrograms() throws Exception{
		AdminService adminService = getServiceObject();
		session.put("programs", adminService.getOfferedPrograms());
		return SUCCESS;
	}

	/**
	 *
	 * @Method_Name LoadScheduleData
	 * @Description Load Schedule Program Details 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String LoadScheduleData() throws Exception{
		AdminService adminService = getServiceObject();
		session.put("scheduledData", adminService.getCollgeDegreeProgram());
		return SUCCESS;
	}
	
	/**
	 *
	 * @Method_Name addDegreeToCollege
	 * @Description add degree to College 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String addDegreeToCollege() throws Exception
	{
		AdminService adminService = getServiceObject();
		String collegeId = params.get("collegeId")[0];
		String degreeId = params.get("degreeId")[0];
		boolean result =adminService.addDegreeToCollege(collegeId, degreeId);
		if(result){
			addActionMessage("Degree Added Successfully");
			return SUCCESS;
		}
		else{
			addActionError("Not Added");
			return INPUT;
		}
	}
	
	/**
	 *
	 * @Method_Name addProgramToDegree
	 * @Description add Program to Degree 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String addProgramToDegree() throws Exception{
		AdminService adminService = getServiceObject();
		
		String collegeId = params.get("collegeId")[0];
		String degreeId = params.get("degreeId")[0];
		String programId = params.get("programId")[0];
		
		
		//boolean result =adminService.addProgramToDegree(college.getCollegeId(), degree.getDegreeId(),offeredProgram.getProgramId());
		boolean result =adminService.addProgramToDegree(collegeId, degreeId,programId);
		if(result){
			addActionMessage("Program Added Successfully");
			loadData();
			return SUCCESS;
		}
		else{
			addActionError("Not Added");
			return INPUT;
		}
	}

	/**
	 *
	 * @Method_Name LoadMacMembers
	 * @Description Load Mac Members  
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * 
	 * returns : String
	 */
	public String LoadMacMembers() {
		AdminService adminService;
		try {
			adminService = getServiceObject();
			session.put("macMembers", adminService.macMembers());
			
			Map<String, String> scheduled= new HashMap<String, String>();
			
			Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> schduledPrograms = adminService.getScheduledProgramsInYear();
			
			for (CollegeBean college : schduledPrograms.keySet()) {
				for (DegreeBean degree : schduledPrograms.get(college).keySet()) {
					for (ProgramsOfferedBean program : schduledPrograms.get(college).get(degree)) {
						scheduled.put(program.getProgramId(), program.getProgramName());
					}
				}
			}
			session.put("scheduledPrograms", scheduled);
			
			session.put("assignedMac", adminService.getAssignedMac());
			
			return SUCCESS;
		} catch (UASException e) {
			addActionError(e.getMessage());
			return ERROR;
		}

	}
	
	/**
	 *
	 * @Method_Name assignMac
	 * @Description  assigns MAC
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String assignMac() throws Exception{
		try {
			
			String loginId = params.get("loginId")[0];
			String scheduledProgramId = params.get("scheduledProgramId")[0];
			
			AdminService adminService = getServiceObject();
			adminService.assignMac(scheduledProgramId, loginId);
			addActionMessage("MAC is successfully Assigned");
			session.put("assignedMac", adminService.getAssignedMac());
			return SUCCESS;
			
		} catch (Exception e) {
			addActionError(e.getMessage());
			throw e;
		}
	}
	
	/**
	 *
	 * @Method_Name removeMac
	 * @Description removes MAC 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @return
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String removeMac() throws Exception{
		try {
			
			String loginId = params.get("loginId")[0];
			String scheduledProgramId = params.get("scheduledProgramId")[0];
			
			AdminService adminService = getServiceObject();
			adminService.removeMac(loginId, scheduledProgramId);
			addActionMessage("MAC is successfully Removed");
			session.put("assignedMac", adminService.getAssignedMac());
			return SUCCESS;
			
		} catch (Exception e) {
			addActionError(e.getMessage());
			throw e;
		}
	}
	
	
	/**
	 *
	 * @Method_Name editCollege
	 * @Description edit College
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String editCollege() throws Exception{
		try {
			
			String collegeId = params.get("collegeId")[0];
			session.put("collegeId", collegeId);
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
			throw e;
		}
	}
	
	public String deleteCollege() throws Exception{
		try {
			
			String collegeId = params.get("collegeId")[0];
			//adminService.d
			session.put("collegeId", collegeId);
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
			throw e;
		}
	}
	
	public String deleteProgram() throws Exception{
		try {
			
			String programId = params.get("programId")[0];
			//session.put("programId", programId);
			AdminService adminService =getServiceObject();
			ProgramsOfferedBean programsOffered = new ProgramsOfferedBean();
			programsOffered.setProgramId(programId);
			adminService.deleteProgram(programsOffered);
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
			throw e;
		}
	}
	
	
	/**
	 *
	 * @Method_Name editProgram
	 * @Description edit Program 
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @return
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String editProgram() throws Exception{
		try {
			
			String programId = params.get("programId")[0];
			session.put("programId", programId);
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
			throw e;
		}
	}
	
	/**
	 *
	 * @Method_Name getServiceObject
	 * @Description get Service Object
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : AdminService
	 */
	private AdminService getServiceObject() throws UASException
	{
		if(adminService==null)
			adminService =new AdminServiceImpl();
		return adminService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setParameters(Map<String, String[]> params) {
		this.params = params;
	}
	
	
	
}
