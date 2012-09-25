package com.igate.uas.action;

import java.util.Map;

import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.AdminService;
import com.igate.uas.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * File Name : OfferProgramAction.java
 * Class Name : OfferProgramAction
 * Description : Offer Program Action
 * Created On : Sep 17, 2012
 * @author : jb804412
 * 
 */
@SuppressWarnings("serial")
public class OfferProgramAction extends ActionSupport implements
		ModelDriven<ProgramsOfferedBean> {

	ProgramsOfferedBean programsOffered = new ProgramsOfferedBean();
	AdminService adminService;

	@Override
	public ProgramsOfferedBean getModel() {
		return programsOffered;
	}

	/**
	 *
	 * @Method_Name offerProgram
	 * @Description offers Program
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws Exception
	 * 
	 * returns : String
	 */
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

	public String updateOfferProgram() throws Exception {
		AdminService adminService = getServiceObject();
		boolean result = adminService.updateofferProgram(programsOffered);
		if(result){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("programs", adminService.getOfferedPrograms());
			addActionMessage("Program Update Successfully");
			return SUCCESS;
		}
		else{
			addActionError("Not Updated");
			return INPUT;
		}
	}

	private AdminService getServiceObject() throws UASException {
		if (adminService == null)
			adminService = new AdminServiceImpl();
		return adminService;
	}
}
