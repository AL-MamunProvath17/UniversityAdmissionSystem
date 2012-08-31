package com.igate.uas.dao;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.exception.UASException;

public interface ApplicantDAO {
	public String addApplication(ApplicationBean application) throws UASException;

}
