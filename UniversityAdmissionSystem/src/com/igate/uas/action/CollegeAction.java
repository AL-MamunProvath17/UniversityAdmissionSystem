package com.igate.uas.action;

import java.util.Map;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * File Name : CollegeAction.java
 * Class Name : CollegeAction
 * Description : College Action 
 * Created On : Sep 17, 2012
 * @author : jb804412
 * 
 */
@SuppressWarnings("serial")
public class CollegeAction extends ActionSupport implements
		ModelDriven<CollegeBean> {

	CollegeBean college = new CollegeBean();
	AdminService adminService;
	
	@Override
	public CollegeBean getModel() {
		return college;
	}

	/**
	 *
	 * @Method_Name addCollege
	 * @Description adds College
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
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
	
	/**
	 *
	 * @Method_Name updateCollege
	 * @Description updates College
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @return
	 * @throws Exception
	 * 
	 * returns : String
	 */
	public String updateCollege() throws Exception {
		AdminService adminService = getServiceObject();
		boolean result = adminService.updateCollege(college);
		if(result){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("colleges", adminService.getColleges());
			addActionMessage("Collge Updated Successfully");
			return SUCCESS;
		}
		else{
			addActionError("Not Updated");
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
