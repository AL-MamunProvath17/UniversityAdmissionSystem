package com.igate.uas.service;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.exception.UASException;

public interface ApplicantService {

	public boolean addApplication(ApplicationBean application) throws UASException;
	public ApplicationBean showStatus(String applicationId) throws UASException;
}
