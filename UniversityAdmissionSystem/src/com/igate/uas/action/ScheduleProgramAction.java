package com.igate.uas.action;

import org.apache.struts2.ServletActionContext;

import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * File Name : ScheduleProgramAction.java
 * Class Name : ScheduleProgramAction
 * Description : Schedule Program Action
 * Created On : Sep 17, 2012
 * @author : jb804412
 * 
 */
@SuppressWarnings("serial")
public class ScheduleProgramAction extends ActionSupport implements
		ModelDriven<ProgramScheduledBean> {

	ProgramScheduledBean programScheduled = new ProgramScheduledBean();
	AdminService adminService;

	@Override
	public ProgramScheduledBean getModel() {
		return programScheduled;
	}

	
	
	/**
	 *
	 * @Method_Name scheduleProgram
	 * @Description scheduls Programs
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String scheduleProgram() throws Exception {
		String appPath = ServletActionContext.getServletContext().getRealPath("/");
		AdminService adminService = getServiceObject();
		boolean result = adminService.scheduleProgram(programScheduled, appPath);
		if(result)
		{
			addActionMessage("Program Scheduled Successfully");
			return SUCCESS;
		}
		else{
			addActionError("Not Scheduled");
			return INPUT;
		}
	}
	
	private AdminService getServiceObject() throws UASException {
		if (adminService == null)
			adminService = new AdminServiceImpl();
		return adminService;
	}

	public ProgramScheduledBean getProgramScheduled() {
		return programScheduled;
	}

	public void setProgramScheduled(ProgramScheduledBean programScheduled) {
		this.programScheduled = programScheduled;
	}

}
