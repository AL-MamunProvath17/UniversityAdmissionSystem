package com.igate.uas.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.ApplicantService;
import com.igate.uas.service.ApplicantServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * File Name : ApplicationAction.java
 * Class Name : ApplicationAction
 * Description : Applicant Action
 * Created On : Sep 17, 2012
 * @author : jb804412
 * 
 */
@SuppressWarnings("serial")
public class ApplicationAction extends ActionSupport implements ModelDriven<ApplicationBean>,SessionAware
{

	ApplicationBean application=new ApplicationBean();
	Map<String,Object> session;
	
	public ApplicationBean getApplicant() {
		return application;
	}

	public void setApplicant(ApplicationBean applicant) {
		this.application = applicant;
	}

	@Override
	public ApplicationBean getModel() {
		
		return application;
	}
	
	@Override
	public void setSession(Map<String,Object>  session) {
		this.session=session;
		
	}
	
	/**
	 *
	 * @Method_Name addApplication
	 * @Description adds Application
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : String
	 */
	public String addApplication() throws UASException 
	{
		ApplicantService applicantServiceInstance=new ApplicantServiceImpl();
		if(applicantServiceInstance.addApplication(application))
			{	
				return SUCCESS;
			}
		else 
				return INPUT;
	}
	
	public String showStatus() throws UASException
	{
		ApplicantService applicantServiceInstance=new ApplicantServiceImpl();
		ApplicationBean applicant=applicantServiceInstance.showStatus(application.getApplicationId());
		
		if(applicant!=null)
		{	
			session.put("applicant",applicant);
			return SUCCESS;
		}
		else
			return INPUT;
	}

	
	
	
}
