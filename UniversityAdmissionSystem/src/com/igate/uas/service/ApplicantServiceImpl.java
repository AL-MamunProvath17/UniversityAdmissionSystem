package com.igate.uas.service;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.dao.ApplicantDAO;
import com.igate.uas.dao.ApplicantDAOImpl;
import com.igate.uas.exception.UASException;

public class ApplicantServiceImpl implements ApplicantService {

	public ApplicantDAO applicantDaoInstance;
	
	@Override
	public boolean addApplication(ApplicationBean application)
			throws UASException {
		ApplicantDAO applicantDaoInstance=getDaoInstance();
		return applicantDaoInstance.addApplication(application);
		
	}
	

	@Override
	public ApplicationBean showStatus(String applicationId) throws UASException {
		ApplicantDAO applicantDaoInstance=getDaoInstance();
		return applicantDaoInstance.showStatus(applicationId);
	}
	
	private ApplicantDAO getDaoInstance()
	{
		if(applicantDaoInstance==null)
				{applicantDaoInstance=new ApplicantDAOImpl();}
		return applicantDaoInstance;
		
	}



}
