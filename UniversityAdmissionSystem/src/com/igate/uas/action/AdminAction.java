package com.igate.uas.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport implements SessionAware{
	
	AdminService adminService;
	Map<String, Object> session;
	
	public String loadData() throws Exception{
		AdminService adminService = getServiceObject();
		session.put("colleges", adminService.getColleges());
		session.put("degrees", adminService.getDegrees());
		session.put("offeredPrograms", adminService.getOfferedPrograms());
		return SUCCESS;
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
	
}
