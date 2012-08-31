package com.igate.uas.dao;

import com.igate.uas.bean.ApplicationBean;
import com.igate.uas.exception.UASException;

public interface MacDAO {
	public boolean setApplicationStatus(ApplicationBean application) throws UASException;

}
