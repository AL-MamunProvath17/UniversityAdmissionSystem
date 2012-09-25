package com.igate.uas.bean;

import java.io.Serializable;
import java.util.Date;



@SuppressWarnings("serial")
public class ApplicationBean implements Serializable{
	private String applicationId;
	private String fullName;
	private Date dateOfBirth;
	private String highestQualification;
	private double marks_obtained;	
	private String goals;
	private String email_id;
	private String scheduledProgramId;
	private String status;
	private Date dateOfInterview;
	private String loginId;
	
	
	public ApplicationBean() {
	
	}
	public ApplicationBean(String applicationId, String fullName,
			Date dateOfBirth, String highestQualification, double marksObtained,
			String goals, String emailId, String scheduledProgramId,
			String status, Date dateOfInterview, String loginId) {
		this.applicationId = applicationId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		marks_obtained = marksObtained;
		this.goals = goals;
		email_id = emailId;
		this.scheduledProgramId = scheduledProgramId;
		this.status = status;
		this.dateOfInterview = dateOfInterview;
		this.loginId = loginId;
	}


	public String getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getHighestQualification() {
		return highestQualification;
	}


	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}


	public double getMarks_obtained() {
		return marks_obtained;
	}


	public void setMarks_obtained(double marksObtained) {
		marks_obtained = marksObtained;
	}


	public String getGoals() {
		return goals;
	}


	public void setGoals(String goals) {
		this.goals = goals;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String emailId) {
		email_id = emailId;
	}


	public String getScheduledProgramId() {
		return scheduledProgramId;
	}


	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDateOfInterview() {
		return dateOfInterview;
	}


	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
	
	
	
}
