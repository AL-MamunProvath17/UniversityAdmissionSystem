package com.igate.uas.action;

import static ch.lambdaj.Lambda.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.bean.UserBean;
import com.igate.uas.exception.UASException;
import com.igate.uas.service.MacService;
import com.igate.uas.service.MacServiceImpl;
import com.igate.uas.utils.CollectionUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * File Name : MacAction.java
 * Class Name : MacAction
 * Description :Mac Action Class
 * Created On : Sep 17, 2012
 * @author : jb804412
 * 
 */
@SuppressWarnings({ "unchecked", "serial" })

public class MacAction extends ActionSupport implements
		ModelDriven<ApplicationBean>, SessionAware,ParameterAware {
	
	ApplicationBean application = new ApplicationBean();
	Map<String, Object> session;
	List<String> applicationIds = new ArrayList<String>();
	List<String> statuss = new ArrayList<String>();
	List<Date> dates = new ArrayList<Date>();
	Map<String, String[]> params;
	
	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
	}
	
	@Override
	public void setParameters(Map<String, String[]> params) {
		this.params = params;
	}
	
	@Override
	public ApplicationBean getModel() {

		return application;
	}

	//All getters and setters method	
	public Map<String, Object> getSession() {
		return session;
	}

	public ApplicationBean getApplication() {
		return application;
	}

	public void setApplication(ApplicationBean application) {
		this.application = application;
	}
	public List<String> getApplicationIds() {
		return applicationIds;
	}

	public void setApplicationIds(List<String> applicationIds) {
		this.applicationIds = applicationIds;
	}

	public List<String> getStatuss() {
		return statuss;
	}

	public void setStatuss(List<String> statuss) {
		this.statuss = statuss;
	}

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}


	//Methods
	
	/**
	 *
	 * @Method_Name getApplied
	 * @Description get Applied Candidates
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * 
	 * returns : String
	 */
	public String getApplied() {
		List<ApplicationBean> applications = (List<ApplicationBean>) session
				.get("applications");
		session.put("page", "applied");
		List<ApplicationBean> filteredApplication;
		filteredApplication = filter(CollectionUtils.applied, applications);
		session.put("filteredApplications", filteredApplication);
		session.put("fromPage","applied");
		return SUCCESS;
	}

	/**
	 *
	 * @Method_Name getAccepted
	 * @Description get Accepted
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * 
	 * returns : String
	 */
	public String getAccepted() {
		List<ApplicationBean> applications = (List<ApplicationBean>) session
				.get("applications");
		List<ApplicationBean> filteredApplication;
		filteredApplication = filter(CollectionUtils.accepted, applications);
		filteredApplication = filter(CollectionUtils.dateMatcher, filteredApplication);
		session.put("filteredApplications", filteredApplication);
		session.put("page", "accepted");
		session.put("fromPage","accepted");
		return SUCCESS;
	}

	/**
	 *
	 * @Method_Name getConfirmed
	 * @Description getConfirmed
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * 
	 * returns : String
	 */
	public String getConfirmed() {
		List<ApplicationBean> applications = (List<ApplicationBean>) session
				.get("applications");
		List<ApplicationBean> filteredApplication;
		filteredApplication = filter(CollectionUtils.confirmed, applications);
		session.put("filteredApplications", filteredApplication);
		session.put("page", "confirmed");
		session.put("fromPage","confirmed");
		return SUCCESS;
	}

	/**
	 *
	 * @Method_Name getRejected
	 * @Description get Rejected Applicants
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * 
	 * returns : String
	 */
	public String getRejected() {
		List<ApplicationBean> applications = (List<ApplicationBean>) session
				.get("applications");
		List<ApplicationBean> filteredApplication;
		filteredApplication = filter(CollectionUtils.rejected, applications);
		session.put("filteredApplications", filteredApplication);
		session.put("page", "rejected");
		session.put("fromPage","rejected");
		return SUCCESS;
	}

	/**
	 *
	 * @Method_Name getFiltered
	 * @Description get Filtered Applicants by Marks
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * 
	 * returns : String
	 */
	public String getFiltered() {
		List<ApplicationBean> applications = (List<ApplicationBean>) session
				.get("applications");
		List<ApplicationBean> filteredApplication;
		String criteria = params.get("page")[0];
		String marks = params.get("filterMarks")[0];
		int filterMarks = Integer.parseInt(marks);
		filteredApplication = filter(CollectionUtils.getMatcher(criteria), applications);
		filteredApplication = filter(CollectionUtils.getMarksFilter(filterMarks), filteredApplication);
		session.put("filteredApplications", filteredApplication);
		return SUCCESS;
	}
	

	/**
	 *
	 * @Method_Name setStatus
	 * @Description set Application Status
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : String
	 */
	public String setStatus() throws UASException {
		MacService macServiceInstance = new MacServiceImpl();
		if (macServiceInstance.setStatus(applicationIds.toArray(new String[1]),
				statuss.toArray(new String[1]), dates.toArray(new Date[1]),
				((UserBean) session.get("user")).getLoginId()))
		{
			getApplicantList();
			String[] page = (String[]) ActionContext.getContext().getParameters()
					.get("page");
			if ("applied".equals(page[0]))
				getApplied();
			if ("accepted".equals(page[0]))
				getAccepted();
			if ("rejected".equals(page[0]))
				getAccepted();
			if ("confirmed".equals(page[0]))
				getAccepted();
			addActionMessage("Status Updated");
			return SUCCESS;
		} else {
			addActionError("Error In Update");
			return INPUT;
		}
	}

	/**
	 *
	 * @Method_Name getApplicantList
	 * @Description get Applicant List
	 * @Created_On Sep 15, 2012
	 * @author jb804412
	 * @throws UASException
	 * 
	 * returns : String
	 */
	public String getApplicantList() throws UASException {
		List<ApplicationBean> applications;
		MacService macServiceInstance = new MacServiceImpl();
		applications = macServiceInstance.getApplicantList(((UserBean) session
				.get("user")).getLoginId());
		session.put("applications", applications);
		session.put("appliedCount", filter(CollectionUtils.applied, applications).size());
		
		List<String> status = new ArrayList<String>();
		status.add("applied");
		status.add("accepted");

		session.put("status", status);

		List<String> newStatus = new ArrayList<String>();
		newStatus.add("accepted");
		newStatus.add("confirmed");

		session.put("newStatus", newStatus);
		return SUCCESS;
	}
	
	public String logOut() {
		session.remove("user");
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
}
