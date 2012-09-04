package com.igate.uas.action;

import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ScheduleProgramAction extends ActionSupport implements
		ModelDriven<ProgramScheduledBean> {

	ProgramScheduledBean programScheduled = new ProgramScheduledBean();
	AdminService adminService;

	@Override
	public ProgramScheduledBean getModel() {
		return programScheduled;
	}

	public String scheduleProgram() throws Exception {
		AdminService adminService = getServiceObject();
		boolean result = adminService.scheduleProgram(programScheduled);
		if(result){
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
