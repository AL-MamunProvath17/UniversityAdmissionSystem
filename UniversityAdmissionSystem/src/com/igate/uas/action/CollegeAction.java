package com.igate.uas.action;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class CollegeAction extends ActionSupport implements
		ModelDriven<CollegeBean> {

	CollegeBean college = new CollegeBean();
	AdminService adminService;
	
	@Override
	public CollegeBean getModel() {
		return college;
	}

	public String addCollege() throws Exception {
		AdminService adminService = getServiceObject();
		boolean result = adminService.addCollege(college);
		if(result){
			addActionMessage("Collge Added Successfully");
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

}
