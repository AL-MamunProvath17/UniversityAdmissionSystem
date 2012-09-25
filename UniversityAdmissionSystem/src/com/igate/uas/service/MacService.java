package com.igate.uas.service;

import java.util.Date;
import java.util.List;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.bean.UserBean;
import com.igate.uas.exception.UASException;

public interface MacService {
	//this method is not used
	public boolean setApplicationStatus(ApplicationBean application) throws UASException;
	
	public List<ApplicationBean> getApplicantList(String loginId) throws UASException;
	public boolean login(UserBean user) throws UASException;
	public boolean setStatus(String[] applicationId,String[] status,Date[] doi,String loginId) throws UASException;
}
