package com.igate.uas.service;

import java.util.Date;
import java.util.List;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.bean.UserBean;
import com.igate.uas.dao.MacDAO;
import com.igate.uas.dao.MacDAOImpl;
import com.igate.uas.exception.UASException;

public class MacServiceImpl implements MacService {

	MacDAO macDao;
	private MacDAO getMacDaoInstance()
	{
		if(macDao==null)
			 macDao=new MacDAOImpl();
		return macDao;
	}

	
	@Override
	public boolean setApplicationStatus(ApplicationBean application)
			throws UASException {
		
		MacDAO 	macDao=getMacDaoInstance();
		return macDao.setApplicationStatus(application);
	}
	

	@Override
	public List<ApplicationBean> getApplicantList(String loginId)
			throws UASException {
		MacDAO macDAO=getMacDaoInstance();
		return macDAO.getApplicantList(loginId);
		
	}


	@Override
	public boolean login(UserBean user) throws UASException {
		MacDAO macDAO=getMacDaoInstance();
		return macDAO.login(user);
	}


	@Override
	public boolean setStatus(String[] applicationId, String[] status,
			Date[] doi, String loginId) throws UASException {
		MacDAO 	macDao=getMacDaoInstance();
		return macDao.setStatus(applicationId, status, doi, loginId);
	}

	

	
	
	
	
}
