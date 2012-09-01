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

	CollegeBean college;
	AdminService adminService;
	
	@Override
	public CollegeBean getModel() {
		return college;
	}

	protected String addCollege() throws Exception {
		AdminService adminService = getServiceObject();
		boolean result = adminService.addCollege(college);
		return result?SUCCESS:INPUT;
	}

	private AdminService getServiceObject() throws UASException
	{
		if(adminService==null)
			adminService =new AdminServiceImpl();
		return adminService;
	}

}
