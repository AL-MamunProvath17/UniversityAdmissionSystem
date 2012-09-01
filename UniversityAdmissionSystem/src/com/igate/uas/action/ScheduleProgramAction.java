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

	ProgramScheduledBean programScheduled;
	AdminService adminService;

	@Override
	public ProgramScheduledBean getModel() {
		return programScheduled;
	}

	protected String scheduleProgram() throws Exception {
		AdminService adminService = getServiceObject();
		boolean result = adminService.scheduleProgram(programScheduled);
		return result ? SUCCESS : INPUT;
	}

	private AdminService getServiceObject() throws UASException {
		if (adminService == null)
			adminService = new AdminServiceImpl();
		return adminService;
	}

}
