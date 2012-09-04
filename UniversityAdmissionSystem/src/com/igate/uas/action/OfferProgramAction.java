package com.igate.uas.action;

import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class OfferProgramAction extends ActionSupport implements
		ModelDriven<ProgramsOfferedBean> {

	ProgramsOfferedBean programsOffered = new ProgramsOfferedBean();
	AdminService adminService;

	@Override
	public ProgramsOfferedBean getModel() {
		return programsOffered;
	}

	public String offerProgram() throws Exception {
		AdminService adminService = getServiceObject();
		boolean result = adminService.offerProgram(programsOffered);
		if(result){
			addActionMessage("Program Added Successfully");
			return SUCCESS;
		}
		else{
			addActionError("Not Added");
			return INPUT;
		}
	}

	private AdminService getServiceObject() throws UASException {
		if (adminService == null)
			adminService = new AdminServiceImpl();
		return adminService;
	}
}
