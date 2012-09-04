package com.igate.uas.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.bean.DegreeBean;
import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport implements SessionAware{
	
	AdminService adminService;
	Map<String, Object> session;
	
	CollegeBean college;
	DegreeBean degree;
	ProgramsOfferedBean offeredProgram;
	ProgramScheduledBean scheduledProgram;
	
	public String loadData() throws Exception{
		AdminService adminService = getServiceObject();
		session.put("colleges", adminService.getColleges());
		session.put("degrees", adminService.getDegrees());
		session.put("offeredPrograms", adminService.getOfferedPrograms());
		return SUCCESS;
	}

	public String LoadScheduleData() throws Exception{
		AdminService adminService = getServiceObject();
		session.put("scheduledData", adminService.getCollgeDegreeProgram());
		
		/*Map<CollegeBean, String> tempMap = new HashMap<CollegeBean, String>();
		CollegeBean mapBean = new CollegeBean();
		mapBean.setCollegeId("test");
		
		tempMap.put(mapBean, "This is from map");
		CollegeBean testBean = new CollegeBean();
		testBean.setCollegeId("test");
		
		session.put("tempMap", tempMap);
		session.put("testBean", testBean);
		
		System.out.println("Map Bean : "+ mapBean);
		System.out.println("Test Bean : "+ testBean);*/
		
		return SUCCESS;
	}
	
	public String addDegreeToCollege() throws Exception{
		AdminService adminService = getServiceObject();
		boolean result =adminService.addDegreeToCollege(college.getCollegeId(), degree.getDegreeId());
		if(result){
			addActionMessage("Degree Added Successfully");
			return SUCCESS;
		}
		else{
			addActionError("Not Added");
			return INPUT;
		}
	}
	
	public String addProgramToDegree() throws Exception{
		AdminService adminService = getServiceObject();
		boolean result =adminService.addProgramToDegree(college.getCollegeId(), degree.getDegreeId(),offeredProgram.getProgramId());
		if(result){
			addActionMessage("Program Added Successfully");
			return SUCCESS;
		}
		else{
			addActionError("Not Added");
			return INPUT;
		}
	}

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

	public CollegeBean getCollege() {
		return college;
	}

	public void setCollege(CollegeBean college) {
		this.college = college;
	}

	public DegreeBean getDegree() {
		return degree;
	}

	public void setDegree(DegreeBean degree) {
		this.degree = degree;
	}

	public ProgramsOfferedBean getOfferedProgram() {
		return offeredProgram;
	}

	public void setOfferedProgram(ProgramsOfferedBean offeredProgram) {
		this.offeredProgram = offeredProgram;
	}

	public ProgramScheduledBean getScheduledProgram() {
		return scheduledProgram;
	}

	public void setScheduledProgram(ProgramScheduledBean scheduledProgram) {
		this.scheduledProgram = scheduledProgram;
	}
	
	
	
}
