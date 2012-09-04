package com.igate.uas.action;

import com.igate.uas.bean.DegreeBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class DegreeAction extends ActionSupport implements
		ModelDriven<DegreeBean> {

	DegreeBean degree = new DegreeBean();
	AdminService adminService;
	
	@Override
	public DegreeBean getModel() {
		return degree;
	}

	public String addDegree() throws Exception{
		AdminService adminService = getServiceObject();
		boolean result = adminService.addDegree(degree);
		if(result){
			addActionMessage("Degree Added Successfully");
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
